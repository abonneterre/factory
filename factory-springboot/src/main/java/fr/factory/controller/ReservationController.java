package fr.factory.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import fr.factory.dao.IDAOActivite;
import fr.factory.dao.IDAOReservation;
import fr.factory.model.Reservation;

@Controller
public class ReservationController {
	@Autowired
	private IDAOReservation daoReservation;
	
	@Autowired
	private IDAOActivite daoActivite;
	
	@RequestMapping(value="/reservation", method=RequestMethod.GET)
	public String reservation(Model model, @RequestParam(value="id", required=false) Integer id) {
		if(id!=null) {
			Reservation resa = daoReservation.findById(id).get();
			model.addAttribute("reservation", resa);
		}
		model.addAttribute("reservations", daoReservation.findAll());
		return "reservation";
	}
	
	@GetMapping("/ajouter")
	public String ajouterReservation(@Valid @ModelAttribute Reservation reservation, BindingResult result, 
			//@RequestParam(value="id", required=false) Integer id, 
			Model model) {
		model.addAttribute("activites", daoActivite.findAll());

		System.out.println(reservation.getDateReservation());
		return "resa-edit";
	}
	
	@PostMapping("/ajouter")
	public String addReservation(@Valid @ModelAttribute Reservation reservation, BindingResult result,
			Model model, @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateResa ) {
		//model.addAttribute("reservations", daoReservation.findAll());
		System.out.println(reservation.getDateReservation());
		reservation.setDateDemande(new Date());
		reservation.setDateReservation(dateResa);
		System.out.println(dateResa);
		
		if(result.hasErrors()) {
			System.out.println("Invalide");
			return "resa-edit";
		}
		else {
			System.out.println("Ok");
			daoReservation.save(reservation);
			model.addAttribute("reservations", daoReservation.findAll());
		    return "redirect:/reservation";
		}
		
	}
	
	@GetMapping("/editer")
	public String modifierPersonnage(@RequestParam int id, Model model) {
		model.addAttribute("activites", daoActivite.findById(daoReservation.findById(id).get().getActivite().getId()).get());
		model.addAttribute("reservation",daoReservation.findById(id).get());
		model.addAttribute("id", id);
		return "resa-edit";
	}
	
	@PostMapping("/editer")
	public String editerReservation(@RequestParam int id, @Valid @ModelAttribute Reservation reservation, @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateResa) {		
		reservation.setId(id);
		reservation.setDateDemande(new Date());
		reservation.setDateReservation(dateResa);
		daoReservation.save(reservation);
		return "redirect:/reservation";
	}
	
	@GetMapping("/supprimer")
	public String deleteReservation(@RequestParam(value="id", required=false, defaultValue="0") Integer idReservation, 
			Model model) {
		daoReservation.deleteById(idReservation);
		return "redirect:/reservation";
	}


//	@PostMapping("/reservation/editer")
//	public String editProduit(@RequestParam int id, @Valid @ModelAttribute Reservation reservation) {		
//		reservation.setId(id);
//		daoReservation.save(reservation);
//		return "redirect:/reservation";
//	}


}
