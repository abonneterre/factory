import { Component, OnInit } from '@angular/core';
import { CategorieService } from '../categorie.service';




@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css'],
  providers: [CategorieService]
})
export class AccueilComponent implements OnInit {

  constructor(public categorieService: CategorieService) { }

  ngOnInit() {
  }

}
