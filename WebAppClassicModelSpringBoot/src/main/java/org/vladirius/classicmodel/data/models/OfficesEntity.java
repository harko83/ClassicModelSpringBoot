package org.vladirius.classicmodel.data.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity copie de la table de la base
 * Correspondant en tous point aux champs
 * de la table classicmodels.offices
 * @author Vladirius
 */

@Entity
@Table(name = "offices")
public class OfficesEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "officeCode")
	private int officeCode;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "addressLine1")
	private String addressLine1;
	
	@Column(name = "addressLine2")
	private String addressLine2;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "postalCode")
	private String postalCode;
	
	@Column(name = "territory")
	private String territory;

	public int getOfficeCode() {return officeCode;}

	public void setOfficeCode(int officeCode) {this.officeCode = officeCode;}

	public String getCity() {return city;}

	public void setCity(String city) {this.city = city;}

	public String getPhone() {return phone;}

	public void setPhone(String phone) {this.phone = phone;}

	public String getAddressLine1() {return addressLine1;}

	public void setAddressLine1(String addressLine1) {this.addressLine1 = addressLine1;}

	public String getAddressLine2() {return addressLine2;}

	public void setAddressLine2(String addressLine2) {this.addressLine2 = addressLine2;}

	public String getState() {return state;}

	public void setState(String state) {this.state = state;}

	public String getCountry() {return country;}

	public void setCountry(String country) {this.country = country;}

	public String getPostalCode() {return postalCode;}

	public void setPostalCode(String postalCode) {this.postalCode = postalCode;}

	public String getTerritory() {return territory;}

	public void setTerritory(String territory) {this.territory = territory;}

}
