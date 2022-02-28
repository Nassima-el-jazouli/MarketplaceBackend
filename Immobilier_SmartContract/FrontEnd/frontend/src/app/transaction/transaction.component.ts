import { Component, OnInit } from '@angular/core';
import { ContractService } from '../_services/contract.service';
import { Transaction } from '../models/transaction';



@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.css']
})
export class TransactionComponent implements OnInit {

transactions:Transaction[]=[];

  constructor(private contractService:ContractService) { }

  ngOnInit(): void {
    this.getTransactions();
  }

  getTransactions(){
      this.contractService.transactions().subscribe(result =>

         this.transactions = result);
}
}

