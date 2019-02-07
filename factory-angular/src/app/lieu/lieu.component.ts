import { Component, OnInit } from '@angular/core';
import { LieuService } from '../lieu.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-lieu',
  templateUrl: './lieu.component.html',
  styleUrls: ['./lieu.component.css']
})
export class LieuComponent implements OnInit {
  private id: number = 0;

  constructor(private route: ActivatedRoute, private lieuService: LieuService) {
  this.route.params.subscribe(params => {
    this.id = params.id;
    this.lieuService.findById(params.id);
  });
}
  ngOnInit() {
  }

}
