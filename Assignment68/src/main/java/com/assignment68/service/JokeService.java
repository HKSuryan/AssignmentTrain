package com.assignment68.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class JokeService {
	private final RestTemplate restTemplate;
	
	public JokeService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public String getJoke() {
		String response = restTemplate.getForObject("https://api.chucknorris.io/jokes/random", String.class);
		
		return response;
	}
}
