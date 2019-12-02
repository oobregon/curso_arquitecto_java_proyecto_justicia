package servicio;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger log = LoggerFactory.getLogger(ServicioLocalidadesImpl.class);
	private int posInicialPaginacion = 0;
	private int numRegsARecuperar = 500;
	
	@Autowired
	RestTemplate rest;
	
	@Autowired
	DaoLocalidades daoLoc;
	
	@Autowired
	DaoProvincias daoProv;

	@Override
	public void inicializarLocalidades() throws Exception {
		daoLoc.deleteAll();		
		DtoLocalidades jsonLocalidadesPorPagina = this.obtenerJsonParcial(posInicialPaginacion,numRegsARecuperar);
		insertarPaginando(jsonLocalidadesPorPagina.getNhits(),jsonLocalidadesPorPagina);			
	}
	
	private DtoLocalidades obtenerJsonParcial(int posInicial,int desplazamiento) {
		String url = "https://public.opendatasoft.com/api/records/1.0/search/?dataset=espana-municipios&start=" + posInicial + "&rows=" + desplazamiento + "&fields=cpro,provincia,cmun,municipio";
		return rest.getForObject(url,DtoLocalidades.class);
	}
	
	private void insertarPaginando(int numLocsEnEspaña,DtoLocalidades jsonParcialLocalidades) {				
		int numLocsNoValidas = 0;		
		do {						
			List<DtoRegistros> regslocalidadesPorPagina = jsonParcialLocalidades.getRecords();
			List<Localidad> localidadesPorPagina = new ArrayList<Localidad>();
			for(DtoRegistros regLocalidad : regslocalidadesPorPagina) {			
				DtoLocalidad dtoLocalidad = regLocalidad.getFields();
				try { 
					Provincia provincia = daoProv.findById(Integer.parseInt(dtoLocalidad.getCpro())).get();						
					Localidad localidad = new Localidad(Integer.parseInt(dtoLocalidad.getCmun()),dtoLocalidad.getMunicipio(),provincia);
					provincia.getLocalidades().add(localidad);
					localidadesPorPagina.add(localidad);
					
				} catch(Exception ex) {					
					numLocsNoValidas++;
				}
			}
			daoLoc.saveAll(localidadesPorPagina);				
			jsonParcialLocalidades = this.obtenerJsonParcial(posInicialPaginacion+=numRegsARecuperar,numRegsARecuperar);			
		} while (posInicialPaginacion < numLocsEnEspaña);					
		log.info("Localidades no insertadas: " + numLocsNoValidas);
	}	
}
