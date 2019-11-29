package dto;

public class Localidad {

	private int idLocalidad;
	private String nombreLocalidad;
	
	public Localidad() {
		super();
	}
	public Localidad(int idLocalidad, String nombreLocalidad) {
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
