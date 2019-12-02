package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Localidad;

public interface DaoLocalidades extends JpaRepository<Localidad,Integer> {}
