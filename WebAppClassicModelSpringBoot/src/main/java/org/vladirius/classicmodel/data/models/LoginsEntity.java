package org.vladirius.classicmodel.data.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity copie de la table de la base
 * Correspondant en tous points aux champs
 * de la table classicmodels.Logins
 * @author Vladirius
 */

@Entity
@IdClass(LoginPK.class)
@Table(name = "logins")
public class LoginsEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne(targetEntity = CustomersEntity.class)
	@JoinColumn(name = "customerNumber")
	private Long customerNumber;
	
	@Id
	@OneToOne(targetEntity = EmployeesEntity.class)
	@JoinColumn(name = "employeeNumber")
	private Long employeeNumber;
	
	@Column(name = "login")
	private String login;
	
	@Column(name = "pwd")
	private String pwd;
	
	@Column(name = "profil")
	private int profil;
	
	@Column(name = "dateCrea")
	private Date dateCrea;
	
	@Column(name = "dateMAJ")
	private Date dateMAJ;

	public long getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(long customerNumber) {
		this.customerNumber = customerNumber;
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

	public void setCustomerNumber(Long customerNumber) {
		this.customerNumber = customerNumber;
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

	public int getProfil() {
		return profil;
	}

	public void setProfil(int profil) {
		this.profil = profil;
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

}
