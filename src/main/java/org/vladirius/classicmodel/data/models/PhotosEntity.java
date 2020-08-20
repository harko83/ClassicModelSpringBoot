package org.vladirius.classicmodel.data.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity copie de la table de la base
 * Correspondant en tous points aux champs
 * de la table classicmodels.Images
 * @author Vladirius
 */

@Entity
@Table(name = "photos")
public class PhotosEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID")
	private int ID;
	
	@Column(name = "nom")
	private String nom;
	
	//Specify the foreign key
	@ManyToOne()
	@JoinColumn(name = "ID_categorie", referencedColumnName = "ID" )
	private PhotocategoriesEntity photocategoriesEntity;

	@Column(name = "label")
	private String label;
	
	@Column(name = "tags")
	private String tags;

	public int getID() {return ID;}

	public void setID(int ID) {this.ID = ID;}

	public String getNom() {return nom;}

	public void setNom(String nom) {this.nom = nom;}

	public String getLabel() {return label;}

	public void setLabel(String label) {this.label = label;}

	public String getTags() {return tags;}

	public void setTags(String tags) {this.tags = tags;}

	public PhotocategoriesEntity getPhotocategoriesEntity() {
		return photocategoriesEntity;
	}

	public void setPhotocategoriesEntity(PhotocategoriesEntity photocategoriesEntity) {
		this.photocategoriesEntity = photocategoriesEntity;
	}

}
