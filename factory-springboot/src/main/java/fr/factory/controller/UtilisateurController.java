package fr.factory.controller; 
 
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.factory.dao.IDAOLieu;
import fr.factory.dao.IDAOUtilisateur;
import fr.factory.model.Lieu;
import fr.factory.model.Utilisateur; 
 
 
 
@Controller 
@RequestMapping("") 
public class UtilisateurController { 
	 
	@Autowired 
	private IDAOUtilisateur daoUtilisateur; 
	 
	@Autowired
	private IDAOLieu daoLieu; 
	 
 
	@GetMapping("/listeUtilisateurs") 
	public String formulaireAjout(Model model) { 
		List <Utilisateur> mesUtilisateurs = daoUtilisateur.findAll(); 
		model.addAttribute("mesUtilisateurs", mesUtilisateurs); 
		return "admin" ; 
	} 
	 
	@PostMapping("/ajoutUtilisateur") 
	public String ajouterUtilisateur( 
			@ModelAttribute Utilisateur utilisateur, @ModelAttribute Lieu lieu, BindingResult result, Model model) {  
		lieu.setUtilisateur(utilisateur);
		utilisateur.setLieu(lieu);
		utilisateur.setAdmin(false);
		daoUtilisateur.save(utilisateur); 
		daoLieu.save(lieu);
		 
		return "redirect:./listeUtilisateurs"; 
	} 
	 
 
	@GetMapping("/supprimer/{id}") 
	public String supprimerUtilisateur(@PathVariable(value="id", required=false) int id, Model model) { 
		 
		daoUtilisateur.deleteById(id); 
		 
		return "redirect:../listeUtilisateurs"; 
	} 
	 
 
	@GetMapping("/editer/{id}") 
	public String editerUtilisateur(@PathVariable(value="id", required=false) int id, Model model) { 
		model.addAttribute("utilisateur", daoUtilisateur.findById(id).get()); 
		Utilisateur utilisateur = daoUtilisateur.findById(id).get();
		Optional<Lieu> lieu = daoLieu.findById(utilisateur.getLieu().getId()); 
		model.addAttribute("lieu", lieu); 
		return "editer"; 
	} 
	 
 
	@PostMapping("/editer/{id}") 
	public String modifierUtilisateur(@PathVariable(value="id", required=false) int id, @ModelAttribute Utilisateur utilisateur) { 
		daoUtilisateur.save(utilisateur); 
		return "redirect:../listeUtilisateurs"; 
	 
	} 
} 
