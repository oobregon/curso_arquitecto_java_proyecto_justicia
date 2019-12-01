package dto;

import java.io.Serializable;

public class DtoLocalidad implements Serializable {
	private static final long serialVersionUID = 1L;
	private String cpro;
	private String provincia;
	private String cmun;	
	private String municipio;
	
	public DtoLocalidad() {}
	
	public DtoLocalidad(String cpro, String provincia, String cmun, String municipio) {
		super();
		this.cpro = cpro;
		this.provincia = provincia;
		this.cmun = cmun;
		this.municipio = municipio;
	}
	public String getCpro() {
		return cpro;
	}
	public void setCpro(String cpro) {
		this.cpro = cpro;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}	
	public String getCmun() {
		return cmun;
	}

	public void setCmun(String cmun) {
		this.cmun = cmun;
	}
}
