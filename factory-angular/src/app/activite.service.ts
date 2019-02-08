import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Activite } from './activites/activite';
import { Categorie } from './activites/categorie';

@Injectable({
  providedIn: 'root'
})
export class ActiviteService {
  public activites: any = null;

  constructor(private httpClient: HttpClient) { }


 findAllAsync() {
    if (this.activites == null) {
this.activites =  this.httpClient.get("http://localhost:8080/api/activite");
}

  return this.activites;


}

findByActiveeAsync() {
   if (this.activites == null) {
this.activites =  this.httpClient.get("http://localhost:8080/api/activite/activee");
}

 return this.activites;


}

     refresh() {
       this.activites = null;
     }
}
