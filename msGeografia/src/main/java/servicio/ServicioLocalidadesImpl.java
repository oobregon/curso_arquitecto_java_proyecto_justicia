package servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.DaoLocalidades;
import dao.DaoProvincias;
import dto.DtoLocalidad;
import model.Localidad;

@Service
public class ServicioLocalidadesImpl implements ServicioLocalidades {	
	@Autowired
	DaoLocalidades daoLoc;
	
	@Autowired
	DaoProvincias daoProv;

	@Override
	public List<DtoLocalidad> obtenerPorProvincia(int idProvincia) {	
		List<Localidad> lista = daoLoc.findByIdProvincia(idProvincia);
		List<DtoLocalidad> localidades = new ArrayList<DtoLocalidad>(); 
		for(Localidad l:lista) {
			DtoLocalidad localidad = new DtoLocalidad();
			localidad.setCmun(new Integer(l.getIdLocalidad()).toString());
			localidad.setCpro(new Integer(l.getIdProvincia()).toString());
			localidad.setMunicipio(l.getNombreMunicipio());
			localidad.setProvincia(l.getProvincia().getNombreProvincia());
			localidades.add(localidad);
		}
		return localidades;
	}

	@Override
	public DtoLocalidad obtenerLocalidad(int idLocalidad) {
		Localidad l = daoLoc.findById(idLocalidad).get();
		DtoLocalidad localidad = new DtoLocalidad();
		localidad.setCmun(new Integer(l.getIdLocalidad()).toString());
		localidad.setCpro(new Integer(l.getIdProvincia()).toString());
		localidad.setMunicipio(l.getNombreMunicipio());
		localidad.setProvincia(l.getProvincia().getNombreProvincia()); 
		return localidad;
	}
}
