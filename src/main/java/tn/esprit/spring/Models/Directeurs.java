package tn.esprit.spring.Models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_DIRECTEUR")
public class Directeurs implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_DIREC")
	long idDirec;
	@Column(name="NOM_D")
	String nomD;
	@Column(name="PRENOM_D")
	String prenomD;
	@Column(name="NUM_D")
	String numD;
	@Column(name="EMAIL_D")
	String emailD;
	@Column(name="CV")
	String cv;
	@Temporal(TemporalType.DATE)
	private Date anneeDebut;
	
	public long getIdDirec() {
		return idDirec;
	}
	public void setIdDirec(long idDirec) {
		this.idDirec = idDirec;
	}
	public String getNomD() {
		return nomD;
	}
	public void setNomD(String nomD) {
		this.nomD = nomD;
	}
	public String getPrenomD() {
		return prenomD;
	}
	public void setPrenomD(String prenomD) {
		this.prenomD = prenomD;
	}
	public String getNumD() {
		return numD;
	}
	public void setNumD(String numD) {
		this.numD = numD;
	}
	public String getEmailD() {
		return emailD;
	}
	public void setEmailD(String emailD) {
		this.emailD = emailD;
	}
	public String getCv() {
		return cv;
	}
	public void setCv(String cv) {
		this.cv = cv;
	}
	public Date getAnneeDebut() {
		return anneeDebut;
	}
	public void setAnneeDebut(Date anneeDebut) {
		this.anneeDebut = anneeDebut;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Directeurs() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Directeurs(long idDirec, String nomD, String prenomD, String numD, String emailD, String cv,
			Date anneeDebut) {
		super();
		this.idDirec = idDirec;
		this.nomD = nomD;
		this.prenomD = prenomD;
		this.numD = numD;
		this.emailD = emailD;
		this.cv = cv;
		this.anneeDebut = anneeDebut;
	}
	@Override
	public String toString() {
		return "Directeurs [idDirec=" + idDirec + ", nomD=" + nomD + ", prenomD=" + prenomD + ", numD=" + numD
				+ ", emailD=" + emailD + ", cv=" + cv + ", anneeDebut=" + anneeDebut + "]";
	}
	
	
	

}
