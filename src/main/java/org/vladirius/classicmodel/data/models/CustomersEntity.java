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
 * Correspondant en tous point aux champs
 * de la table classicmodels.customers
 * @author Vladirius
 */
@Entity
@Table(name = "customers")
public class CustomersEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "customerNumber")
	private Long customerNumber;
	
	@Column(name = "customerName")
	private String customerName;
	
	@Column(name = "contactLastName")
	private String contactLastName;
	
	@Column(name = "contactFirstName")
	private String contactFirstName;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "addressLine1")
	private String addressLine1;
	
	@Column(name = "addressLine2")
	private String addressLine2;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "postalCode")
	private String postalCode;
	
	@Column(name = "country")
	private String country;
	
	//Specify the foreign key
	@ManyToOne()
	@JoinColumn(name = "salesRepEmployeeNumber", referencedColumnName = "employeeNumber")
	private EmployeesEntity salesREmployeeNumber;

	@Column(name = "creditLimit")
	private double creditLimit;
	

	public Long getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(Long customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getContactLastName() {
		return contactLastName;
	}

	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}

	public String getContactFirstName() {
		return contactFirstName;
	}

	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}
	
	public EmployeesEntity getEmployeesEntity() {
		return salesREmployeeNumber;
	}

	public void setEmployeesEntity(EmployeesEntity employeesEntity) {
		this.salesREmployeeNumber = employeesEntity;
	}
	
	public String getName() {
		String name = (this.customerNumber+this.contactFirstName+this.contactLastName).trim();
		return name;
	}

}
