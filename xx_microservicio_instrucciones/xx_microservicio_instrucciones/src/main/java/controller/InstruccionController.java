package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
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
	
	
	@PutMapping (value = "/finalizar/{id}")
	public void finalizarInstruccion(@PathVariable ("id") int idInstruc ) {
		Optional <Instruccion> inst= di.findById(idInstruc);
		Instruccion instrucc=inst.get();
		instrucc.setEstado("FINALIZADO");
		di.save(instrucc);
		
	}
	
	@CrossOrigin(origins="*")
	@PutMapping (value = "/actualizar/{idJuez}")
	@Transactional
	public void actualizarInstruccion(@PathVariable ("idJuez") int idJuez ) {
		List<Instruccion> listaInst= di.findByIdJuez(idJuez);
	    //System.out.println("--> lista instruciones del juez a eliminiar:"+listaInst.size());
		for(Instruccion lis:listaInst) {
			//System.out.println("-->estado:"+lis.getEstado());
			if(lis.getEstado().equals("EN_PROCESO")) {
				lis.setEstado("PENDIENTE_ASIGNACION");
				lis.setIdJuez(0);
				///System.out.println("-->ahora estado:"+lis.getEstado());
				di.save(lis);
			}
		}
	    
		
	}
	
}