package servicio;

import java.util.List;

import model.Localidad;

public interface ServicioLocalidades {
	public void inicializarLocalidades();
	public List<Localidad> obtenerPorProvincia(int idProvincia);
	public Localidad obtener(int idLocalidad);
}
