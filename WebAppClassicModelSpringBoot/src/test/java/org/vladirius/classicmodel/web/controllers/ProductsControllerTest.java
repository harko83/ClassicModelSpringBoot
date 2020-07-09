package org.vladirius.classicmodel.web.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.vladirius.classicmodel.data.repositories.ProductRepository;

import utilsTests.MvcBaseTest;


class ProductsControllerTest extends MvcBaseTest {

	@MockBean
	ProductRepository productRepositoryMock;
	
	private static final String BASE_URL = "/products";
	
	@Test
	public void testProducts() throws Exception {
		// Show the catalog page
		this.mockMvc.perform(get(BASE_URL))
					// HTTP 200 returned
					.andExpect(status().isOk())
					// Controller forwards to correct view
					.andExpect(view().name("catalog"))
					// Set the right model
					.andExpect(model().attribute("products", productRepositoryMock.findAll()))
					.andReturn();
	}

	@Test
	void testProductsByCars() throws Exception {
		this.mockMvc.perform(post(BASE_URL+ProductsController.CLASSIC_CARS_URL).param("button", "Classic Cars"))
		.andExpect(status().isOk())
		.andExpect(view().name("catalog"))
		.andExpect(model().attribute("products", productRepositoryMock.findProductsByCategories("Classic Cars")))
		.andReturn();
	}

	@Test
	void testProductsByMoto() throws Exception {
		this.mockMvc.perform(post(BASE_URL+ProductsController.MOTORCYCLES_URL).param("button", "Motorcycles"))
		.andExpect(status().isOk())
		.andExpect(view().name("catalog"))
		.andExpect(model().attribute("products", productRepositoryMock.findProductsByCategories("Motorcycles")))
		.andReturn();
	}

	@Test
	void testProductsByPlanes() throws Exception {
		this.mockMvc.perform(post(BASE_URL+ProductsController.PLANES_URL).param("button", "Planes"))
		.andExpect(status().isOk())
		.andExpect(view().name("catalog"))
		.andExpect(model().attribute("products", productRepositoryMock.findProductsByCategories("Planes")))
		.andReturn();
	}

	@Test
	void testProductsByShips() throws Exception{
		this.mockMvc.perform(post(BASE_URL+ProductsController.SHIPS_URL).param("button", "Ships"))
		.andExpect(status().isOk())
		.andExpect(view().name("catalog"))
		.andExpect(model().attribute("products", productRepositoryMock.findProductsByCategories("Ships")))
		.andReturn();
	}

	@Test
	void testProductsByTrains() throws Exception{
		this.mockMvc.perform(post(BASE_URL+ProductsController.TRAINS_URL).param("button", "Trains"))
		.andExpect(status().isOk())
		.andExpect(view().name("catalog"))
		.andExpect(model().attribute("products", productRepositoryMock.findProductsByCategories("Trains")))
		.andReturn();
	}

	@Test
	void testProductsByTruckAndBuses() throws Exception{
		this.mockMvc.perform(post(BASE_URL+ProductsController.TRUCKSANDBUSES_URL).param("button", "Trucks and Buses"))
		.andExpect(status().isOk())
		.andExpect(view().name("catalog"))
		.andExpect(model().attribute("products", productRepositoryMock.findProductsByCategories("Trucks and Buses")))
		.andReturn();
	}

	@Test
	void testProductsByVintageCars() throws Exception{
		this.mockMvc.perform(post(BASE_URL+ProductsController.VINTAGECARS_URL).param("button", "Vintage Cars"))
		.andExpect(status().isOk())
		.andExpect(view().name("catalog"))
		.andExpect(model().attribute("products", productRepositoryMock.findProductsByCategories("Vintage Cars")))
		.andReturn();
	}

}
