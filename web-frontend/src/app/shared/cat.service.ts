import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { CatModel } from './cat.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CatService {
  private static ENDPOINT = environment.backend_path + '/cats';

  constructor(
    private http: HttpClient
  ) { }

  getAllCats(): Observable<CatModel[]> {
    return this.http.get<CatModel[]>(CatService.ENDPOINT);
  }

  createCat(cat: CatModel): Observable<void> {
    return this.http.post<void>(CatService.ENDPOINT, cat);
  }
}
