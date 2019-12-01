package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Localidad;

public interface DaoLocalidades extends JpaRepository<Localidad,Integer> {
	List<Localidad> findByIdProvincia(int idProvincia);
}
