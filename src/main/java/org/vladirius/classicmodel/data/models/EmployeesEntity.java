package org.vladirius.classicmodel.data.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity copie de la table de la base
 * Correspondant en tous point aux champs
 * de la table classicmodels.employees
 * @author Vladirius
 */

@Entity
@Table(name = "employees")
public class EmployeesEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "employeeNumber")
	private Long employeeNumber;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "extension")
	private String extension;
	
	@Column(name = "email")
	private String email;
	
	//Specify the foreign key
	@ManyToOne()
	@JoinColumn(name = "officeCode")
	private OfficesEntity officeCode;
	
	//Specify the foreign key
	@ManyToOne()
	@JoinColumn(name = "reportsTo")
	private EmployeesEntity reportsTo;
	
	@Column(name = "jobTitle")
	private String jobTitle;
	
	
	
	public EmployeesEntity() {}

	public Long getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(Long employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public OfficesEntity getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(OfficesEntity officeCode) {
		this.officeCode = officeCode;
	}

	public EmployeesEntity getReportsTo() {
		return reportsTo;
	}

	public void setReportsTo(EmployeesEntity reportsTo) {
		this.reportsTo = reportsTo;
	}	
	
}
