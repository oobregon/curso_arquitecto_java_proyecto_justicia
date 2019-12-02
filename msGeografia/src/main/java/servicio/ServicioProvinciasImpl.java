package servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.DaoProvincias;
import dto.DtoProvincia;
import model.Provincia;

@Service
public class ServicioProvinciasImpl implements ServicioProvincias {
	@Autowired
	DaoProvincias daoProv;
	
	
	@Override
	public DtoProvincia obtenerProvincia(int idProvincia) {
		Provincia p = daoProv.findById(idProvincia).get();
		DtoProvincia provincia = new DtoProvincia();
		provincia.setIdProvincia(p.getIdProvincia());
		provincia.setNombreProvincia(p.getNombreProvincia());
		return provincia;
	}

	@Override
	public List<DtoProvincia> obtenerProvincias() {
		List<DtoProvincia> provincias = new ArrayList<DtoProvincia>();
		for(Provincia p: daoProv.findAll()) {
			DtoProvincia provincia = new DtoProvincia();
			provincia.setIdProvincia(p.getIdProvincia());
			provincia.setNombreProvincia(p.getNombreProvincia());
			provincias.add(provincia);
		}
		return provincias;
	}
}
