package dto;

public class ItemInstruccion {
	
	
	private int idInstruccion;

	private String estado;
	
	
	private String fechaInicio;
	
	private int idJuez;
	
	private int idJuzgado;
	
    private String nombreProceso;
	
	private int numeroPiezas;

	public ItemInstruccion() {
		
	}

		public ItemInstruccion(int idInstruccion, String estado, String fechaInicio, int idJuez, int idJuzgado,
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

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
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
	
	
	

}
