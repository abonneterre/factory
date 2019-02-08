import { Component, OnInit } from '@angular/core';
import { PropositionService } from '../proposition.service';
import { Proposition } from './proposition';
import { CategorieService } from '../categorie.service';


@Component({
  selector: 'app-proposition',
  templateUrl: './proposition.component.html',
  styleUrls: ['./proposition.component.css'],
  providers: [CategorieService]
})
export class PropositionComponent implements OnInit {

  private proposition: Proposition = new Proposition();

  constructor(public propositionService: PropositionService, public categorieService: CategorieService ) { }

  ngOnInit() {
  }

  ajouterProposition(){

    this.proposition.archivee = false;

    // this.reservation.activite.id = 1;
    this.propositionService.save(this.proposition);
    this.proposition = new Proposition();
  }

}
