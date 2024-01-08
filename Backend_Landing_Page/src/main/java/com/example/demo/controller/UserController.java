package com.example.demo.controller;
//UserController.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.request.UserCredentials;
import com.example.demo.services.AuthService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
    private AuthService authService;

 @PostMapping("/signin")
 public ResponseEntity<String> signIn(@RequestBody UserCredentials userCredentials) {
    
	 String token = authService.authenticateUser(userCredentials);

     if (token != null) {
         return ResponseEntity.ok(token);
     } else {
         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
     }
    
 }

 @PostMapping("/signup")
 public String signUp(@RequestBody UserCredentials userCredentials) {
     
	 String Message=authService.signUp(userCredentials);
	 
     return "Sign Up Successful";
 }
}
