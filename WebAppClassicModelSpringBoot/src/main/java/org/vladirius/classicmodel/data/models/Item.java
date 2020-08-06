package org.vladirius.classicmodel.data.models;

import java.util.List;

public class Item {
	private ProductsEntity product;
	private int quantity;
	
	public Item() {}
	
	
	public Item(List<ProductsEntity> list) {
	}
	
	public Item(ProductsEntity product, int quantity) {
		this.setProduct(product);
		this.setQuantity(quantity);
		
	}

	public ProductsEntity getProduct() {
		return product;
	}

	public void setProduct(ProductsEntity product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
