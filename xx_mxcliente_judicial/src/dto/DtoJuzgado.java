package dto;

public class DtoJuzgado  {

	private int idJuzgado;


	private int idLocalidad;

	
	private int idProvincia;

	
	private int numeroJuzgado;

	public DtoJuzgado() {
	}
	
	

	public DtoJuzgado(int idJuzgado, int idLocalidad, int idProvincia, int numeroJuzgado) {
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