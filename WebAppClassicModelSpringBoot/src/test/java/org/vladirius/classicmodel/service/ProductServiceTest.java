package org.vladirius.classicmodel.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.vladirius.classicmodel.data.models.ProductlinesEntity;
import org.vladirius.classicmodel.data.models.ProductsEntity;
import org.vladirius.classicmodel.data.repositories.ProductRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ProductServiceTest {
	
	private static final Logger LOG = LoggerFactory.getLogger(ProductServiceTest.class);
	
	@Mock
	private ProductRepository productRepository;
	
	@Mock
	private ProductsEntity product;
	
	@Mock
	private ProductlinesEntity productLine;
	
	@InjectMocks
	private ProductsService service;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetProducts_ShouldCallRepositoryFindAll() {
		List<ProductsEntity> productList = new ArrayList<ProductsEntity>();
		productLine = new ProductlinesEntity();
		productLine.setProductLine("productLine01");
		productList.add(new ProductsEntity("productCode01", "productName01", productLine, "productScale01", 
											"productVendor01", "productDesc01", 1, 1.11, 1.11));
		productLine = new ProductlinesEntity();
		productLine.setProductLine("productLine02");
		productList.add(new ProductsEntity("productCode02", "productName02", productLine, "productScale02", 
											"productVendor02", "productDesc02", 2, 2.22, 2.22));
		productLine = new ProductlinesEntity();
		productLine.setProductLine("productLine03");
		productList.add(new ProductsEntity("productCode03", "productName03", productLine, "productScale03",
											"productVendor03", "productDesc03", 3, 3.33, 3.33));
		LOG.info("Test findAll() - findAll() to return \n"+ productList.toString());
		//When
		when(productRepository.findAll()).thenReturn(productList);
		LOG.info("TestFindAll() - findAll calling");
		List<ProductsEntity> result = service.getProducts();
		LOG.info("TestFindALl() - Verifying findAll() is called at least once");
		verify(productRepository, atLeastOnce()).findAll();
		LOG.info("TestFindALl() - Asserting that the result is not null or empty");
		assertNotNull(result);
		assertFalse(result.isEmpty());
	}

	@Test
	void testFindProductsByCategories() {
		List<ProductsEntity> productList = new ArrayList<ProductsEntity>();
		productLine = new ProductlinesEntity();
		productLine.setProductLine("productLine01");
		productList.add(new ProductsEntity("productCode01", "productName01", productLine, "productScale01",
											"productVendor01", "productDesc01", 1, 1.11, 1.11));
		productLine = new ProductlinesEntity();
		productLine.setProductLine("productLine01");
		productList.add(new ProductsEntity("productCode02", "productName02", productLine, "productScale02",
											"productVendor02", "productDesc02", 2, 2.22, 2.22));
		LOG.info("Test testFindProductsByCategories() - testFindProductsByCategories to return \n"+ productList.toString());
		//When
		when(productRepository.findProductsByCategories("productLine01")).thenReturn(productList);
		LOG.info("testFindProductsByCategories() - testFindProductsByCategories(\"productLine01\") calling");
		List<ProductsEntity> result = service.findProductsByCategories("productLine01");
		LOG.info("testFindProductsByCategories() - Verifying testFindProductsByCategories() is called at least once");
		verify(productRepository, atLeastOnce()).findProductsByCategories("productLine01");
		LOG.info("testFindProductsByCategories() - Asserting that the result is not null or empty");
		assertNotNull(result);
		assertFalse(result.isEmpty());
	}

	@Test
	void testFindOneProduct() {
		productLine = new ProductlinesEntity();
		productLine.setProductLine("product04");
		ProductsEntity p1 = new ProductsEntity("productCode04", "productName04", productLine, "productScale04",
												"productVendor04", "productDesc04", 4, 4.44, 4.44);
		LOG.info("testFindOneProduct() - findOne('product04') to return " + p1.toString());
		when(productRepository.findOne("product04")).thenReturn(p1);
		LOG.info("testFindOneProduct() - findOne('product04') calling");
		ProductsEntity result = service.find("product04");
		LOG.info("testFindOneProduct() - Verifying findOne('product04') is called at least once");
		verify(productRepository, atLeastOnce()).findOne("product04");
		LOG.info("testFindOneProduct() - Asserting that the result is not null");
		assertNotNull(result);
	}

}
