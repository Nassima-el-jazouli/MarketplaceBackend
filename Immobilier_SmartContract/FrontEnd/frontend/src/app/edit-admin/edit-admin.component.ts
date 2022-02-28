import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
//import { Admins } from '../admins/admins.module';
import { Admins  } from '../models/admins';
import { AuthService } from '../_services/auth.service';

@Component({
  selector: 'app-edit-admin',
  templateUrl: './edit-admin.component.html',
  styleUrls: ['./edit-admin.component.css']
})
export class EditAdminComponent implements OnInit {

  form: any = {
    username: null,
    email: null,
    password: null
  };
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  user!: Admins;
  id!: any;

  constructor(private authService: AuthService, private router1: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.id = this.router1.snapshot.paramMap.get('id');
    this.authService.getUserById(this.id).subscribe(data=>{
      this.form = data;
    })
  }

  onSubmit(): void {

  }

  updateUser(f: any) {
    f.value['id']=this.id;
    this.authService.updateUser(f.value).subscribe(data=>{
    this.user = data;
    console.log(f.value);
    this.router.navigate(['/adminManagment']);
  });
  console.log(f.value)
}

reloadData() {
  window.location.reload();
}

}
