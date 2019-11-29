package controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping (value = "/iniciarGeografia")
	public void inicializar() {
		sProv.inicializarProvincias();
		sLoc.inicializarLocalidades();		
	}
}
