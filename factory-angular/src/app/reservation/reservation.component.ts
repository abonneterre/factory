import { Component, OnInit } from '@angular/core';
import { ReservationService } from '../categorie.service';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent implements OnInit {

  constructor(public reservationService: ReservationService) { }

  ngOnInit() {
  }

}
