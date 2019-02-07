import { Component, OnInit } from '@angular/core';
import { ReservationService } from '../reservation.service';
import { Reservation } from './reservation';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent implements OnInit {

  private reservation: Reservation = new Reservation();
  private reservations: Array<Reservation> = new Array<Reservation>();


  constructor(public reservationService: ReservationService) { }

  ngOnInit() {
  }


  ajouterReservation(){
    this.reservation.activite.id = 1;
    this.reservationService.save(this.reservation);
  }

}
