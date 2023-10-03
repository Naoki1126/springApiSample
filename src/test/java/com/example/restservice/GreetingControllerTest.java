package com.example.restservice;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.logics.DateTimeUtil;

@SpringBootTest
@AutoConfigureMockMvc
public class GreetingControllerTest {

	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	DateTimeUtil mockDateTimeUtil;
	
	
	
	@Test
	void case001() throws Exception {
		
		// モックの準備
		when(mockDateTimeUtil.getCurrentDateTime()).thenReturn(LocalDateTime.of(2022,10, 1, 00, 00, 00));
		
		String result = mockMvc.perform(get("/greeting")).andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);
		
		
		System.out.println(result);
		
	}
}
