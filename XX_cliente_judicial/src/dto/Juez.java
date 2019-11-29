package dto;

public class Juez {

	private int idJuez;

	private String apellidos;

	private String estado;

	private String nombre;

	public Juez() {
		super();
	}

	public Juez(int idJuez, String apellidos, String estado, String nombre) {
		super();
		this.idJuez = idJuez;
		this.apellidos = apellidos;
		this.estado = estado;
		this.nombre = nombre;
	}

	public int getIdJuez() {
		return idJuez;
	}

	public void setIdJuez(int idJuez) {
		this.idJuez = idJuez;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
}
