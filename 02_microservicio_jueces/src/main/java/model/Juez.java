package model;


import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the jueces database table.
 * 
 */
@Entity
@Table(name="jueces")
@NamedQuery(name="Juez.findAll", query="SELECT j FROM Juez j")
public class Juez implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_juez")
	private int idJuez;

	private String apellidos;

	private String estado;

	private String nombre;

	public Juez() {
	}

	public int getIdJuez() {
		return this.idJuez;
	}

	public void setIdJuez(int idJuez) {
		this.idJuez = idJuez;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}