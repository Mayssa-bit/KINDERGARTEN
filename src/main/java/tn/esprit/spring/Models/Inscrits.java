package tn.esprit.spring.Models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "T_inscrits")
public class Inscrits implements Serializable {



	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="IDINSCRIP")
	long Idinscrip;
	@Column(name="IDENF")
	private String Idenf;
	@Column(name="FRAISINSCRIT")
	private String fraisinscrit;
	@Column(name="Etat")
	private String etat="non paye";
	
	@ManyToMany(cascade = CascadeType.ALL)
	
	private Set<Bus> bus;
	
	


	public String getIdenf() {
		return Idenf;
	}
	public void setIdenf(String idenf) {
		Idenf = idenf;
	}

	public String getFraisinscrit() {
		return fraisinscrit;
	}

	public void setFraisinscrit(String fraisinscrit) {
		this.fraisinscrit = fraisinscrit;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	@Override
	public String toString() {
		return "Inscrits [Idinscrip=" + Idinscrip + ", Idenf=" + Idenf + ", fraisinscrit=" + fraisinscrit + ", etat="
				+ etat + ", bus=" + bus + "]";
	}

	public Set<Bus> getBus() {
		return bus;
	}

	public void setBus(Set<Bus> bus) {
		this.bus = bus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public long getIdinscrip() {
		return Idinscrip;
	}
	public void setIdinscrip(long idinscrip) {
		Idinscrip = idinscrip;
	}
	public Inscrits(long idinscrip, String idenf, String fraisinscrit, String etat, Set<Bus> bus) {
		super();
		this.Idinscrip = idinscrip;
		this.Idenf = idenf;
		this.fraisinscrit = fraisinscrit;
		this.etat = etat;
		this.bus = bus;
	}
	public Inscrits() {
		super();
	}





	



	
	
	
	
	
	
	
}
