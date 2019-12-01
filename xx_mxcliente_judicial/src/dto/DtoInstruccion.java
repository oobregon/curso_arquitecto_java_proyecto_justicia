package dto;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class DtoInstruccion {
	
	private int idInstruccion;

	private String estado;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaInicio;
	
	private int idJuez;
	
	private int idJuzgado;
	
	private String nombreProceso;
	
	private int numeroPiezas;
	
	public DtoInstruccion() {
	}


	public DtoInstruccion(int idInstruccion, String estado, Date fechaInicio, int idJuez, int idJuzgado,
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
		return idInstruccion;
	}


	public void setIdInstruccion(int idInstruccion) {
		this.idInstruccion = idInstruccion;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Date getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public int getIdJuez() {
		return idJuez;
	}


	public void setIdJuez(int idJuez) {
		this.idJuez = idJuez;
	}


	public int getIdJuzgado() {
		return idJuzgado;
	}


	public void setIdJuzgado(int idJuzgado) {
		this.idJuzgado = idJuzgado;
	}


	public String getNombreProceso() {
		return nombreProceso;
	}


	public void setNombreProceso(String nombreProceso) {
		this.nombreProceso = nombreProceso;
	}


	public int getNumeroPiezas() {
		return numeroPiezas;
	}


	public void setNumeroPiezas(int numeroPiezas) {
		this.numeroPiezas = numeroPiezas;
	}


	
}
