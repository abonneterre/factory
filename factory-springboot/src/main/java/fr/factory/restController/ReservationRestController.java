package fr.factory.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.factory.dao.IDAOReservation;
import fr.factory.model.Categorie;
import fr.factory.model.Reservation;



@RestController
@CrossOrigin("*") 
public class ReservationRestController {

	
	@Autowired
	private IDAOReservation daoReservation;
	
	

		
	@PostMapping("/api/reservation")
//	@JsonView(Views.Reservation.class)
	public Reservation ajouterReservation(@RequestBody Reservation reservation) {
		System.out.println(reservation.getNom());
		this.daoReservation.save(reservation);
		return reservation;
	}
}
