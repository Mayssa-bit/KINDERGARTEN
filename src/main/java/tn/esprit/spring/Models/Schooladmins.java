/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.spring.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "schooladmins")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Schooladmins.findAll", query = "SELECT s FROM Schooladmins s")
    , @NamedQuery(name = "Schooladmins.findById", query = "SELECT s FROM Schooladmins s WHERE s.id = :id")
    , @NamedQuery(name = "Schooladmins.findByDescription", query = "SELECT s FROM Schooladmins s WHERE s.description = :description")})
public class Schooladmins implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Size(max = 65535)
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private Integer description;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "email")
    private String email;
    @Column(name="LOGO_E")
    String logoE;
    @Column(name="NUM_E")
    Float numE;
    @Column(name="DATECREA_E")
    Date dateCreaE;
    @Column(name="TARIF_E")
    String tarifE;
    @OneToOne
    private Directeurs directeurs; 
    @ManyToOne
    Evenements evenement;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schooladminId", fetch= FetchType.EAGER)
    @JsonIgnore
    private Collection<Classes> classesCollection;

    public Schooladmins() {
    }

    public Schooladmins(Integer id) {
        this.id = id;
    }

    public Schooladmins(Integer id, String email) {
        this.id = id;
        this.email = email;
    }
    
    

    public Schooladmins(@Size(max = 65535) String name, Integer description,
			@NotNull @Size(min = 1, max = 65535) String email, String logoE, Float numE, Date dateCreaE, String tarifE,
			Collection<Classes> classesCollection) {
		super();
		this.name = name;
		this.description = description;
		this.email = email;
		this.logoE = logoE;
		this.numE = numE;
		this.dateCreaE = dateCreaE;
		this.tarifE = tarifE;
		this.classesCollection = classesCollection;
	}

	public Schooladmins(Integer id, @Size(max = 65535) String name, Integer description,
			@NotNull @Size(min = 1, max = 65535) String email, String logoE, Float numE, Date dateCreaE, String tarifE,
			Collection<Classes> classesCollection) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.email = email;
		this.logoE = logoE;
		this.numE = numE;
		this.dateCreaE = dateCreaE;
		this.tarifE = tarifE;
		this.classesCollection = classesCollection;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDescription() {
        return description;
    }

    public void setDescription(Integer description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getLogoE() {
		return logoE;
	}

	public void setLogoE(String logoE) {
		this.logoE = logoE;
	}

	public Float getNumE() {
		return numE;
	}

	public void setNumE(Float numE) {
		this.numE = numE;
	}

	public Date getDateCreaE() {
		return dateCreaE;
	}

	public void setDateCreaE(Date dateCreaE) {
		this.dateCreaE = dateCreaE;
	}

	public String getTarifE() {
		return tarifE;
	}

	public void setTarifE(String tarifE) {
		this.tarifE = tarifE;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

   

    @XmlTransient
    public Collection<Classes> getClassesCollection() {
        return classesCollection;
    }

    public void setClassesCollection(Collection<Classes> classesCollection) {
        this.classesCollection = classesCollection;
    }
  
    
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Schooladmins other = (Schooladmins) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

	@Override
    public String toString() {
        return "com.Esprit.KinderGarten.model.Schooladmins[ id=" + id + " ]";
    }
    
}
