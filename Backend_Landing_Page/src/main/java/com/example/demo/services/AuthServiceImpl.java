package com.example.demo.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.UserRepository;
import com.example.demo.request.UserCredentials;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

//AuthServiceImpl.java
@Service
public class AuthServiceImpl implements AuthService {

	
	@Autowired
    private UserRepository userRepository;

    public String signUp(UserCredentials user) {
        // to check if the username is already taken
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return "Username is already taken. Choose another one.";
        }

        // Save the user to the database
        userRepository.save(user);

        return "User successfully signed up!";
    }
    
 @Override
 public String authenticateUser(UserCredentials user) {
    
     if ("validUsername".equals(user.getUsername()) && "validPassword".equals(user.getPassword())) {
         return generateJwtToken(user.getUsername());
     }

     
     return null;
 }

 private String generateJwtToken(String username) {
     
     return Jwts.builder()
             .setSubject(username)
             .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 24 hours
             .signWith(SignatureAlgorithm.HS512, "abc987h-pokkk9099799(((())#89908nmbjn")
             .compact();
 }


 
 
}

