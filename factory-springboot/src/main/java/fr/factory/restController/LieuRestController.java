package fr.factory.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.factory.dao.IDAOLieu;
import fr.factory.model.Lieu;
import fr.factory.projection.Views;

@RestController
@CrossOrigin("*") 
public class LieuRestController {
	
	@Autowired
	private IDAOLieu daoLieu;
	
	@GetMapping("/api/lieu")
	@JsonView(Views.LieuWithUtilisateur.class)
	public List<Lieu> listeLieu() {
			return this.daoLieu.findAll();
	}
	
	@GetMapping("/api/lieu/{id}")
	@JsonView(Views.LieuWithUtilisateur.class)
	public Lieu lieuParId(@PathVariable int id) {
		return this.daoLieu.findById(id).get();
	}
	

}
