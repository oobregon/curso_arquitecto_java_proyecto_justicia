package servicio;

import java.util.List;

import model.Provincia;

public interface ServicioProvincias {
	void inicializarProvincias();	
	Provincia obtenerProvincia(int idProvincia);
	List<Provincia> obtenerProvincias();
}
