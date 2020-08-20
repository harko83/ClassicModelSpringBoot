package org.vladirius.classicmodel.data.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Entity copie de la table de la base
 * Correspondant en tous points aux champs
 * de la table classicmodels.ordersdetails
 * @author Vladirius
 */

@Entity
@Table(name = "orderdetails")
@IdClass(OrderDetailsPK.class)
public class OrderdetailsEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ordernumber")
	private int orderNumber;
	
	@Id
	@Column(name = "productCode") 
	private String productCode;
	
	@Column(name = "quantityOrdered")
	private int quantityOrdered;
	
	@Column(name = "priceEach")
	private double priceEach;
	
	@Column(name = "orderLineNumber")
	private int orderLineNumber;
	
	public int getOrderNumber() {return orderNumber;}

	public void setOrderNumber(int orderNumber) {this.orderNumber = orderNumber;}

	public String getProductCode() {return productCode;}

	public void setProductCode(String productCode) {this.productCode = productCode;}

	public double getPriceEach() {return priceEach;}

	public void setPriceEach(double priceEach) {this.priceEach = priceEach;}

	public int getQuantityOrdered() {return quantityOrdered;}

	public void setQuantityOrdered(int quantityOrdered) {this.quantityOrdered = quantityOrdered;}

	public int getOrderLineNumber() {return orderLineNumber;}

	public void setOrderLineNumber(int orderLineNumber) {this.orderLineNumber = orderLineNumber;}

}
