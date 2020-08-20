package org.vladirius.classicmodel.data.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity copie de la table de la base
 * Correspondant en tous point aux champs
 * de la table classicmodels.contact
 * @author Vladirius
 */

@Entity
@Table(name = "contact")
public class ContactEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "object")
	private String object;
	
	@Column(name = "message")
	private String message;
	
	public ContactEntity() {}
	
	public ContactEntity(String lastname, String firstname, String phone, String country, String email, String object,
			String message) {
		this.lastname = lastname;
		this.firstname = firstname;
		this.phone = phone;
		this.country = country;
		this.email = email;
		this.object = object;
		this.message = message;
	}


	/*
	 * SETTER-GETTER
	 */
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
