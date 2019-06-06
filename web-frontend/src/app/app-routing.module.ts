import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ShowCatsComponent } from './show-cats/show-cats.component';
import { AddCatComponent } from './add-cat/add-cat.component';

const routes: Routes = [
  {
    path: '',
    component: ShowCatsComponent,
    pathMatch: 'full'
  },
  {
    path: 'add',
    component: AddCatComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
