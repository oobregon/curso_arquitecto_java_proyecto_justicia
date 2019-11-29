package dto;

import java.io.Serializable;

public class DtoProvincia implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int Id;
	private int Fk_Variable;	            
	private String Nombre;
	private String Codigo;
	
	public DtoProvincia() {}
	
	public DtoProvincia(int id, int fk_Variable, String nombre, String codigo) {
		super();
		Id = id;
		Fk_Variable = fk_Variable;
		Nombre = nombre;
		Codigo = codigo;
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getFk_Variable() {
		return Fk_Variable;
	}
	public void setFk_Variable(int fk_Variable) {
		Fk_Variable = fk_Variable;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getCodigo() {
		return Codigo;
	}
	public void setCodigo(String codigo) {
		Codigo = codigo;
	}
}
