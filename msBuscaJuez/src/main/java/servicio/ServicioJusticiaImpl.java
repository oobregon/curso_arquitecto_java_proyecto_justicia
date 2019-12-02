package servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import dao.DaoJusticia;

@Service
public class ServicioJusticiaImpl implements ServicioJusticia {
	
	@Autowired
	DaoJusticia daoJus;
	
	@Scheduled(fixedRate = 60000)
	@Override
	public void asignarJuezAInstrccPndtes() {
		int instruccionsPendientes = daoJus.numInstruccionsPendientes();
		if(instruccionsPendientes > 0) {
			int idJuez = daoJus.obtenerIdJuez();
			int idInstruccion = daoJus.obtenerInstruccion();
			daoJus.actualizarInstruccion(idInstruccion,idJuez,"EN_PROCESO");
		}
	}
}
