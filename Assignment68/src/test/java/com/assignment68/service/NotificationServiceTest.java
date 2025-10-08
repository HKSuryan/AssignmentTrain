package com.assignment68.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class NotificationServiceTest {
	private final NotificationService notificationService = new NotificationService();
	
	@Test
	void shouldSendEmailAsyncSuccessfully()throws Exception{
		CompletableFuture<String> future = notificationService.sendEmailAsync("test@example.com");
		String result = future.get(1,TimeUnit.SECONDS);
		assertEquals("Email sent to test@example.com",result);
	}
	
}
