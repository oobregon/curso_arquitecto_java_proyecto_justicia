package controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Juez;
import service.ServiceJueces;
@CrossOrigin(origins="*")
@RestController
public class ControllerJueces {

	@Autowired
	ServiceJueces sJueces;

	@GetMapping(value="/lista",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Juez> listaJuzgados() {
		List<Juez> jueces= sJueces.buscarAllJueces();
		return jueces;
	}
	

//	{"idJuez": 1,"apellidos": "alvarez","estado": "ACTIVO", "nombre": "pepe"}
	@PostMapping(value="/alta",consumes=MediaType.APPLICATION_JSON_VALUE)
	public void altaJuez(@RequestBody Juez juez) {
		sJueces.altaJuez(juez);
		
	}
	
	@CrossOrigin(origins="*")
	@DeleteMapping(value="/cambioEstado/{idJuez}")
	public void cambioEstadoJuez(@PathVariable ("idJuez") int idJuez) {
		 sJueces.cambioEstadoJuez(idJuez);
		
	}
	
}
