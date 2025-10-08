package com.assignment68.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.openjdk.jmh.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.assignment68.model.User;
import com.assignment68.repository.UserRepository;

@WebMvcTest(UserController.class)
public class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserRepository userRepository;
	
	@Test
	void shouldReturnUser_whenExists()throws Exception{
		when(userRepository.findById(1L)).thenReturn(java.util.Optional.of(new User(1L,"Alice")));
		
		mockMvc.perform(get("/users/1"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.name").value("Alice"));
	}

}
