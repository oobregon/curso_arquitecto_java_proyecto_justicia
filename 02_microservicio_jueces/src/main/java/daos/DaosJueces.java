package daos;


import org.springframework.data.jpa.repository.JpaRepository;

import model.Juez;



public interface DaosJueces extends JpaRepository<Juez,Integer> {
	
//	List<Juez> buscarAllJueces();
//	void altaJuez(Juez juez);
//	void actualizarJuez(Juez juez);
//	void eliminarJuez(int id_juez);

}
