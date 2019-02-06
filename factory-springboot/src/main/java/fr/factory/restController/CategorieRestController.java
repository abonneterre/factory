package fr.factory.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.annotation.JsonView;

import fr.factory.model.Categorie;


@RestController
@CrossOrigin("*") 
public class CategorieRestController {

	
	
	@Autowired
	private IDAOCategorie daoCategorie;
	
	
	@PostMapping
//	@JsonView(Views.Reservation.class)
	public Categorie ajouterReservation(@RequestBody Categorie categorie) {

		this.daoCategorie.save(categorie);
		return categorie;
	}
	
}
