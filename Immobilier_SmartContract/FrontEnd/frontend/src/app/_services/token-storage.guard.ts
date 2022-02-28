import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { TokenStorageService } from './token-storage.service';

@Injectable({
  providedIn: 'root'
})
export class TokenStorageGuard implements CanActivate {

  isLoggedIn = false;
  constructor(private tokenStrorage : TokenStorageService, private router : Router) {

  }
  canActivate(){
      this.isLoggedIn = !!this.tokenStrorage.getToken();

    if(this.isLoggedIn) {
      return true;
    }
    alert("You have not logged In")
    this.router.navigate(['/login']);
    return false;
  }

}
