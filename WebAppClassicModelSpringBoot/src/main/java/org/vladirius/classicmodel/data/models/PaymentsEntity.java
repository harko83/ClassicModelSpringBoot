package org.vladirius.classicmodel.data.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity copie de la table de la base
 * Correspondant en tous points aux champs
 * de la table classicmodels.payments
 * @author Vladirius
 */

@Entity
@Table(name = "payments")
public class PaymentsEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "checkNumber")
	private String checkNumber;
	
	//Specify the foreign key
	@ManyToOne()
	@JoinColumn(name = "customerNumber")
	private CustomersEntity customersEntity;
	
	@Column(name = "paymentDate")
	private Date paymentDate;
	
	@Column(name = "amount")
	private double amount;
	
	public String getCheckNumber() {
		return checkNumber;
	}
	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public CustomersEntity getCustomersEntity() {
		return customersEntity;
	}
	public void setCustomersEntity(CustomersEntity customersEntity) {
		this.customersEntity = customersEntity;
	}
}
