package com.example.demo.services;



import com.example.demo.request.UserCredentials;

public interface AuthService {
	
	
 String authenticateUser(UserCredentials user);
 
 String signUp(UserCredentials user);
 
}

