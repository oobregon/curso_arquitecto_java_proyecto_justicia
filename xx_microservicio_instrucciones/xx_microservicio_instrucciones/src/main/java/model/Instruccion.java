package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the instrucciones database table.
 * 
 */
@Entity
@Table(name="instrucciones")
@NamedQuery(name="Instruccion.findAll", query="SELECT i FROM Instruccion i")
public class Instruccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_instruccion")
	private int idInstruccion;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio")
	private Date fechaInicio;

	@Column(name="id_juez")
	private int idJuez;

	@Column(name="id_juzgado")
	private int idJuzgado;

	@Column(name="nombre_proceso")
	private String nombreProceso;

	@Column(name="numero_piezas")
	private int numeroPiezas;

	public Instruccion() {
	}

	
	public Instruccion(int idInstruccion, String estado, Date fechaInicio, int idJuez, int idJuzgado,
			String nombreProceso, int numeroPiezas) {
		super();
		this.idInstruccion = idInstruccion;
		this.estado = estado;
		this.fechaInicio = fechaInicio;
		this.idJuez = idJuez;
		this.idJuzgado = idJuzgado;
		this.nombreProceso = nombreProceso;
		this.numeroPiezas = numeroPiezas;
	}



	public int getIdInstruccion() {
		return this.idInstruccion;
	}

	public void setIdInstruccion(int idInstruccion) {
		this.idInstruccion = idInstruccion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public int getIdJuez() {
		return this.idJuez;
	}

	public void setIdJuez(int idJuez) {
		this.idJuez = idJuez;
	}

	public int getIdJuzgado() {
		return this.idJuzgado;
	}

	public void setIdJuzgado(int idJuzgado) {
		this.idJuzgado = idJuzgado;
	}

	public String getNombreProceso() {
		return this.nombreProceso;
	}

	public void setNombreProceso(String nombreProceso) {
		this.nombreProceso = nombreProceso;
	}

	public int getNumeroPiezas() {
		return this.numeroPiezas;
	}

	public void setNumeroPiezas(int numeroPiezas) {
		this.numeroPiezas = numeroPiezas;
	}

}