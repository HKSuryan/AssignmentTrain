package com.assignment68.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {
	public CompletableFuture<String> sendEmailAsync(String email){
		return CompletableFuture.supplyAsync(()->{
			try {
				Thread.sleep(500);
				return "Email sent to "+email;
			}
			catch(Exception e) {
				e.printStackTrace();
				throw new IllegalStateException("Error Sending Email");
			}
		});
	}
}
