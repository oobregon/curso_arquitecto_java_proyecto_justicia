package daos;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Juzgado;

public interface DaosJuzgados extends JpaRepository<Juzgado,Integer> {
	
//	List<Juzgado> buscarALLJuzgados();
//	void altaJuzgado(Juzgado juzgado);
//	void actualizarJuzgado(Juzgado juzgado);
//	void eliminarJuzgado(int id_juzgado);

}
