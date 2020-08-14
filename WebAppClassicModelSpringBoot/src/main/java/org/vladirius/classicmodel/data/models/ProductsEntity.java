package org.vladirius.classicmodel.data.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity copie de la table de la base
 * Correspondant en tous points aux champs 
 * de la table classicmodels.products
 * @author Vladirius
 */

@Entity
@Table(name = "products")
public class ProductsEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "productCode")
	private String productCode;
	
	@Column(name = "productName")
	private String productName;
	
	//Specify the foreign key
	@ManyToOne()
	@JoinColumn(name = "productLine")
	private ProductlinesEntity productLine;
	
	@Column(name = "productScale")
	private String productScale;
	
	@Column(name = "productVendor")
	private String productVendor;
	
	@Column(name = "productDescription")
	private String productDescription;
	
	@Column(name = "quantityInStock")
	private Integer quantityInStock;
	
	@Column(name = "buyPrice")
	private double buyPrice;
	
	@Column(name = "MSRP")
	private double MSRP;

	public ProductsEntity() {}
	
	public ProductsEntity(String productCode, String productName, ProductlinesEntity productLine, String productScale,
			String productVendor, String productDescription, Integer quantityInStock, double buyPrice, double mSRP) {
		this.productCode = productCode;
		this.productName = productName;
		this.productLine = productLine;
		this.productScale = productScale;
		this.productVendor = productVendor;
		this.productDescription = productDescription;
		this.quantityInStock = quantityInStock;
		this.buyPrice = buyPrice;
		this.MSRP = mSRP;
	}

/*
 * GETTER-SETTER
 */
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductScale() {
		return productScale;
	}
	public void setProductScale(String productScale) {
		this.productScale = productScale;
	}
	public String getProductVendor() {
		return productVendor;
	}
	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public Integer getQuantityInStock() {
		return quantityInStock;
	}
	public void setQuantityInStock(Integer quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	public double getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}
	public double getMSRP() {
		return MSRP;
	}
	public void setMSRP(double mSRP) {
		MSRP = mSRP;
	}

	public ProductlinesEntity getProductlinesEntity() {
		return productLine;
	}
	public void setProductlinesEntity(ProductlinesEntity productline) {
		this.productLine = productline;
	}

	@Override
	public String toString() {
		return "ProductsEntity [productCode= " + productCode + ", productName= " + productName + ", productLine= "
				+ productLine.getProductLine() + ", productScale= " + productScale + ", productVendor= " + productVendor
				+ ", productDescription= " + productDescription + ", quantityInStock= " + quantityInStock + ", buyPrice= "
				+ buyPrice + ", MSRP= " + MSRP + "]\n";
	}
	
	
}
