import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {


  constructor(private httpClient: HttpClient) { }

  save(reservation:Reservation){
    this.httpClient
        .post("http://localhost:8080/api/reservation",reservation)
        .subscribe();
      }


}
