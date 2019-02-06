package fr.factory.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import fr.factory.model.Reservation;



@RestController
@CrossOrigin("*") 
public class ReservationRestController {

	
	@Autowired
	private IDAOReservation daoReservation;
	
	
	@GetMapping("/api/reservation")
//	@JsonView(Views.Reservation.class)
	public  List<Reservation> listeReservation(@RequestBody Reservation reservation) {

		public List<Reservation> listeRest() {
			return this.daoReservation.findAll();
	}
	
}
