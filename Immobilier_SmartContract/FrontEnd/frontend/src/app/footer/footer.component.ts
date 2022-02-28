import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../_services/token-storage.service';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  private roles: string[] = [];
  isLoggedIn = false;
  RoleUser = false;
  username?: string;
  constructor(private tokenStorageService: TokenStorageService) { }

  ngOnInit(): void {
    this.isLoggedIn = !!this.tokenStorageService.getToken();

    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;

      this.RoleUser = this.roles.includes('ROLE_USER');
      this.username = user.username;
    }
  }

  logout(): void {
    this.tokenStorageService.signOut();
  }

}
