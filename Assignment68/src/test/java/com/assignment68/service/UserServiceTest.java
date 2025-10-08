package com.assignment68.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.assignment68.model.User;
import com.assignment68.repository.UserRepository;

import io.micrometer.core.instrument.Timer;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Autowired
	private MockMvc mockMvc;
	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private UserService userService;
//	 @Test
//	    void shouldReturnUserName_whenUserExists1() {
//	    	PrometheusMeterRegistry registry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);
//	        Timer timer = registry.timer("application.process.time");  
//	        timer.record(()->{
//				User user = new User(1L, "Alice");
//		        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
//
//		        String result = userService.getUserNameById(1L);
//
//		        assertEquals("Alice", result);
//		        verify(userRepository).findById(1L);
//			});
//	        
//	        System.out.println(registry.scrape());
//
//	       
//	    }
//	 @Test
//	 void shouldReturnUserNameFromDatabase_whenUserExists1() {
//	    PrometheusMeterRegistry registry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);
//	    Timer timer = registry.timer("application.process.time");  
//	    timer.record(()->{
//			try {
//				mockMvc.perform(get("/users/1"))
//				.andExpect(status().isOk())
//				.andExpect(jsonPath("$.name").value("Alice"));
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			});
//	        
//	        System.out.println("From Database "+registry.scrape());
//
//	       
//	    }
	@Test
	void shouldReturnUserName_whenUserExists() {
		User user = new User();
		user.setName("Alice");
		user.setId(1L);
		
		when(userRepository.findById(1L)).thenReturn(Optional.of(user));
		
		String result = userService.getUserNameById(1L);
		assertEquals("Alice",result);
		
		verify(userRepository).findById(1L);
		
		
	}
	@Test
	void shouldReturnUnknown_whenUserNotFound() {
		when(userRepository.findById(2L)).thenReturn(Optional.empty());
		String result = userService.getUserNameById(2L);
		
		assertEquals("Unknown",result);
	}
	
	
}
