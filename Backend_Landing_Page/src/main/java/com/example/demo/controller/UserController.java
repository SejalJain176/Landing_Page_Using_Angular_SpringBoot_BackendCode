package com.example.demo.controller;
//UserController.java

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List; 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.repositories.CourseRepository;


import com.example.demo.request.Courses;
import com.example.demo.request.UserCredentials;
import com.example.demo.services.AuthService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
    private AuthService authService;
	
	 @Autowired
	private CourseRepository courseRepository;
	

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
	public ResponseEntity<String> signUp(@RequestBody UserCredentials userCredentials) {

		
		String Message = authService.signUp(userCredentials);

		if (Message!=null) {
			return ResponseEntity.ok(Message);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid UserName");
		}
	}
	
	@GetMapping("courses")
	public ResponseEntity<List<Courses>> getCoursesList(){
		
		List courses = courseRepository.findAll();
		
		if (courses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
		return new ResponseEntity<>(courses,HttpStatus.OK);
		
	}
	
	@GetMapping("userCourses")
	public ResponseEntity<List<Courses>> getUserCoursesList(){
		
		List courses = courseRepository.findAll();
		
		if (courses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
		return new ResponseEntity<>(courses,HttpStatus.OK);
		
	}
}

