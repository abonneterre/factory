package fr.factory.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.factory.dao.IDAOActivite;
import fr.factory.dao.IDAOReservation;
import fr.factory.model.Reservation;
import fr.factory.projection.Views;



@RestController
@CrossOrigin("*") 
public class ReservationRestController {

	
	@Autowired
	private IDAOReservation daoReservation;
	@Autowired
	private IDAOActivite daoActivite;
	
	

		
	@PostMapping("/api/reservation")
	@JsonView(Views.ReservationWithActivite.class)
	public Reservation ajouterReservation(@RequestBody Reservation reservation) {
		System.out.println(reservation.getNom());
		this.daoReservation.save(reservation);
		
		reservation.setActivite(this.daoActivite.findById(reservation.getActivite().getId()).get());
		
		return reservation;
	}
}
