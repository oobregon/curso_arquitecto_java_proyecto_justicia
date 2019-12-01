package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import servicio.ServicioLocalidades;
import servicio.ServicioProvincias;

@RestController
public class DatosEstructuralesController {
	@Autowired
	ServicioProvincias sProv;

	@Autowired
	ServicioLocalidades sLoc;
	
	@GetMapping (value = "/iniciarGeografia",produces = MediaType.TEXT_PLAIN_VALUE) 
	public String inicializar() throws Exception {
		sProv.inicializarProvincias();
		sLoc.inicializarLocalidades();
		return "Inicialización Provincias-Localidades finalizada con éxito";
	}
}
