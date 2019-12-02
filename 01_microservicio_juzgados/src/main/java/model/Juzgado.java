package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the juzgados database table.
 * 
 */
@Entity
@Table(name="juzgados")
@NamedQuery(name="Juzgado.findAll", query="SELECT j FROM Juzgado j")
public class Juzgado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_juzgado")
	private int idJuzgado;

	@Column(name="id_localidad")
	private int idLocalidad;

	@Column(name="id_provincia")
	private int idProvincia;

	@Column(name="numero_juzgado")
	private int numeroJuzgado;

	public Juzgado() {
	}
	
	

	public Juzgado(int idJuzgado, int idLocalidad, int idProvincia, int numeroJuzgado) {
		super();
		this.idJuzgado = idJuzgado;
		this.idLocalidad = idLocalidad;
		this.idProvincia = idProvincia;
		this.numeroJuzgado = numeroJuzgado;
	}


	public int getIdJuzgado() {
		return this.idJuzgado;
	}

	public void setIdJuzgado(int idJuzgado) {
		this.idJuzgado = idJuzgado;
	}

	public int getIdLocalidad() {
		return this.idLocalidad;
	}

	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public int getIdProvincia() {
		return this.idProvincia;
	}

	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}

	public int getNumeroJuzgado() {
		return this.numeroJuzgado;
	}

	public void setNumeroJuzgado(int numeroJuzgado) {
		this.numeroJuzgado = numeroJuzgado;
	}

}