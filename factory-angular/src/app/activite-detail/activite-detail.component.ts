import { Component, OnInit } from '@angular/core';
import { ActiviteService } from '../activite.service';

@Component({
  selector: 'app-activite-detail',
  templateUrl: './activite-detail.component.html',
  styleUrls: ['./activite-detail.component.css']
})
export class ActiviteDetailComponent implements OnInit {

  private id: number = 0 ;

  constructor(private activiteService : ActiviteService) {

  this.route.params.subscribe(params => {
      this.activiteService.findById(params.id);
    });
   }

  ngOnInit() {
  }

}
