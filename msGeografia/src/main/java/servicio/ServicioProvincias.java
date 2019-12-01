package servicio;

import java.util.List;
import dto.DtoProvincia;

public interface ServicioProvincias {	
	DtoProvincia obtenerProvincia(int idProvincia);
	List<DtoProvincia> obtenerProvincias();
}
