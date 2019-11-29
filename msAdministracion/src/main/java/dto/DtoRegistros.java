package dto;

public class DtoRegistros {
	private DtoLocalidad fields;

	public DtoRegistros() {}
	
	public DtoRegistros(DtoLocalidad fields) {
		super();
		this.fields = fields;
	}

	public DtoLocalidad getFields() {
		return fields;
	}

	public void setFields(DtoLocalidad fields) {
		this.fields = fields;
	}	
}
