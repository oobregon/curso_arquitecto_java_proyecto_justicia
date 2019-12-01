package dto;

public class DtoJuez  {

	private int idJuez;

	private String apellidos;

	private String estado;

	private String nombre;

	public DtoJuez() {
	}
	
	public DtoJuez(int idJuez, String apellidos, String estado, String nombre) {
		super();
		this.idJuez = idJuez;
		this.apellidos = apellidos;
		this.estado = estado;
		this.nombre = nombre;
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