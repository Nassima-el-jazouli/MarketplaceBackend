import { HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-contact-us',
  templateUrl: './contact-us.component.html',
  styleUrls: ['./contact-us.component.css']
})
export class ContactUsComponent implements OnInit {
  http: any;

  constructor() { }

  ngOnInit(): void {
  }

  // onSubmit(contactForm: NgForm) {
  //   if (contactForm.valid) {
  //     const email = contactForm.value;
  //     const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
  //     this.http.post('https://formspree.io/asdlf7asdf',
  //       { name: email.name, replyto: email.email, message: email.messages },
  //       { 'headers': headers }).subscribe(
  //         (          response: any) => {
  //           console.log(response);
  //         }
  //       );
  //   }
  // }
}
