import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { TokenStorageService } from './token-storage.service';
import {  Router } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class RoleGuard implements CanActivate {

  private roles: string[] = [];
  isLoggedIn = false;
  showAdminBoard = false;
  showUserBoard = false;
  username?: string;

  constructor(private tokenStorageService: TokenStorageService, private router : Router) {
  }
  canActivate() {

    this.isLoggedIn = !!this.tokenStorageService.getToken();
   if(this.isLoggedIn) {

    const user = this.tokenStorageService.getUser();
          this.roles = user.roles;

          this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
          this.showUserBoard = this.roles.includes('ROLE_USER');
          if (this.showAdminBoard) {
              return true;
          }
          if (this.showUserBoard) {
            alert("You don't have Admin guard");
            return false;
          }

    }
      alert("You have not logged In")
      this.router.navigate(['/login']);
      return false;
  }

}


    /* this.isLoggedIn = !!this.tokenStorageService.getToken();

    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;

      this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
      this.showUserBoard = this.roles.includes('ROLE_USER');
      if (this.showAdminBoard) {
          return true;
      }
      if (this.showUserBoard) {
        alert("You don't have Admin guard");
        return false;
    }
  }
  alert("You don't have Admin guard");
  return false;
  }

}*/
