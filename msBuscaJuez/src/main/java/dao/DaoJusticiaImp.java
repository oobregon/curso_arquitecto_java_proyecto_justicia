package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class DaoJusticiaImp implements DaoJusticia {
	@Autowired
	JdbcTemplate accDB;

	@Override
	public int obtenerIdJuez() {
		String sql = "SELECT ju.id_juez\r\n" + 
	                 "  FROM jueces ju LEFT JOIN instrucciones ins ON ju.id_juez = ins.id_juez\r\n" + 
				     " WHERE ju.estado = 'ACTIVO'\r\n" + 
				     " GROUP BY ju.id_juez\r\n" + 
				     " ORDER BY COUNT(ins.id_instruccion)\r\n" + 
				     " LIMIT 1";
		return accDB.queryForObject(sql,Integer.class);
	}

	@Transactional
	@Override
	public void actualizarInstruccion(int idInstruccion, int idJuez, String estado) {
		String sql = "UPDATE instrucciones SET id_juez = ?, estado = ? WHERE id_instruccion = ?";
		accDB.update(sql,idJuez,estado,idInstruccion);
	}

	@Override
	public int obtenerInstruccion() {
		String sql = "SELECT id_instruccion FROM instrucciones WHERE estado = 'PENDIENTE_ASIGNACION' order by fecha_inicio LIMIT 1";
		return accDB.queryForObject(sql,Integer.class);
	}

	@Override
	public int numInstruccionsPendientes() {
		String sql = "SELECT COUNT(*) FROM instrucciones WHERE estado = 'PENDIENTE_ASIGNACION'";
		return accDB.queryForObject(sql,Integer.class);
	}
}
