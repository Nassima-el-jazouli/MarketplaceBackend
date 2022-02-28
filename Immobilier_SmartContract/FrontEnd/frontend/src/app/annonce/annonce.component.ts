import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AnnounceService } from '../_services/announce.service';
import { Announce } from '../models/announce';

@Component({
  selector: 'app-annonce',
  templateUrl: './annonce.component.html',
  styleUrls: ['./annonce.component.css']
})
export class AnnonceComponent implements OnInit {


   announce: Announce ;
  constructor(      private route: ActivatedRoute,
                    private router: Router,
                    private announceService: AnnounceService) {

               this.announce = new Announce();
               }


  ngOnInit(): void {
  }

  onSubmit() {
       console.log("*************** ca marche ******************");
      this.announceService.saveAnnounce(this.announce).subscribe(result => this.gotoAnnounceList());
      console.log(this.announce.title);

    }

    gotoAnnounceList() {
      console.log("*************** /announces-list LINK ******************");
      this.router.navigate(['/announces-list']);
      //this.router.navigate(['/explore']);
    }

}
