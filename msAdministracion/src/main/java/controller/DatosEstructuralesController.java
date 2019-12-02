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
	
	@GetMapping (value = "/iniciarGeografia/provincias",produces = MediaType.TEXT_PLAIN_VALUE) 
	public String inicializarProvincias() throws Exception {
		sProv.inicializarProvincias();		
		return "Inicialización Provincias finalizada con éxito";
	}
	
	@GetMapping (value = "/iniciarGeografia/localidades",produces = MediaType.TEXT_PLAIN_VALUE) 
	public String inicializarLocalidades() throws Exception {		
		sLoc.inicializarLocalidades();
		return "Inicialización Localidades finalizada con éxito";
	}
}
