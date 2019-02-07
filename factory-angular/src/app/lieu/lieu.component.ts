import { Component, OnInit } from '@angular/core';
import { LieuService } from '../lieu.service';

@Component({
  selector: 'app-lieu',
  templateUrl: './lieu.component.html',
  styleUrls: ['./lieu.component.css']
})
export class LieuComponent implements OnInit {

  constructor(private lieuService: LieuService) { }

  ngOnInit() {
  }

}
