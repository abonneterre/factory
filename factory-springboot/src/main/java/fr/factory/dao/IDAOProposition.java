package fr.factory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.factory.model.Proposition;

public interface IDAOProposition extends JpaRepository<Proposition, Integer>{

}
