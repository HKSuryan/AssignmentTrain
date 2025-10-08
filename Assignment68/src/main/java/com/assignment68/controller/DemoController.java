package com.assignment68.controller;

import java.util.NoSuchElementException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {
	@GetMapping("/find/{id}")
	public String findUser(@PathVariable Long id) {
		throw new NoSuchElementException("User Missing");
	}
}
