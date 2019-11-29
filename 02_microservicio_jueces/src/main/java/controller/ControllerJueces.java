package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Juez;
import service.ServiceJueces;
@RestController
public class ControllerJueces {

	@Autowired
	ServiceJueces sJueces;

	@GetMapping(value="/lista",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Juez> listaJuzgados() {
		System.out.println("listaJueces");
		List<Juez> jueces= sJueces.buscarAllJueces();
		System.out.println("listaJueces: "+ jueces);
		return jueces;
	}
	

//	{"idJuez": 1,"apellidos": "alvarez","estado": "ACTIVO", "nombre": "pepe"}
	@PostMapping(value="/alta",consumes=MediaType.APPLICATION_JSON_VALUE)
	public void altaJuez(@RequestBody Juez juez) {
		System.out.println("altaJuez: "+juez);		
		sJueces.altaJuez(juez);
		
	}
	
	@DeleteMapping(value="baja/{idJuez}")
	public void bajaJuez(@PathVariable ("idJuez") int idJuez) {
		 sJueces.bajaLogicaJuez(idJuez);
		
	}
	
}
