package org.vladirius.classicmodel.data.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
	
	@Id
	@Column(name = "role_id")
	private Integer id;
	
	private String name;


	public Integer getId() {
		return id;
	}

	/*
	 * Getter-Setter
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
