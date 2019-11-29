package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Instruccion;

public interface DaoInstruccion extends JpaRepository<Instruccion, Integer> {

	List <Instruccion> findByIdJuez(int idJuez);
	
	List <Instruccion> findByIdJuzgado(int idJuzgado);
	
	List <Instruccion> findByIdJuzgadoAndEstado(int idJuzgado, String estado);
	

}
