package com.assignment68.service;

import org.springframework.stereotype.Service;

import com.assignment68.model.User;
import com.assignment68.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public String getUserNameById(Long id) {
		return userRepository.findById(id)
		.map(User::getName)
		.orElse("Unknown");

	}
}
