package fr.factory.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.factory.dao.IDAOReservation;
import fr.factory.model.Reservation;

public class ReservationController {
	@Autowired
	private IDAOReservation daoReservation;
	
	@RequestMapping(value="/reservation", method=RequestMethod.GET)
	public String reservation(Model model, 
			 @RequestParam(value="id", required=false) Integer id) {
		if(id!=null) {
			Reservation resa = daoReservation.findById(id).get();
			model.addAttribute("reservation", resa);
		}
		model.addAttribute("reservations", daoReservation.findAll());
		return "reservation";
	}
	
	@PostMapping("/reservation")
	public String addReservation(@Valid @ModelAttribute Reservation reservation, BindingResult result,
			Model model) {
		//model.addAttribute("reservations", daoReservation.findAll());
		if(result.hasErrors()) {
			System.out.println("Invalide");
			return "reservation";
		}
		else {
			System.out.println("Ok");
			daoReservation.save(reservation);
			model.addAttribute("reservations", daoReservation.findAll());
		    return "reservation";
		}
		
	}
	
	@GetMapping("/supprimer")
	public String deleteReservation(@RequestParam(value="id", required=false, defaultValue="0") Integer idReservation, 
			Model model) {
		daoReservation.deleteById(idReservation);
		return "redirect:/reservation"; // peut utiliser ./ si mapping d�finit en haut
	}


//	@PostMapping("/reservation/editer")
//	public String editProduit(@RequestParam int id, @Valid @ModelAttribute Reservation reservation) {		
//		reservation.setId(id);
//		daoReservation.save(reservation);
//		return "redirect:/reservation";
//	}


}
