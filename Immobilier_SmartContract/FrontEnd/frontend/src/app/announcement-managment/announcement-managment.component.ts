import { Component, OnInit } from '@angular/core';
import { ContractService } from '../_services/contract.service';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AnnounceService } from '../_services/announce.service';
import { Announce } from '../models/announce';


@Component({
  selector: 'app-announcement-managment',
  templateUrl: './announcement-managment.component.html',
  styleUrls: ['./announcement-managment.component.css']
})
export class AnnouncementManagmentComponent implements OnInit {

  num=0;
    NombreOfHouses=0;
    House={ ownerAddress:"H",
            location:"A",
            cost:0,
            HouseID:"J"
            }

    requests: Announce[] ;
    //HouseTitle: String;

    constructor(    private announceService:AnnounceService,
                    private contractService:ContractService,
                    private route: ActivatedRoute,
                    private router: Router,) {
    this.requests=[];
    //this.HouseTitle="";
    }

    ngOnInit() {
     this.announceService.AnnouncesNotValidate().subscribe(result=> {
              this.requests = result;
            });
    }

    validation(HouseTitle: String,ownerAddress:String){

      console.log("************ 1 ***********"+ownerAddress);
      this.announceService.validate(HouseTitle).subscribe(result => this.refresh());
      console.log("************ 2 ***********"+HouseTitle);
      this.contractService.AddHouseToEthereum(ownerAddress,HouseTitle).subscribe(result => {

      console.log("oooooh")
      });

    }

    reject(HouseTitle: String){

          this.announceService.reject(HouseTitle).subscribe(result => this.refresh());
          console.log("************ 2 ***********"+HouseTitle);
        }

    refresh() {
          console.log("*************** /announces-list LINK ******************");
         // this.router.navigate(['/announces-list']);
          //this.router.navigate(['/explore']);
          window.location.reload();
    }
}
