package fr.factory.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.factory.dao.IDAOProposition;
import fr.factory.model.Lieu;
import fr.factory.model.Proposition;
import fr.factory.model.Reservation;
import fr.factory.projection.Views;


@RestController
@CrossOrigin("*") 
public class PropositionRestController {
	
	@Autowired
	private IDAOProposition daoProposition;
	
	@PostMapping("/api/proposition")
	@JsonView(Views.Proposition.class)
	public Proposition ajouterProposition(@RequestBody Proposition proposition) {
		this.daoProposition.save(proposition);
//		reservation.setActivite(this.daoActivite.findById(reservation.getActivite().getId()).get());
		
		return proposition;
	}
	
	
	
//	@GetMapping("/api/propo")
//	@JsonView(Views.LieuWithUtilisateur.class)
//	public List<Proposition> listeLieu() {
//			return this.daoProposition.findAll();
//	}
}

	
