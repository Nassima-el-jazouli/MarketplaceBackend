import { Component, OnInit } from '@angular/core';
import { AnnounceService } from '../_services/announce.service';
import { ContractService } from '../_services/contract.service';
import { ActivatedRoute, Router } from '@angular/router';


import { Announce } from '../models/announce';



@Component({
  selector: 'app-explore',
  templateUrl: './explore.component.html',
  styleUrls: ['./explore.component.css']
})
export class ExploreComponent implements OnInit {

announces: Announce[] ;
UserId:String="";

  constructor(private announceService:AnnounceService,
              private contractService:ContractService,
              private route: ActivatedRoute,
              private router: Router) { this.announces=[]}

  ngOnInit(): void {


this.announceService.AnnouncesTrueValidatePublished().subscribe(result=> {
            this.announces = result;
          });

//this.getUserId();
}


/*  getUserId() {

      this.announceService.getUserId().subscribe(result=> {
           this.UserId = result;
           console.log("************ bbbbbbbbbb user id  ....***********"+this.UserId);

         });

                   console.log("************sssssss user id  ....***********");
 } */

TransferHouse(ownerAddress:String,cost:number,title:String) {
      this.contractService.TransferHouse(ownerAddress,cost,title).subscribe(result=>this.refresh());
 }

RemovePublication(title:String){

      console.log("************ publication ....***********");
          this.announceService.RemovePublication(title).subscribe(result => this.refresh());
      }

      gotoExploreList() {
                console.log("*************** publication redirection ******************");
                //this.router.navigate(['/announces-list']);
                this.router.navigate(['/explore']);
      }

      refresh() {
           console.log("*************** /announces-list LINK ******************");
          // this.router.navigate(['/announces-list']);
           //this.router.navigate(['/explore']);
           window.location.reload();
      }


}














  /* console.log("salam*****************************");
        this.contractService.hello().subscribe(res => {
          this.num = res;
        });

        this.contractService.getNombreOfHouses().subscribe(res => {
                this.NombreOfHouses = res;
              });

         this.contractService.getHouse().subscribe(res => {
                      this.House.ownerAddress = res.ownerAddress;
                      this.House.location = res.location;
                      this.House.cost = res.cost;
                      this.House.HouseID = res.HouseID;

                      console.log("data  "+res.location);

                    });


         console.log("location  "+this.House.location);
 */



