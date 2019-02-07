import { Component, OnInit } from '@angular/core';
import { CategorieService } from '../categorie.service';

@Component({
  selector: 'categorie',
  templateUrl: './categorie.component.html',
  styleUrls: ['./categorie.component.css'],

})
export class CategorieComponent implements OnInit {

  constructor(public categorieService: CategorieService) { }

  ngOnInit() {
  }

}
