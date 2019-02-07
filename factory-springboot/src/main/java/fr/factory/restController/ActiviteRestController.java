package fr.factory.restController;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.factory.dao.IDAOActivite;
import fr.factory.model.Activite;
import fr.factory.projection.Views;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/activite")
public class ActiviteRestController {
	
	@Autowired
	private IDAOActivite daoActivite; 
	
	@GetMapping()
	@JsonView(Views.ActiviteWithCategorieAndReservationsAndLieu.class)
	public List<Activite> listeActivites() {
		List<Activite> act = daoActivite.findAll();
		return act;
		
	}
	
	

}
