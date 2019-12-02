package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the localidades database table.
 * 
 */
@Entity
@Table(name="localidades")
@NamedQuery(name="Localidad.findAll", query="SELECT l FROM Localidad l")
public class Localidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_localidad")
	private int idLocalidad;

	@Column(name="nombre_municipio")
	private String nombreMunicipio;

	//bi-directional many-to-one association to Provincia
	@ManyToOne
	@JoinColumn(name="id_provincia",referencedColumnName = "id_provincia")
	private Provincia provincia;

	public Localidad() {
	}

	
	public Localidad(int idLocalidad, String nombreMunicipio, Provincia provincia) {
		super();
		this.idLocalidad = idLocalidad;
		this.nombreMunicipio = nombreMunicipio;
		this.provincia = provincia;
	}


	public int getIdLocalidad() {
		return this.idLocalidad;
	}

	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public String getNombreMunicipio() {
		return this.nombreMunicipio;
	}

	public void setNombreMunicipio(String nombreMunicipio) {
		this.nombreMunicipio = nombreMunicipio;
	}

	public Provincia getProvincia() {
		return this.provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

}