package org.vladirius.classicmodel.data.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.mapping.Set;

/**
 * Entity copie de la table de la base
 * Correspondant en tous points aux champs
 * de la table classicmodels.Logins
 * @author Vladirius
 */

@Entity
@Table(name = "logins")
public class LoginsEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "loginID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long loginID;
	
	@OneToOne(targetEntity = CustomersEntity.class, cascade = CascadeType.ALL )
	@JoinColumn(name = "customerNumber")
	private Long customerNumber;
	
	@OneToOne(targetEntity = EmployeesEntity.class, cascade = CascadeType.ALL )
	@JoinColumn(name = "employeeNumber")
	private Long employeeNumber;
	
	@Column(name = "login")
	private String login;
	
	@Column(name = "pwd")
	private String pwd;
	
	@Column(name = "dateCrea")
	private Date dateCrea;
	
	@Column(name = "dateMAJ")
	private Date dateMAJ;
	
	@Column(name = "enabled")
	private boolean enabled;

	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name = "users_roles",
			joinColumns = {@JoinColumn(name = "user_id")},
			inverseJoinColumns = {@JoinColumn(name = "role_id")}
			)
	private java.util.Set<Role> roles = new HashSet<>();
	
	public LoginsEntity() {
		
	}
	
	
	/*
	 * GETTERS-SETTERS
	 */
	public Long getLoginID() {
		return loginID;
	}

	public void setLoginID(Long loginID) {
		this.loginID = loginID;
	}
	
	public void setCustomerNumber(Long customerNumber) {
		this.customerNumber = customerNumber;
	}

	public Long getCustomerNumber() {
		return customerNumber;
	}

	public Long getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(Long employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Date getDateCrea() {
		return dateCrea;
	}

	public void setDateCrea(Date dateCrea) {
		this.dateCrea = dateCrea;
	}

	public Date getDateMAJ() {
		return dateMAJ;
	}

	public void setDateMAJ(Date dateMAJ) {
		this.dateMAJ = dateMAJ;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public java.util.Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(java.util.Set<Role> roles) {
		this.roles = roles;
	}

}
