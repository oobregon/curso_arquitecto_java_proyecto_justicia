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
		int limInferior = 0;
		int desplazamiento = 100;
		String url = obtenerUrl(limInferior,desplazamiento);		
		DtoLocalidades jsonLocalidades = rest.getForObject(url,DtoLocalidades.class);
		insertarPorRangos(jsonLocalidades,limInferior,desplazamiento);			
	}
	
	private String obtenerUrl(int indice,int desplazamiento) {
		String url = "https://public.opendatasoft.com/api/records/1.0/search/?dataset=espana-municipios&start=" + indice + "&rows=" + desplazamiento + "&fields=cpro,provincia,cmun,municipio";
		return url;
	}	
	
	private void insertarPorRangos(DtoLocalidades jsonLocalidades,int indice,int desplazamiento) {		
		int numTotalRegs = jsonLocalidades.getNhits();
		int numNulos = 0;		
		do {			
			List<Localidad> lista = new ArrayList<Localidad>();
			List<DtoRegistros> registros = jsonLocalidades.getRecords();						
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
				}
			}
			daoLoc.saveAll(lista);
			String url = "";
			url = obtenerUrl(indice+=desplazamiento,desplazamiento);			
			jsonLocalidades = rest.getForObject(url,DtoLocalidades.class);			
		} while (indice < numTotalRegs);
		System.out.println("Localidades no insertadas: " + numNulos);
	}			
}
