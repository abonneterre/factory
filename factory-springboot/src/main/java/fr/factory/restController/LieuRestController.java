package fr.factory.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.factory.dao.IDAOLieu;
import fr.factory.model.Lieu;

@RestController
@CrossOrigin("*") 
public class LieuRestController {
	
	@Autowired
	private IDAOLieu daoLieu;
	
	@GetMapping("/api/lieu")
	public List<Lieu> listeLieu() {
			return this.daoLieu.findAll();
	}
	

}
