import { Component, OnInit } from '@angular/core';
import { ReservationService } from '../reservation.service';
import { Reservation } from './reservation';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent implements OnInit {


  // private activite: Activite = new Activite();
  private reservation: Reservation = new Reservation();
  private reservations: Array<Reservation> = new Array<Reservation>();


  constructor(public reservationService: ReservationService) { }

  ngOnInit() {
  }


  ajouterReservation(){

//L'ACTIVITE EST POUR L'INSTANT RENSEIGNEE EN BRUT, IL FAUDRA LA RECUPERER SUR LA PAGE UNE FOIS LE SERVICE INTEGRE A LA PAGE (PATHVARIABLE OU REQUESTVARIBLE...)
this.reservation.activite  = {
  id: 2
};


this.reservation.dateDemande = Date.now();


    // this.reservation.activite.id = 1;
    this.reservationService.save(this.reservation);
  }

}
