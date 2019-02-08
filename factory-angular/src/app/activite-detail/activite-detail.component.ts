import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ActiviteService } from '../activite.service';

@Component({
  selector: 'app-activite-detail',
  templateUrl: './activite-detail.component.html',
  styleUrls: ['./activite-detail.component.css']
})
export class ActiviteDetailComponent implements OnInit {

  private id: number = 0 ;

  constructor(private route: ActivatedRoute, private activiteService : ActiviteService) {

  this.route.params.subscribe(params => {
      this.activiteService.findById(params.id);
    });
   }

  ngOnInit() {
  }

}
