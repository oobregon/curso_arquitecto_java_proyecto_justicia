package dto;

public class DtoProvincia {	
	private int idProvincia;
	private String nombreProvincia;	
	
	public DtoProvincia(int idProvincia, String nombreProvincia) {
		super();
		this.idProvincia = idProvincia;
		this.nombreProvincia = nombreProvincia;
	}

	public DtoProvincia() {}

	public int getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getNombreProvincia() {
		return nombreProvincia;
	}

	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}		
}
