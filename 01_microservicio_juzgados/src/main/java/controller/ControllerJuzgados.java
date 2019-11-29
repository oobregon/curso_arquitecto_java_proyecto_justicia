package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Juzgado;
import service.ServiceJuzgados;
@RestController
public class ControllerJuzgados {

	@Autowired
	ServiceJuzgados sJuzgados;

	@GetMapping(value="/lista",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Juzgado> listaJuzgados() {
//		System.out.println("listaJuzgados");
		List<Juzgado> juzgados= sJuzgados.buscarAllJuzgados();
//		System.out.println("listaJuzgados: "+ juzgados);
		return juzgados;
	}
	
//		{"idJuzgado": 1,"idLocalidad": 1, "idProvincia": 1, "numeroJuzgado": 333 }
	@PostMapping(value="/alta",consumes=MediaType.APPLICATION_JSON_VALUE)
	public void altaJuzgado(@RequestBody Juzgado juzgado) {
		System.out.println("altaJuzgado: "+juzgado);		
			sJuzgados.altaJuzgado(juzgado);
			
	}
	
}
