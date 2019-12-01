package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dto.DtoLocalidad;
import dto.DtoProvincia;
import servicio.ServicioLocalidades;
import servicio.ServicioProvincias;

@RestController
public class GeografiaController {
	@Autowired
	ServicioProvincias sProv;

	@Autowired
	ServicioLocalidades sLoc;
	
	@GetMapping (value = "/provincias",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DtoProvincia> obtenerProvincia() {
		return sProv.obtenerProvincias();
	}
	
	@GetMapping (value = "/provincias/{idProv}", produces = MediaType.APPLICATION_JSON_VALUE)
	public DtoProvincia obtenerProvincia(@PathVariable("idProv") int idProvincia) {
		return sProv.obtenerProvincia(idProvincia);
	}
	
	@GetMapping (value = "/localidades/porProvincia/{idProv}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DtoLocalidad> obtenerLocalidadesPorProvincia(@PathVariable("idProv") int idProvincia) {
		return sLoc.obtenerPorProvincia(idProvincia);		
	}
	
	@GetMapping (value = "/localidades/{idLoc}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public DtoLocalidad obtenerLocalidad(@PathVariable("idLoc") int idLocalidad) {
		return sLoc.obtenerLocalidad(idLocalidad);
	}
}
