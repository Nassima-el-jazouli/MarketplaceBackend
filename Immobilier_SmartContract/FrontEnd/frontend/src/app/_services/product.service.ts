import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const baseUrl = 'http://localhost:9191/annonces/products/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class ProductService {
  name?: String;
  price?: number;
  address?: String;
  image?: String;
  description?: String;
  validation= false;
  vendu = false;

  constructor(private http: HttpClient) { }

  getProduct(id: String): Observable<any> {
    return this.http.get(baseUrl + id);
  }

  createProduct(name: String, price: number, address: String, image: String, description: String): Observable<Object> {
    return this.http.post(baseUrl, {
      name,
      price,
      address,
      image,
      description
    }, httpOptions);
  }

  updateProduct(id: String, name: String, price: number, address: String, image: String, description: String): Observable<Object> {
    return this.http.put(baseUrl + id, {
      name,
      price,
      address,
      image,
      description
    }, httpOptions);
  }

  deleteProduct(id: String): Observable<any> {
    return this.http.delete(baseUrl + id, { responseType: 'text' });
  }

  getProductList(): Observable<any> {
    return this.http.get(baseUrl, httpOptions);
  }
}
