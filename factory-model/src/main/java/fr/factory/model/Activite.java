package fr.factory.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="activite")
public class Activite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACT_ID")
	private int id;
	
	@Column(name = "ACT_NOM")
	@NotEmpty
	@NotNull
	@Size(max=100)
	private String nom;
	
	@Column(name = "ACT_CODE_UNIQUE")
	@NotEmpty
	@NotNull
	private int codeUnique;
	
	@Column(name = "ACT_NB_PARTICIPANTS_MIN")
	@NotEmpty
	@NotNull
	private int nbParticipantsMin;
	
	@Column(name = "ACT_NB_PARTICIPANTS_MAX")
	@NotEmpty
	@NotNull
	private int nbParticipantsMax;
	
	@Column(name = "ACT_TARIF_PERSONNE")
	private float tarifPersonne;
	
	@Column(name = "ACT_ACTIVEE")
	private boolean activee;
	
	@Column(name = "ACT_DUREE")
	private int duree;
	
	@Column(name = "ACT_NB_APPROXIMATIF", nullable=false)
	private boolean nbApproximatif;
	
	@Column(name = "ACT_DESCRIPTION", columnDefinition="TEXT", nullable = false)
	@NotEmpty
	private String description;
	
	@Column(name = "ACT_LIEN_YOUTUBE")
	private String lienYoutube;
	
	@Column(name = "ACT_IMAGE")
	private String image;

	
	@Column(name="ACT_NIVEAU_ID")
	@Enumerated(EnumType.ORDINAL)
	private Niveau niveau;
	
	@OneToMany(mappedBy = "activite")
	private List<Reservation> reservations;
	
	@ManyToMany
	@JoinColumn(name="ACT_CATEGORIE_ID")
	private List<Categorie> categories ;
	
	@ManyToOne
	@JoinColumn(name="ACT_LIEU_ID")
	private Lieu lieu;

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

	public int getCodeUnique() {
		return codeUnique;
	}

	public void setCodeUnique(int codeUnique) {
		this.codeUnique = codeUnique;
	}

	public int getNbParticipantsMin() {
		return nbParticipantsMin;
	}

	public void setNbParticipantsMin(int nbParticipantsMin) {
		this.nbParticipantsMin = nbParticipantsMin;
	}

	public int getNbParticipantsMax() {
		return nbParticipantsMax;
	}

	public void setNbParticipantsMax(int nbParticipantsMax) {
		this.nbParticipantsMax = nbParticipantsMax;
	}

	public float getTarifPersonne() {
		return tarifPersonne;
	}

	public void setTarifPersonne(float tarifPersonne) {
		this.tarifPersonne = tarifPersonne;
	}

	public boolean isActivee() {
		return activee;
	}

	public void setActivee(boolean activee) {
		this.activee = activee;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public boolean isNbApproximatif() {
		return nbApproximatif;
	}

	public void setNbApproximatif(boolean nbApproximatif) {
		this.nbApproximatif = nbApproximatif;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLienYoutube() {
		return lienYoutube;
	}

	public void setLienYoutube(String lienYoutube) {
		this.lienYoutube = lienYoutube;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public List<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}

	public Lieu getLieu() {
		return lieu;
	}

	public void setLieu(Lieu lieu) {
		this.lieu = lieu;
	}

}
