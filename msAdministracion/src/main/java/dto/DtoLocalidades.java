package dto;

import java.io.Serializable;
import java.util.List;

public class DtoLocalidades implements Serializable {
	private int nhits;
	private List<DtoRegistros> records;
	
	public DtoLocalidades() {}


	public DtoLocalidades(int nhits, List<DtoRegistros> records) {
		super();
		this.nhits = nhits;
		this.records = records;
	}

	public List<DtoRegistros> getRecords() {
		return records;
	}

	public void setRecords(List<DtoRegistros> records) {
		this.records = records;
	}

	public int getNhits() {
		return nhits;
	}

	public void setNhits(int nhits) {
		this.nhits = nhits;
	}
	
}
