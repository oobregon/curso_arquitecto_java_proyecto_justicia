package service;

import java.util.List;

import model.Juez;


public interface ServiceJueces {

	List<Juez> buscarAllJueces();
	void altaJuez(Juez juez);
	void bajaLogicaJuez(int idJuez);
	
	
}