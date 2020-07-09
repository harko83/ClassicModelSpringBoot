package org.vladirius.classicmodel.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.vladirius.classicmodel.data.models.ProductlinesEntity;
import org.vladirius.classicmodel.data.models.ProductsEntity;
import org.vladirius.classicmodel.data.repositories.ProductRepository;

import utilsTests.MvcBaseTest;

class ProductsServiceTest extends MvcBaseTest {
	@InjectMocks
	private ProductsService productsServiceMock;
	
	@MockBean
	private ProductRepository productRepositoryMock;

	private ProductlinesEntity productlinesEntityp1;
	private ProductlinesEntity productlinesEntityp2;
	
	private ProductsEntity p1;
	private ProductsEntity p2;
	
	private final List<ProductsEntity> productList = new ArrayList<>();
	
	private final String P1PRODUCT_CODE = "1test_pcode";
	private final String P1PRODUCT_NAME = "1test_name";
	private final String P1PRODUCT_LINE = "1test_pLine";
	private final String P1PRODUCT_SCALE = "1test_scale";
	private final String P1PRODUCT_VENDOR = "1test_vendor";
	private final String P1PRODUCT_DESC = "1test_description";
	private final int P1QUANTITYINSTOCK = 1;
	private final Double P1BUYPRICE = 1.11d;
	private final Double P1MSRP = 1.11d;
	
	private final String P2PRODUCT_CODE = "2test_pcode";
	private final String P2PRODUCT_NAME = "2test_name";
	private final String P2PRODUCT_LINE = "2test_pLine";
	private final String P2PRODUCT_SCALE = "2test_scale";
	private final String P2PRODUCT_VENDOR = "2test_vendor";
	private final String P2PRODUCT_DESC = "2test_description";
	private final int P2QUANTITYINSTOCK = 2;
	private final Double P2BUYPRICE = 2.22d;
	private final Double P2MSRP = 2.22d;
	
	@Test
	public void testFindAll_thenProductListShouldBeReturned() throws Exception {
		p1 = new ProductsEntity();
		productlinesEntityp1 = new ProductlinesEntity();
		
		p1.setProductCode(P1PRODUCT_CODE);
		p1.setProductName(P1PRODUCT_NAME);
		productlinesEntityp1.setProductLine(P1PRODUCT_LINE);
		p1.setProductlinesEntity(productlinesEntityp1);
		p1.setProductScale(P1PRODUCT_SCALE);
		p1.setProductVendor(P1PRODUCT_VENDOR);
		p1.setProductDescription(P1PRODUCT_DESC);
		p1.setQuantityInStock(P1QUANTITYINSTOCK);
		p1.setBuyPrice(P1BUYPRICE);
		p1.setMSRP(P1MSRP);
		
		p2 = new ProductsEntity();
		productlinesEntityp2 = new ProductlinesEntity();
		
		p2.setProductCode(P2PRODUCT_CODE);
		p2.setProductName(P2PRODUCT_NAME);
		productlinesEntityp2.setProductLine(P2PRODUCT_LINE);
		p2.setProductlinesEntity(productlinesEntityp2);
		p2.setProductScale(P2PRODUCT_SCALE);
		p2.setProductVendor(P2PRODUCT_VENDOR);
		p2.setProductDescription(P2PRODUCT_DESC);
		p2.setQuantityInStock(P2QUANTITYINSTOCK);
		p2.setBuyPrice(P2BUYPRICE);
		p2.setMSRP(P2MSRP);
		
		productList.add(p1);
		productList.add(p2);
		
		when(productRepositoryMock.findAll()).thenReturn(productList);
		
		List<ProductsEntity> expected = productsServiceMock.getProducts();
		
		assertEquals(expected, productList);
		
	}
	
	@Test
	public void findProductsByCategories() {
		p1 = new ProductsEntity();
		productlinesEntityp1 = new ProductlinesEntity();
		
		p1.setProductCode(P1PRODUCT_CODE);
		p1.setProductName(P1PRODUCT_NAME);
		productlinesEntityp1.setProductLine(P1PRODUCT_LINE);
		p1.setProductlinesEntity(productlinesEntityp1);
		p1.setProductScale(P1PRODUCT_SCALE);
		p1.setProductVendor(P1PRODUCT_VENDOR);
		p1.setProductDescription(P1PRODUCT_DESC);
		p1.setQuantityInStock(P1QUANTITYINSTOCK);
		p1.setBuyPrice(P1BUYPRICE);
		p1.setMSRP(P1MSRP);
		
		when(productRepositoryMock.findProductsByCategories(p1.getProductCode())).thenReturn(productList);
		
		List<ProductsEntity> expected = productsServiceMock.findProductsByCategories(p1.getProductCode());
		
		assertThat(expected).isNotNull();
	}

}
