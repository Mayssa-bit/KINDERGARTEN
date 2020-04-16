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
@Table(name = "T_Activites")
public class Activités implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="IDACT")
	private Long idact; // 
	@Column(name="NOMA")
	private String NomA; // 
	@Column(name="TYPEA")
	private String TypeA; // 
	@Column(name="DESCRIPA")
	private String DescripA;
	@Column(name="DATEA")
	@Temporal (TemporalType.DATE) 
	private Date dateA;
	@Column(name="IMAGEA")
	private String imageA; //
	@Column(name="NOMANIMATEUR")
	private String nomanimateur; //
	public Long getIdact() {
		return idact;
	}
	public void setIdact(Long idact) {
		this.idact = idact;
	}
	public String getNomA() {
		return NomA;
	}
	public void setNomA(String nomA) {
		NomA = nomA;
	}
	public String getTypeA() {
		return TypeA;
	}
	public void setTypeA(String typeA) {
		TypeA = typeA;
	}
	public String getDescripA() {
		return DescripA;
	}
	public void setDescripA(String descripA) {
		DescripA = descripA;
	}
	public Date getDateA() {
		return dateA;
	}
	public void setDateA(Date dateA) {
		this.dateA = dateA;
	}
	public String getImageA() {
		return imageA;
	}
	public void setImageA(String imageA) {
		this.imageA = imageA;
	}
	public String getNomanimateur() {
		return nomanimateur;
	}
	public void setNomanimateur(String nomanimateur) {
		this.nomanimateur = nomanimateur;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Activités [idact=" + idact + ", NomA=" + NomA + ", TypeA=" + TypeA + ", DescripA=" + DescripA
				+ ", dateA=" + dateA + ", imageA=" + imageA + ", nomanimateur=" + nomanimateur + "]";
	}
	public Activités(Long idact, String nomA, String typeA, String descripA, Date dateA, String imageA,
			String nomanimateur) {
		super();
		this.idact = idact;
		NomA = nomA;
		TypeA = typeA;
		DescripA = descripA;
		this.dateA = dateA;
		this.imageA = imageA;
		this.nomanimateur = nomanimateur;
	}
	public Activités(String nomA, String typeA, String descripA, Date dateA, String imageA, String nomanimateur) {
		super();
		NomA = nomA;
		TypeA = typeA;
		DescripA = descripA;
		this.dateA = dateA;
		this.imageA = imageA;
		this.nomanimateur = nomanimateur;
	}
	public Activités() {
		super();
	}
	
	
	
	

}
