import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
//import { Admins } from '../admins/admins.module';
import { Admins  } from '../models/admins';
const AUTH_API = 'http://localhost:9191/api/auth/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

export class user {
  constructor(
    public id: string,
    public username: string,
    public email: string
     ) {

  }
}

@Injectable({
  providedIn: 'root'
})


export class AuthService {

  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<any> {
    return this.http.post(AUTH_API + 'signin', {
      username,
      password
    }, httpOptions);
  }

  register(username: string, email: string, password: string): Observable<any> {
    return this.http.post(AUTH_API + 'signup', {
      username,
      email,
      password
    }, httpOptions);
  }

  registerAdmin(username: string, email: string, password: string): Observable<any> {
    return this.http.post(AUTH_API + 'Signup', {
      username,
      email,
      password
    }, httpOptions);
  }

  getAllAdmins(): Observable<Admins[]> {
    return this.http.get<Admins[]>(AUTH_API + 'admins', httpOptions);
  }


  deleteUser(id: string): Observable<any> {
    return this.http.post(AUTH_API + 'delete/' + id, httpOptions);
  }

  updateUser(admins: Admins) {
    return this.http.post(AUTH_API + 'user', admins, httpOptions);
  }

  getUserById(id: String) {
    return this.http.get(AUTH_API + 'user/' + id, httpOptions);
  }

}
