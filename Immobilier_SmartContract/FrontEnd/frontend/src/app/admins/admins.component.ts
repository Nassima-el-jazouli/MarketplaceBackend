import { Component, OnInit, Input } from '@angular/core';
import { Route, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService, user } from '../_services/auth.service';
//import { Admins } from './admins.module';
import { Admins  } from '../models/admins';


@Component({
  selector: 'app-admins',
  templateUrl: './admins.component.html',
  styleUrls: ['./admins.component.css']
})

export class AdminsComponent implements OnInit {
  @Input() id?: string;
  @Input() username?: string;
  @Input() email?: string;
  users!: Admins[];
  user!: Admins;
  constructor(private authService : AuthService, private router : Router) { }

  ngOnInit() {
    console.log("this.user");
    this.authService.getAllAdmins().subscribe((data: Admins[])=>{
      this.users = data;
      console.log("this.user2");
    })
  }

  reloadData() {
    window.location.reload();
  }

  deleteUser(id: any) {
    this.authService.deleteUser(id)
      .subscribe(
        data => {
          console.log(data.message);
          this.reloadData();
        },
        error => console.log(error));
  }

  edit(id:any){
    this.router.navigate(['/editAdmin',id])
  }


}
