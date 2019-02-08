package fr.factory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="proposition")
public class Proposition {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PRO_ID")
	private int id;
	
	@Column(name="PRO_NOM",nullable=false)
	@NotNull
	@NotEmpty
	private String nom;
	
	@Column(name="PRO_PRENOM", nullable=false)
	@NotNull
	@NotEmpty
	private String prenom;
	
	@Column(name="PRO_MAIL", nullable=false)
	@NotNull
	@NotEmpty
	private String mail;
	

	@Column(name="PRO_DESCRIPTION", columnDefinition="TEXT", nullable=false)
	@NotEmpty
	@NotNull
	private String description;
	
	@Column(name="PRO_ISARCHIVEE", nullable=false)
	@NotNull
	private boolean isArchivee=false;
	
	public boolean isArchivee() {
		return isArchivee;
	}

	public void setArchivee(boolean isArchivee) {
		this.isArchivee = isArchivee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
