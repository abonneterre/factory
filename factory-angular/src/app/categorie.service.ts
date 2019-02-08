import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


import { Activite } from '.activites/activite';
import { Categorie } from '.activites/categorie';

@Injectable({
  providedIn: 'root'
})
export class CategorieService {
  public categories: any = null;

  constructor(private httpClient: HttpClient) { }

  findAll() {
   this.httpClient
     .get("http://localhost:8080/api/categorie")
     .subscribe(resp => { console.log(resp); this.categories = resp });

 }

 findAllAsync() {
    if (this.categories == null) {
this.categories =  this.httpClient.get("http://localhost:8080/api/categorie");
}

  return this.categories;

}

findById(id: number) {

this.httpClient
    .get("http://localhost:8080/api/categorie/" + id )
      .subscribe(resp => this.categories = resp);
 }
 
     refresh() {
       this.categories = null;
     }
}
