package service;

import java.util.List;

import model.Juzgado;

public interface ServiceJuzgados {

	List<Juzgado> buscarAllJuzgados();
	void altaJuzgado(Juzgado juzgado);
	
	
	
}