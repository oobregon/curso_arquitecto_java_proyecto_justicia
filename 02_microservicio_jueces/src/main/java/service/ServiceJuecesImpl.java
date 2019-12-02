package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daos.DaosJueces;
import model.Juez;

@Service
public class ServiceJuecesImpl implements ServiceJueces {

	@Autowired
	DaosJueces daos;
	
	@Override
	public List<Juez> buscarAllJueces() {
		List<Juez> juzgados = daos.findAll();
		return juzgados;
	}

	
	@Override
	public void altaJuez(Juez juez){
		if (!daos.existsById(juez.getIdJuez())) {
			daos.save(juez);
		}
		 
	   
	}


	@Override
	public void cambioEstadoJuez(int idJuez) {
		Optional<Juez> juezO = daos.findById(idJuez);
		Juez juez = juezO.orElse(null);	
		String estado=null;
		if (juez!= null) {
			if (juez.getEstado().equals("ACTIVO")) {
				estado = "INACTIVO";
			}else {
				estado = "ACTIVO";
			}	
			juez.setEstado(estado);
			daos.save(juez);
		}
			
		
		
	}

}
