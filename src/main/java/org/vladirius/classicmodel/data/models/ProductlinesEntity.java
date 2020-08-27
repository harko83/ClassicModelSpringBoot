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
	
	
	
	public ProductlinesEntity() {}
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((htmlDescription == null) ? 0 : htmlDescription.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((productLine == null) ? 0 : productLine.hashCode());
		result = prime * result + ((textDescription == null) ? 0 : textDescription.hashCode());
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
		ProductlinesEntity other = (ProductlinesEntity) obj;
		if (htmlDescription == null) {
			if (other.htmlDescription != null)
				return false;
		} else if (!htmlDescription.equals(other.htmlDescription))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (productLine == null) {
			if (other.productLine != null)
				return false;
		} else if (!productLine.equals(other.productLine))
			return false;
		if (textDescription == null) {
			if (other.textDescription != null)
				return false;
		} else if (!textDescription.equals(other.textDescription))
			return false;
		return true;
	}
	
	
}
