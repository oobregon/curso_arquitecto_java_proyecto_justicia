package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dao.DaoInstruccion;
import model.Instruccion;

@CrossOrigin(origins="*")
@RestController
public class InstruccionController {
	
	@Autowired
	DaoInstruccion di;
	
	@PostMapping(value = "/alta", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void alta(@RequestBody Instruccion instruccion) {
		instruccion.setEstado("PENDIENTE_ASIGNACION");
		di.save(instruccion);
		
	}
	
	@GetMapping (value = "/listaJuez/{juez}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List <Instruccion> getInstrucionByJuez (@PathVariable ("juez") int juez) {
		return di.findByIdJuez(juez);
				
	}
	
	@GetMapping (value = "/listajuzgado/{juzgado}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List <Instruccion> getInstrucionByJuzgado (@PathVariable ("juzgado") int juzgado) {
		return di.findByIdJuzgado(juzgado);
				
	}
	
	@GetMapping (value = "/listajuzgadoEstado/{juzgado}/{estado}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List <Instruccion> getInstrucionByEstado (@PathVariable ("juzgado") int juzgado,@PathVariable ("estado") String estado) {
		return di.findByIdJuzgadoAndEstado(juzgado, estado);
				
	}
	
	
	@PutMapping (value = "/actualizar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void actualizarPlazas(@PathVariable ("id") int idInstruc ) {
		Optional <Instruccion> inst= di.findById(idInstruc);
		Instruccion instrucc=inst.get();
		instrucc.setEstado("FINALIZADO");
		di.save(instrucc);
		
	}
	
}
