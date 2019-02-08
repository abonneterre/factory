package fr.factory.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.factory.model.Reservation;


public interface IDAOReservation extends JpaRepository<Reservation, Integer>{
	
	@Query("select sum(r.nbParticipants) from Reservation r where r.activite.id = :id group by r.activite.id")
	public Integer getSumNbParticipantsByActiviteId(@Param("id") int id);
}
