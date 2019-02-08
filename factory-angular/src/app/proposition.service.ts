import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Proposition } from './proposition/proposition';

@Injectable({
  providedIn: 'root'
})
export class PropositionService {


  constructor(private httpClient: HttpClient) { }

  save(proposition:Proposition){
    this.httpClient
        .post("http://localhost:8080/api/proposition", proposition)
        .subscribe();
      }


}
