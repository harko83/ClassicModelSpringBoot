package org.vladirius.classicmodel.data.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity copie de la table de la base
 * Correspondent en tous points aux champs
 * de la table classicmodels.productlines
 * @author Vladirius
 */

@Entity
@Table(name = "productlines")
public class ProductlinesEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "productLine")
	private String productLine;
	
	@Column(name = "textDescription")
	private String textDescription;
	
	@Column(name = "htmlDescription")
	private String htmlDescription;
	
	@Column(name = "image")
	private String image;
	
	public String getProductLine() {
		return productLine;
	}
	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}
	public String getTextDescription() {
		return textDescription;
	}
	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}
	public String getHtmlDescription() {
		return htmlDescription;
	}
	public void setHtmlDescription(String htmlDescription) {
		this.htmlDescription = htmlDescription;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
