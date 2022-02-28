import { Component, OnInit } from '@angular/core';
import { AnnounceService } from '../_services/announce.service';
import { Announce } from '../models/announce';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-announces-list',
  templateUrl: './announces-list.component.html',
  styleUrls: ['./announces-list.component.css']
})
export class AnnouncesListComponent implements OnInit {

announces: Announce[] ;
announces2: Announce[] ;
UserId:String ="sa";


  constructor(private announceService: AnnounceService,
              private route: ActivatedRoute,
              private router: Router) {

              this.announces=[];
              this.announces2=[];

              }

  ngOnInit(): void {

     this.announceService.findAllAnnounces().subscribe(result=> {
          this.announces = result;
          console.log("************ fffffff ....***********"+this.announces[1].isValidate);

        });

     this.getUserId();

    // this.consulterAnnounceById();


  }

  AddToPublication(title:String){

  console.log("************ publication ....***********");
      this.announceService.Publish(title).subscribe(result => this.refresh());
  }

  RemovePublication(title:String){

      console.log("************ publication ....***********");
          this.announceService.RemovePublication(title).subscribe(result => this.refresh());
      }

  consulterAnnounceById() {

        this.announceService.consulterAnnounceById().subscribe(result=> {
             this.announces2 = result;
             console.log("************ fffffff ....***********"+this.announces[1].isValidate);

           });
     }

  getUserId() {

      this.announceService.getUserId().subscribe(result=> {
           this.UserId = result;
           console.log("************ bbbbbbbbbb user id  ....***********"+this.UserId);

         });

                   console.log("************sssssss user id  ....***********");

   }

    refresh() {
             console.log("*************** /announces-list LINK ******************");
            // this.router.navigate(['/announces-list']);
             //this.router.navigate(['/explore']);
             window.location.reload();
       }

     gotoExploreList() {
              console.log("*************** publication redirection ******************");
              //this.router.navigate(['/announces-list']);
              this.router.navigate(['/explore']);
        }

}

