import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LieuService {
    public lieu: any = null;

  constructor(private httpClient: HttpClient) { }

  findAllAsync() {
     if (this.lieu == null) {
  this.lieu =  this.httpClient.get("http://localhost:8080/api/lieu");
  }
   return this.lieu;
  }

  refresh() {
      this.lieu = null;
      }

}
