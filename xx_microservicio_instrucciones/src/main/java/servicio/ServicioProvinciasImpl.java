package servicio;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dao.DaoProvincias;
import dto.DtoLocalidades;
import model.Provincia;

@Service
public class ServicioProvinciasImpl implements ServicioProvincias {
	@Autowired
	RestTemplate rest;
	
	@Autowired
	DaoProvincias daoProv;
	
	//@Override
	public void inicializarProvincias() {
		String url = "http://servicios.ine.es/wstempus/js/ES/VALORES_VARIABLEOPERACION/115/22?page=1";		
		List provsEncapsuladas = rest.getForObject(url,List.class);
		List<Provincia> provincias = obtenerEntidades(provsEncapsuladas); 
		daoProv.deleteAll();
		daoProv.saveAll(provincias);
	}
	
	private List<Provincia> obtenerEntidades(List provsEncap) {
		List<Provincia> provincias = new ArrayList<Provincia>();
		for(Object m:provsEncap) {
			LinkedHashMap<String,Object> provMapeada = (LinkedHashMap<String,Object>)m;
			Provincia provincia = new Provincia();				
			provincia.setNombreProvincia(provMapeada.get("Nombre").toString());
			provincia.setIdProvincia(Integer.parseInt(provMapeada.get("Codigo").toString()));	
			provincias.add(provincia);
		}
		return provincias;
	}
	
	
	@Override
	public Provincia obtenerProvincia(int idProvincia) {
		return daoProv.findById(idProvincia).get();
	}

	@Override
	public List<Provincia> obtenerProvincias() {
		return daoProv.findAll();
	}
}
