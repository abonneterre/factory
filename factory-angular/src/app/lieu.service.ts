import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LieuService {
    public lieux: any = null;
    public lieu: Lieu = new Lieu();

  constructor(private httpClient: HttpClient) { }

  findAllAsync() {
     if (this.lieux == null) {
  this.lieux =  this.httpClient.get("http://localhost:8080/api/lieu");
  }
   return this.lieux;
  }

  findById(id:number){
    return this.httpClient
      .get<Lieu>("http://localhost:8080/api/lieu/" + id, this.httpOptions)
      .subscribe(resp => this.lieu=resp);
  }


  refresh() {
      this.lieux = null;
      }

}
