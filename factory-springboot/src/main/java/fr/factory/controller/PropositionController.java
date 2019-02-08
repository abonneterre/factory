package fr.factory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fr.factory.dao.IDAOProposition;
import fr.factory.model.Proposition;
import fr.factory.security.annotation.isAdmin;

@Controller
@isAdmin
public class PropositionController {
	
	@Autowired
	private IDAOProposition daoProposition;

	@GetMapping("/propositions")
	public String boiteIdees(Model model) {
	List <Proposition> mesPropositions = daoProposition.findAll();
	model.addAttribute("mesPropositions", mesPropositions); 
	return "propositions";
	}
	
	@GetMapping("/archiver/{id}")
	public String archiver(@PathVariable int id) {
		Proposition proposition= daoProposition.findById(id).get();
		proposition.setArchivee(true);
		daoProposition.save(proposition);
		return "redirect:/propositions";
		
	}
}
