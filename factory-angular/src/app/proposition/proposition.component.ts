import { Component, OnInit } from '@angular/core';
import { PropositionService } from '../proposition.service';
import { Proposition } from './proposition';

@Component({
  selector: 'app-proposition',
  templateUrl: './proposition.component.html',
  styleUrls: ['./proposition.component.css']
})
export class PropositionComponent implements OnInit {

  private proposition: Proposition = new Proposition();

  constructor(public propositionService: PropositionService) { }

  ngOnInit() {
  }

  ajouterProposition(){

    // this.reservation.activite.id = 1;
    this.propositionService.save(this.proposition);
  }

}
