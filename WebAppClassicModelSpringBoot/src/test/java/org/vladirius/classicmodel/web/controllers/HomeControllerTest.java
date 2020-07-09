package org.vladirius.classicmodel.web.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;

import utilsTests.MvcBaseTest;

class HomeControllerTest extends MvcBaseTest{
	
	@Test
	public void testIndex() throws Exception {
		this.mockMvc
			.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(view().name("index"))
			.andReturn();
	}

	@Test
	void testContact() throws Exception {
		this.mockMvc
		.perform(get("/contact"))
		.andExpect(status().isOk())
		.andExpect(view().name("contact"))
		.andReturn();
	}

}
