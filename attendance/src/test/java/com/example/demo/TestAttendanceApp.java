package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class TestAttendanceApp extends AttendanceApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testStudentDetails() throws Exception {
		mockMvc.perform(get("/student")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8")).andExpect(jsonPath("$.id").value(1))
				.andExpect(jsonPath("$.firstName").value("Shubham")).andExpect(jsonPath("$.lastName").value("Jain"))
				.andExpect(jsonPath("$.year").value("BE"));

	}
	
	@Test
	public void testStudentDetailsByDate() throws Exception {
		mockMvc.perform(get("/attendance/2019-11-23")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8")).andExpect(jsonPath("$.id").value(1))
				.andExpect(jsonPath("$.firstName").value("Shubham")).andExpect(jsonPath("$.lastName").value("Jain"))
				.andExpect(jsonPath("$.year").value("BE"));

	}
}
