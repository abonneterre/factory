package fr.factory.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;




@Entity
@Table(name="categorie")
public class Categorie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CAT_ID")
	private int id;
	
	@Column(name="CAT_LIBELLE", nullable=false)
	@NotNull
	@NotEmpty
	private String libelle;
	
	@ManyToMany(mappedBy="categories",cascade = CascadeType.REMOVE)
	private List<Activite> activites;
	
	@OneToMany(mappedBy="categorieMere", cascade = CascadeType.REMOVE)
	private List<Categorie> categoriesFilles;
	
	@ManyToOne
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

	public List<Categorie> getCategoriesFilles() {
		return categoriesFilles;
	}

	public void setCategoriesFilles(List<Categorie> categoriesFilles) {
		this.categoriesFilles = categoriesFilles;
	}

	public Categorie getCategorieMere() {
		return categorieMere;
	}

	public void setCategorieMere(Categorie categorieMere) {
		this.categorieMere = categorieMere;
	}

	

}