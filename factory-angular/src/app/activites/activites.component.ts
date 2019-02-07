import { Component, OnInit } from '@angular/core';
import { CategorieService } from '../categorie.service';

@Component({
  selector: 'app-activites',
  templateUrl: './activites.component.html',
  styleUrls: ['./activites.component.css']
})
export class ActivitesComponent implements OnInit {

  constructor(public categorieService: CategorieService) { }

  ngOnInit() {
  }

}
