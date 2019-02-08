import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class ActiviteService {
  public activites: any = null;
  public activite: any = null ;

  constructor(private httpClient: HttpClient) { }


 findAllAsync() {
    if (this.activites == null) {
this.activites =  this.httpClient.get("http://localhost:8080/api/activite");
}

  return this.activites;
}

findById(id : number){
  this.activite = this.httpClient.get("http://localhost:8080/api/activite/" + id).subscribe(resp =>
    this.activite = resp);
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
