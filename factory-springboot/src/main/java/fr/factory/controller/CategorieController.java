package fr.factory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.factory.dao.IDAOCategorie;
import fr.factory.model.Categorie;

@Controller
@RequestMapping("/categorie")
public class CategorieController {
	
	@Autowired
	private IDAOCategorie daoCategorie;
	
	//Liste des catégories
	@GetMapping()
	public String listeCategorie( Model model) {
		List<Categorie> mesCategories = daoCategorie.findAll();
		model.addAttribute("listeCategorie", mesCategories);
		return "crudCategorie";
	}
	
	//Ajouter une catégorie
	@PostMapping()
	public String ajouterCategorie(@ModelAttribute Categorie categorie) {
		daoCategorie.save(categorie);
		return "redirect:/categorie";
	}
	
	//Editer une catégorie
	@GetMapping("/editer/{id}")
	public String editerCategorie(@PathVariable int id, Model model) {
		model.addAttribute("categorie", daoCategorie.findById(id).get());
		model.addAttribute("listeCategorie", daoCategorie.findAll());
		return "editerCategorie";
	}
	
	@PostMapping("/editer/{id}")
	public String editerCategorie(@ModelAttribute Categorie categorie) {
		daoCategorie.save(categorie);
		return "redirect:/categorie";
	}
	
	//Supprimer une catégorie
	@GetMapping("/supprimer/{id}")
	public String supprimerCategorie(@PathVariable int id) {
		daoCategorie.deleteById(id);
		return "redirect:/categorie";
	}
}
