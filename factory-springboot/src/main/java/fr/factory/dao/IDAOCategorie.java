package fr.factory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.factory.model.Categorie;

public interface IDAOCategorie extends JpaRepository<Categorie, Integer>{
	
	

}
