package fr.factory.idao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.factory.model.Lieu;


public interface IDAOLieu extends JpaRepository<Lieu, Integer>{

}
