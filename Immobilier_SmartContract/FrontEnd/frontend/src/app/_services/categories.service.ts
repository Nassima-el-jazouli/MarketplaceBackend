import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from '../category/category';

const baseUrl = 'http://localhost:9191/annonces/categories/ ';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};


@Injectable({
  providedIn: 'root'
})
export class CategoriesService {

  constructor(private http: HttpClient) {
   }

  getCategory(id: String): Observable<any> {
    return this.http.get(baseUrl + id);
  }

  createCategory(category: Category): Observable<Object> {
    return this.http.post(baseUrl+'create', category, httpOptions);
  }

  updateCategory(id: String, name: String): Observable<Object> {
    return this.http.put(baseUrl + id, name, httpOptions);
  }

  deleteCategory(id: String): Observable<any> {
    return this.http.delete(baseUrl + id, { responseType: 'text' });
  }

  getCategoryList(): Observable<any> {
    return this.http.get(baseUrl, httpOptions);
  }
}

