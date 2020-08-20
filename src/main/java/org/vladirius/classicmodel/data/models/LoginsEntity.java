package org.vladirius.classicmodel.data.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import java.util.Set;

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

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Entity copie de la table de la base
 * Correspondant en tous points aux champs
 * de la table classicmodels.Logins
 * @author Vladirius
 */

@Entity
@Table(name = "logins")
public class LoginsEntity implements UserDetails, Serializable {


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
	private CustomersEntity customerNumber;
	
	@OneToOne(targetEntity = EmployeesEntity.class, cascade = CascadeType.ALL )
	@JoinColumn(name = "employeeNumber")
	private EmployeesEntity employeeNumber;
	
	@Column(name = "login")
	private String login;
	
	@Column(name = "pwd")
	private String pwd;
	
	@Column(name = "dateCrea")
	private Date dateCrea;
	
	@Column(name = "dateMAJ")
	private Date dateMAJ;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name = "users_roles",
			joinColumns = {@JoinColumn(name = "user_id")},
			inverseJoinColumns = {@JoinColumn(name = "role_id")})
	private Set<Role> authorities;
	
	public LoginsEntity() {}
	
	
	/*
	 * GETTERS-SETTERS
	 */
	public Long getLoginID() {
		return loginID;
	}

	public void setLoginID(Long loginID) {
		this.loginID = loginID;
	}

	public CustomersEntity getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(CustomersEntity customerNumber) {
		this.customerNumber = customerNumber;
	}

	public EmployeesEntity getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(EmployeesEntity employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public void setAuthorities(Set<Role> authorities) {
		this.authorities = authorities;
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
	
	/*
	 * userDetailsImpl
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.pwd;
	}

	@Override
	public String getUsername() {
		return this.login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
