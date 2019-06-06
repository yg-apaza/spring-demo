import { Component, OnInit } from '@angular/core';
import { CatService } from '../shared/cat.service';
import { CatModel } from '../shared/cat.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-cat',
  templateUrl: './add-cat.component.html',
  styles: []
})
export class AddCatComponent implements OnInit {

  newCat = new CatModel(0, '', 0, '');

  constructor(
    private catService: CatService,
    private router: Router
  ) { }

  ngOnInit() { }

  createCat() {
    this.catService.createCat(this.newCat).subscribe(
      () => {
        console.log('Cat succesfully created');
        this.router.navigate(['/']);
      },
      err => console.error(err)
    );
  }

}
