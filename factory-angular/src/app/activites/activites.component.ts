import { Component, OnInit } from '@angular/core';
import { CategorieService } from '../categorie.service';
import { ActiviteService } from '../activite.service';
import { ActivatedRoute } from '@angular/router';

import { Activite } from './activite';
import { Categorie } from './categorie';

@Component({
  selector: 'app-activites',
  templateUrl: './activites.component.html',
  styleUrls: ['./activites.component.css']
})
export class ActivitesComponent implements OnInit {

  private id: number=0;

  private activite: any;

  private categorie: any;

  constructor(public categorieService: CategorieService, public activiteService: ActiviteService,
  	private route: ActivatedRoute) {

  this.route.params.subscribe(params => {
     this.id = params.id;
     //this.categorie = this.categorieService.findById(id);
     this.categorieService.findById(this.id);
     });

  }

  ngOnInit() {
  }

}
