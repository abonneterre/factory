package fr.factory.controller; 
 
import java.util.List; 
 
import javax.validation.Valid; 
 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.security.access.prepost.PreAuthorize; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.validation.BindingResult; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestMapping; 
 
 
 
@Controller 
@RequestMapping("/") 
public class UtilisateurController { 
	 
	@Autowired 
	private IDAOUtilisateur daoUtilisateur; 
	 
	@Autowired 
	private IDAOLieu daoLieu; 
	 
 
	@GetMapping("/listeUtilisateurs") 
	public String formulaireAjout(Model model) { 
		List <Utilisateur> mesUtilisateurs = daoUtilisateur.findAll(); 
		model.addAttribute("mesUtilisateurs", mesUtilisateurs); 
		return "mesUtilisateurs" ; 
	} 
	 
	 
	 
 
	@PostMapping("/ajoutProduit") 
	public String ajouterProduit( 
			@Valid @ModelAttribute Produit produit, BindingResult result, Model model) { 
		if (result.hasErrors()) { 
			System.out.println("Erreur..."); 
			return "produit"; 
			} 
		daoProduit.save(produit); 
		 
		return "redirect:./liste"; 
	} 
	 
 
	 
 
	@GetMapping("/supprimer/{id}") 
	public String supprimerProduit(@PathVariable(value="id", required=false) int id, Model model) { 
		 
		daoProduit.deleteById(id); 
		 
		return "redirect:../liste"; 
	} 
	 
 
	@GetMapping("/editer/{id}") 
	public String editerProduit(@PathVariable(value="id", required=false) int id, Model model) { 
		model.addAttribute("produit", daoProduit.findById(id).get()); 
		List <Fournisseur> mesFournisseurs = daoFournisseur.findAll(); 
		model.addAttribute("mesFournisseurs", mesFournisseurs); 
		return "editer"; 
	} 
	 
 
	@PostMapping("/editer/{id}") 
	public String modifierProduit(@PathVariable(value="id", required=false) int id, @ModelAttribute Produit produit) { 
		daoProduit.save(produit); 
		return "redirect:../liste"; 
	 
	} 
} 
