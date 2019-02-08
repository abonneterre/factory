package fr.factory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

import fr.factory.projection.Views;

@Entity
@Table(name="proposition")
public class Proposition {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PRO_ID")
	@JsonView(Views.Common.class)
	private int id;
	
	@Column(name="PRO_NOM",nullable=false)
	@NotNull
	@NotEmpty
	@JsonView(Views.Proposition.class)
	private String nom;
	
	@Column(name="PRO_PRENOM", nullable=false)
	@NotNull
	@NotEmpty
	@JsonView(Views.Proposition.class)
	private String prenom;
	
	@Column(name="PRO_MAIL", nullable=false)
	@NotNull
	@NotEmpty
	@JsonView(Views.Proposition.class)
	private String mail;
	

	@Column(name="PRO_DESCRIPTION", columnDefinition="TEXT", nullable=false)
	@NotEmpty
	@NotNull
	@JsonView(Views.Proposition.class)
	private String description;
	
	@Column(name="PRO_ISARCHIVEE", nullable=false)
	@NotNull
	private boolean archivee=false;


	public boolean isArchivee() {
		return archivee;
	}

	public void setArchivee(boolean archivee) {
		this.archivee = archivee;
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
