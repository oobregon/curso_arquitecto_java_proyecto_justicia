package dto;

public class DtoLocalidad {
	
	int idLocalidad;
	String nombreLocalidad;
	
	
	public DtoLocalidad() {	
	}

	public DtoLocalidad(int idLocalidad, String nombreLocalidad) {
		super();
		this.idLocalidad = idLocalidad;
		this.nombreLocalidad = nombreLocalidad;
	}

	public int getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public String getNombreLocalidad() {
		return nombreLocalidad;
	}

	public void setNombreLocalidad(String nombreLocalidad) {
		this.nombreLocalidad = nombreLocalidad;
	}
	
	
	
	

}
