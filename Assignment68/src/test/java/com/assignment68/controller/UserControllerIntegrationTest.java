package com.assignment68.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.assignment68.model.User;
import com.assignment68.repository.UserRepository;
import com.assignment68.service.UserService;

import io.micrometer.core.instrument.Timer;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@BeforeEach
	void setup() {
		//userRepository.deleteAll();
		//User user  = new User(1l,"Alice");
		User user = new User();
		user.setName("Alice");
		//user.setId(1L);
		
//		user.setVersion(2);
		userRepository.save(user);
		
	}
	 @Test
	 void shouldReturnUserNameFromDatabase_whenUserExists1() {
	    PrometheusMeterRegistry registry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);
	    Timer timer = registry.timer("application.process.time");  
	    timer.record(()->{
			try {
				mockMvc.perform(get("/users/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("Alice"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			});
	        
	        System.out.println(registry.scrape());

	       
	    }
	@Test
	void shouldReturnUserFromDatabase()throws Exception {
		mockMvc.perform(get("/users/1"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.name").value("Alice"));
		
	}
	
	@Test
	void shouldReturnNotFoundErrorForMissingUser()throws Exception{
		mockMvc.perform(get("/users/99"))
		.andExpect(status().isNotFound());
	}
}
