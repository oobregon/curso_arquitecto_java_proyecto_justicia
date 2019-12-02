package servicio;

import java.util.List;
import dto.DtoLocalidad;

public interface ServicioLocalidades {
	public List<DtoLocalidad> obtenerPorProvincia(int idProvincia);
	public DtoLocalidad obtenerLocalidad(int idLocalidad);
}
