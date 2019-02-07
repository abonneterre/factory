package fr.factory.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

import fr.factory.projection.Views;



@Entity
@Table(name="categorie")
public class Categorie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CAT_ID")
	@JsonView(Views.Common.class)
	private int id;
	
	@Column(name="CAT_LIBELLE", nullable=false)
	@NotNull
	@JsonView(Views.Categorie.class)
	private String libelle;
	
	@ManyToMany(mappedBy="categories")
	private List<Activite> activites;
	
	@OneToMany(mappedBy="categorieMere")
	private List<Categorie> categoriesFilles;
	
	@ManyToOne
	@JsonView(Views.Categorie.class)
	private Categorie categorieMere;
	
	public List<Activite> getActivites() {
		return activites;
	}

	public void setActivites(List<Activite> activites) {
		this.activites = activites;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	

}