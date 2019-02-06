package fr.factory.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loupgarou.dao.IDAOVillageois;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")

public class GerantController {
	@Autowired
	IDAOUtilisateur daoUtilisateur;
	
	@Autowired
	IDAOLieux daoLieux;
	
	
	
	
	
}
