package org.vladirius.classicmodel.data.models;

import java.io.Serializable;

public class LoginPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long customerNumber;
	private long employeeNumber;
	
	public LoginPK() {
	}

	public LoginPK(long customerNumber, long employeeNumber) {
		this.customerNumber = customerNumber;
		this.employeeNumber = employeeNumber;
	}

	public long getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(long customerNumber) {
		this.customerNumber = customerNumber;
	}

	public long getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(long employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (customerNumber ^ (customerNumber >>> 32));
		result = prime * result + (int) (employeeNumber ^ (employeeNumber >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginPK other = (LoginPK) obj;
		if (customerNumber != other.customerNumber)
			return false;
		if (employeeNumber != other.employeeNumber)
			return false;
		return true;
	}
		
}
