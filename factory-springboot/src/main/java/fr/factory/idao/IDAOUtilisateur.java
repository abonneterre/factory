package fr.factory.idao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.factory.model.Utilisateur;


public interface IDAOUtilisateur extends JpaRepository<Utilisateur, Integer>{

}
