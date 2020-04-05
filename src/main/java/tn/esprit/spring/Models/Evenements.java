package tn.esprit.spring.Models;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_EVENEMENT")
public class Evenements implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_EVENT")
	long idEvent;
	@Column(name="NOM_E")
	String nomE;
	@Column(name="ADRESSE_E")
	String adresseE;
	@Temporal(TemporalType.DATE)
	private Date dateE;
	@Column(name="DESCRIP_E")
	String descripE;
	@Column(name="ETAT_E")
	String etatE;
	@Column(name="IMAGE_E")
	String imageE;
	@Column(name="NB_PLACE")
	Integer nbPlace;
	@Column(name="STATUT_E")
	String statutE="Disponible";
	@OneToMany(cascade = CascadeType.ALL, mappedBy="evenement")
	 private Set<Schooladmins> Schooladmins;

	
	@ManyToMany(mappedBy="evenements", cascade = CascadeType.ALL)
	private Set<Participants> participants;

	public long getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(long idEvent) {
		this.idEvent = idEvent;
	}

	public String getNomE() {
		return nomE;
	}

	public void setNomE(String nomE) {
		this.nomE = nomE;
	}

	public String getAdresseE() {
		return adresseE;
	}

	public void setAdresseE(String adresseE) {
		this.adresseE = adresseE;
	}

	public Date getDateE() {
		return dateE;
	}

	public void setDateE(Date dateE) {
		this.dateE = dateE;
	}

	public String getDescripE() {
		return descripE;
	}

	public void setDescripE(String descripE) {
		this.descripE = descripE;
	}

	public String getEtatE() {
		return etatE;
	}

	public void setEtatE(String etatE) {
		this.etatE = etatE;
	}

	public String getImageE() {
		return imageE;
	}

	public void setImageE(String imageE) {
		this.imageE = imageE;
	}

	public String getStatutE() {
		return statutE;
	}

	public void setStatutE(String statutE) {
		this.statutE = statutE;
	}

	public Set<Participants> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<Participants> participants) {
		this.participants = participants;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getNbPlace() {
		return nbPlace;
	}

	public void setNbPlace(Integer nbPlace) {
		this.nbPlace = nbPlace;
	}

	@Override
	public String toString() {
		return "Evenements [idEvent=" + idEvent + ", nomE=" + nomE + ", adresseE=" + adresseE + ", dateE=" + dateE
				+ ", descripE=" + descripE + ", etatE=" + etatE + ", imageE=" + imageE + ", nbPlace=" + nbPlace
				+ ", statutE=" + statutE + ", participants=" + participants + "]";
	}

	public Evenements() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Evenements(String nomE, String adresseE, Date dateE, String descripE, String etatE, String imageE,
			Integer nbPlace, String statutE, Set<Participants> participants) {
		super();
		this.nomE = nomE;
		this.adresseE = adresseE;
		this.dateE = dateE;
		this.descripE = descripE;
		this.etatE = etatE;
		this.imageE = imageE;
		this.nbPlace = nbPlace;
		this.statutE = statutE;
		this.participants = participants;
	}

	public Evenements(long idEvent, String nomE, String adresseE, Date dateE, String descripE, String etatE,
			String imageE, Integer nbPlace, String statutE, Set<Participants> participants) {
		super();
		this.idEvent = idEvent;
		this.nomE = nomE;
		this.adresseE = adresseE;
		this.dateE = dateE;
		this.descripE = descripE;
		this.etatE = etatE;
		this.imageE = imageE;
		this.nbPlace = nbPlace;
		this.statutE = statutE;
		this.participants = participants;
	}

	
	
}