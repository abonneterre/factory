package fr.factory.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.factory.model.Activite;

public interface IDAOActivite extends JpaRepository <Activite, Integer>{
	public List<Activite> findByActivee(boolean activee);

}
