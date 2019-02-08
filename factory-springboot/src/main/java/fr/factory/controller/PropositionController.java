package fr.factory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.factory.dao.IDAOProposition;
import fr.factory.model.Proposition;

@Controller
public class PropositionController {
	
	@Autowired
	private IDAOProposition daoProposition;

	@GetMapping("/propositions")
	public String boiteIdees(Model model) {
	List <Proposition> mesPropositions = daoProposition.findAll();
	model.addAttribute("mesPropositions", mesPropositions); 
	return "propositions";
	}
}
