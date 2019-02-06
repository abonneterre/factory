package fr.factory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.factory.model.Reservation;


public interface IDAOReservation extends JpaRepository<Reservation, Integer>{

}
