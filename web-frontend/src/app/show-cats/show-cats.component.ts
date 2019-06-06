import { Component, OnInit } from '@angular/core';
import { CatService } from '../shared/cat.service';
import { CatModel } from '../shared/cat.model';

@Component({
  selector: 'app-show-cats',
  templateUrl: './show-cats.component.html',
  styles: []
})
export class ShowCatsComponent implements OnInit {

  cats: CatModel[];

  constructor(
    private catService: CatService
  ) { }

  ngOnInit() {
    this.catService.getAllCats().subscribe(
      cats => this.cats = cats,
      err => console.error(err)
    );
  }

}
