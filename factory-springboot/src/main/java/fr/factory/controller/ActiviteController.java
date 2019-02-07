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

import fr.factory.dao.IDAOActivite;
import fr.factory.dao.IDAOCategorie;
import fr.factory.model.Activite;
import fr.factory.model.Categorie;
import fr.factory.model.Niveau;

//**********************************************************//
//	PENSER A METTRE A JOUR LES LIENS URL SELON LE BESOIN	//
//**********************************************************//

@Controller
@RequestMapping("/activite")
public class ActiviteController {
	
	@Autowired
	private IDAOActivite daoActivite;
	
	@Autowired
	private IDAOCategorie daoCategorie;
	
	private Niveau monNiveau;
	
	
//Lister des activités
	@GetMapping("")
	public String listeActivite(@ModelAttribute Activite activite, Model model) {
		
		List<Activite> mesActivites = daoActivite.findAll();
		model.addAttribute("mesActivites", mesActivites);
		return "listeActivites";
	}
	
//Ajouter une activité
	@GetMapping({ "/ajouterActivite" })
	public String ajouterActivite(@ModelAttribute Categorie Categorie , Niveau niveau, Model model) {
		
		Niveau[] mesNiveaux = Niveau.values();
		List<Categorie> mesCategories = daoCategorie.findAll();
		model.addAttribute("mesCategories", mesCategories);
		model.addAttribute("mesNiveaux", mesNiveaux);
		return "formActivite"; 
	}
	
	@PostMapping("/ajouterActivite")
	public String ajouterActivite1(@ModelAttribute Activite activite, Model model) {
		daoActivite.save(activite);
		return "redirect:.";
	}

	
//Editer une activité
	@GetMapping("/editer/{id}")
	public String editerActivite(@PathVariable int id, Model model) {
		model.addAttribute("activite", daoActivite.findById(id).get());
		return "formActivite"; //formulaire html de création/édition d'activités (mettre à jour si besoin)
	}
	
	@PostMapping("/editer/{id}")
	public String editerActivite(@ModelAttribute Activite activite, @PathVariable int id) {
		daoActivite.save(activite);
		return "redirect:..";
	}
	
//Supprimer une activité
	@GetMapping("/supprimer/{id}")
	public String supprimerActivite(@PathVariable int id) {
		daoActivite.deleteById(id);
		return "redirect:../";
	}
	
//masquer une activité
	@GetMapping("/masquer/{id}")
	public String masquerActivite(@PathVariable Integer id) {
		Activite monActivite = daoActivite.findById(id).get();
		monActivite.setActivee(false);
		daoActivite.save(monActivite);
		return"redirect:../";
	}
	
//afficher une activité
	@GetMapping("/afficher/{id}")
	public String afficherActivite(@PathVariable Integer id) {
		Activite monActivite = daoActivite.findById(id).get();
		monActivite.setActivee(true);
		daoActivite.save(monActivite);
		return"redirect:../";
	}
}
