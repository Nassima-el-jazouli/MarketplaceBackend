import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../_services/token-storage.service';
import { AuthService } from '../_services/auth.service';
//import { Admins } from '../admins/admins.module';
import { Admins  } from '../models/admins';


@Component({
  selector: 'app-admin-managment',
  templateUrl: './admin-managment.component.html',
  styleUrls: ['./admin-managment.component.css']
})
export class AdminManagmentComponent implements OnInit {

  private roles: string[] = [];
  isLoggedIn = false;
  showAdminBoard = false;
  showUserBoard = false;
  router: any;
  users!: Admins[];
  constructor(private authService: AuthService, private tokenStorageService: TokenStorageService) { }

  ngOnInit(): void {
    this.isLoggedIn = !!this.tokenStorageService.getToken();

    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;

      this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
      this.showUserBoard = this.roles.includes('ROLE_USER');
    }

  }

  deleteUser(id: string) {
    this.authService.deleteUser(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  reloadData() {
    window.location.reload();
  }

}
