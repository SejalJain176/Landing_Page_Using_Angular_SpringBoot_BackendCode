package com.example.demo.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.UserRepository;
import com.example.demo.request.UserCredentials;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

//AuthServiceImpl.java
@Service
public class AuthServiceImpl implements AuthService {

	
	@Autowired
    private UserRepository userRepository;

    public String signUp(UserCredentials user) {
        // to check if the username is already taken
        if (!userRepository.findByUsername(user.getUsername()).isEmpty()) {
            return null;
        }

        
        userRepository.save(user);

        return "User successfully signed up!";
    }
    
 @Override
 public String authenticateUser(UserCredentials user) {
	String username= user.getUsername();
	
	
	 Optional<UserCredentials> storedUser = userRepository.findByUsername(username);
	 
	 if (storedUser.isPresent()) {
		    UserCredentials user1 = storedUser.get();
		    String Password = user1.getPassword();
		    
		    if(user.getPassword().equals(Password)) {
		    	 return generateJwtToken(user.getUsername());

		    }
		} 
	 return null;
 }

 private String generateJwtToken(String username) {
     
	 Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
     return Jwts.builder()
             .setSubject(username)
             .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 24 hours
             .signWith(key)
             .compact();
 }


 
 
}

