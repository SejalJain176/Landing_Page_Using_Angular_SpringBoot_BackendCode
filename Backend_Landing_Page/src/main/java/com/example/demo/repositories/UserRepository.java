package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.request.UserCredentials;

public interface UserRepository extends JpaRepository<UserCredentials, String> {
	    Optional<UserCredentials> findByUsername(String username);
	    
	}


