package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daos.DaosJuzgados;
import model.Juzgado;

@Service
public class ServiceJuzgadosImpl implements ServiceJuzgados {

	@Autowired
	DaosJuzgados daos;
	
	@Override
	public List<Juzgado> buscarAllJuzgados() {
		List<Juzgado> juzgados = daos.findAll();
		return juzgados;
	}

	
	@Override
	public void altaJuzgado(Juzgado juzgado){
		
		if (!daos.existsById(juzgado.getIdJuzgado())) {
			daos.save(juzgado);
		}
		 
		  
	   
	}

}
