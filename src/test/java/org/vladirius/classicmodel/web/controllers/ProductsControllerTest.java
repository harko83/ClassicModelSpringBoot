package org.vladirius.classicmodel.web.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.vladirius.classicmodel.data.repositories.ProductRepository;
import org.vladirius.classicmodel.service.ProductsService;

import utilsTests.MvcBaseTest;

class ProductsControllerTest extends MvcBaseTest {
	
	final private Logger LOG = LoggerFactory.getLogger(ProductsControllerTest.class);
	
	@MockBean
	ProductsService productServiceMock;
	
	private static final String BASE_URL = "/products";
	private static final String CATEGORIES = "/cat";
	
	/*
	 * Products()
	 * should return view catalog and 
	 * model fill by services.getproducts()
	 */
	@Test
	public void testProducts() throws Exception {
		// Show the catalog page
		this.mockMvc.perform(get(BASE_URL))
					// HTTP 200 returned
					.andExpect(status().isOk())
					// Controller forwards to correct view
					.andExpect(view().name("catalog"))
					// Set the right model
					.andExpect(model().attribute("products", productServiceMock.getProducts()))
					.andReturn();
	}

	/*
	 * ProductsByCategories()
	 * receive a parameter and 
	 * should return view catalog and 
	 * model fill by services.findProductsByCategories()
	 */
	@Test
	void testProductsByCategories() throws Exception {
		// Show the catalog page and send param by the button
		this.mockMvc.perform(post(BASE_URL+CATEGORIES).param("button", "Classic Cars"))
					// HTTP 200 returned
					.andExpect(status().isOk())
					// Controller forwards to correct view
					.andExpect(view().name("catalog"))
					// Set the right model
					.andExpect(model().attribute("products", productServiceMock.findProductsByCategories("Classic Cars")))
					.andReturn();
	}

}
