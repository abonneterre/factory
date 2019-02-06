package fr.factory.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/api/categorie")
//	@JsonView(Views.Categorie.class)
	public List<Categorie> listeCategorie() {
			return this.daoCategorie.findAll();
	}
	

	
}
