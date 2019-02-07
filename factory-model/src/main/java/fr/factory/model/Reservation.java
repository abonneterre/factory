package fr.factory.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;

import fr.factory.projection.Views;


@Entity
@Table(name="Reservation")
public class Reservation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="RES_ID")
	@JsonView(Views.Common.class)
	private int id;
	
	@Column(name="RES_NOM", nullable = false)
	@JsonView(Views.Reservation.class)
	private String nom;
	
	@Column(name="RES_PRENOM", nullable = false)
	@JsonView(Views.Reservation.class)
	private String prenom;
	
	@Column(name="RES_TELEPHONE", nullable = false)
	@JsonView(Views.Reservation.class)
	@Size(max=20)
	private String telephone;
	
	@Column(name="RES_MAIL", nullable = false)
	@JsonView(Views.Reservation.class)
	private String mail;
	
	@Column(name="RES_NBPARTICIPANTS", nullable = false)
	@JsonView(Views.Reservation.class)
	private int nbParticipants;
	
	@Column(name="RES_APPROX", nullable = false)
	@JsonView(Views.Reservation.class)
	private boolean isApprox = false;
	
	@Column(name="RES_DATEDEMANDE")
	@Temporal(TemporalType.DATE)
	@JsonView(Views.Reservation.class)
	private Date dateDemande; 
	
	@Column(name="RES_DATERESERVATION", nullable = false)
	@Temporal(TemporalType.DATE)
	@JsonView(Views.Reservation.class)
	private Date dateReservation;
	
	@Column(name="RES_DUREESOUHAITEE", nullable = false)
	@JsonView(Views.Reservation.class)
	private int dureeSouhaitee;
	
	@Column(name="RES_STATUT") //0 pour en attente, 1 pour valid�e, 2 pour refus�e
	@JsonView(Views.Reservation.class)
	private int statut;
	
	@ManyToOne
	@JoinColumn(name="RES_ACTIVITE_ID", nullable = false) //A VERIFIER AUPRES DU GROUPE I
	@JsonView(Views.ReservationWithActivite.class)
	private Activite activite;

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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getNbParticipants() {
		return nbParticipants;
	}

	public void setNbParticipants(int nbParticipants) {
		this.nbParticipants = nbParticipants;
	}

	public boolean isApprox() {
		return isApprox;
	}

	public void setApprox(boolean isApprox) {
		this.isApprox = isApprox;
	}

	public Date getDateDemande() {
		return dateDemande;
	}

	public void setDateDemande(Date dateDemande) {
		this.dateDemande = dateDemande;
	}

	public Date getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}

	public int getDureeSouhaitee() {
		return dureeSouhaitee;
	}

	public void setDureeSouhaitee(int dureeSouhaitee) {
		this.dureeSouhaitee = dureeSouhaitee;
	}

	public int getStatut() {
		return statut;
	}

	public void setStatut(int statut) {
		this.statut = statut;
	}

	public Activite getActivite() {
		return activite;
	}

	public void setActivite(Activite activite) {
		this.activite = activite;
	}
	
	
}
