package com.assignment2.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment2.util.JwtUtil;

@RestController
@RequestMapping("/api")
public class HelloController {
	// generate TOken
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestParam String username){
		String token= JwtUtil.generateToken(username);
		return ResponseEntity.ok("Generated Token: "+token);
	}
	
	@GetMapping("/hello")
	public ResponseEntity<?> hello(Authentication authentication){
		String username = authentication.getName();
		return ResponseEntity.ok("Hello"+username+"You are authenticated");
	}
}
