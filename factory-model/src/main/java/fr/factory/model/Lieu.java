package fr.factory.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="lieu")
public class Lieu {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LIE_ID")
	private int id;
	
	@Column(name="LIE_NOM")
	@NotEmpty
	@NotNull
	private String nom;
	
	@Column(name="LIE_ADRESSE")
	@NotEmpty
	@NotNull
	private String adresse;
	
	@Column(name="LIE_TELEPHONE")
	@Size(max=20)
	private String telephone;
	
	@Column(name="LIE_DESCRIPTION", columnDefinition="TEXT")
	private String description;
	
	@Column(name="LIE_IMAGE")
	private String image;
	
	@Column(name="LIE_LIEN")
	private String lien;
	
	@OneToOne
	private Utilisateur utilisateur ;
	
	@OneToMany(mappedBy="lieu")
	private List<Activite> activites = new ArrayList<Activite>();
	

	public int getId() {
		return id;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLien() {
		return lien;
	}

	public void setLien(String lien) {
		this.lien = lien;
	}
	
}
