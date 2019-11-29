package servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dao.DaoLocalidades;
import dao.DaoProvincias;
import dto.DtoLocalidad;
import dto.DtoLocalidades;
import dto.DtoRegistros;
import model.Localidad;
import model.Provincia;

@Service
public class ServicioLocalidadesImpl implements ServicioLocalidades {	
	@Autowired
	RestTemplate rest;
	
	@Autowired
	DaoLocalidades daoLoc;
	
	@Autowired
	DaoProvincias daoProv;

	@Override
	public void inicializarLocalidades() {
		daoLoc.deleteAll();
		DtoLocalidades jsonLocalidades = rest.getForObject(obtenerUrl(0),DtoLocalidades.class);
		insertarPaginando(jsonLocalidades,0);			
	}
	
	private String obtenerUrl(int indice) {
		String url = "https://public.opendatasoft.com/api/records/1.0/search/?dataset=espana-municipios&start=" + indice + "&rows=" + indice + "&fields=cpro,provincia,cmun,municipio";
		return url;
	}	
	
	private void insertarPaginando(DtoLocalidades jsonLocalidades,int indice) {		
		int numTotalRegs = jsonLocalidades.getNhits();
		int numNulos = 0;
		do {			
			List<DtoRegistros> registros = jsonLocalidades.getRecords();
			List<Localidad> lista = new ArrayList<Localidad>();
			for(DtoRegistros reg : registros) {			
				DtoLocalidad dtoLocalidad = reg.getFields();
				try {
					Provincia provincia = daoProv.findById(Integer.parseInt(dtoLocalidad.getCpro())).get();
					Localidad localidad = new Localidad(Integer.parseInt(dtoLocalidad.getCmun()),
							Integer.parseInt(dtoLocalidad.getCpro()),
	                        dtoLocalidad.getMunicipio(),
	                        provincia);					
					lista.add(localidad);
				} catch(Exception ex) {
					numNulos++;
					System.out.println("Null en algo:" + dtoLocalidad.getMunicipio() + " " + dtoLocalidad.getCmun() + " " + 
							dtoLocalidad.getCpro() + " " + dtoLocalidad.getProvincia());
				}
			}
			daoLoc.saveAll(lista);
			jsonLocalidades = rest.getForObject(obtenerUrl(indice+=500),DtoLocalidades.class);
		} while (indice < numTotalRegs);
		System.out.println("Localidades no insertadas: " + numNulos);
	}		
	

	@Override
	public List<Localidad> obtenerPorProvincia(int idProvincia) {		
		return daoLoc.findByIdProvincia(idProvincia);
	}

	@Override
	public Localidad obtener(int idLocalidad) {
		return daoLoc.findById(idLocalidad).get();
	}
}
