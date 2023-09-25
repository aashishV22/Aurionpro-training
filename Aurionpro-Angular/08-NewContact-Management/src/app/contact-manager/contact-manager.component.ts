import { Component, OnInit } from '@angular/core';
import { Icontact } from 'src/app/models/icontact';

import { ContactService } from 'src/app/services/contact-service';

 
@Component({
  selector: 'app-contact-manager',
  templateUrl: './contact-manager.component.html',
  styleUrls: ['./contact-manager.component.css']
})
export class ContactManagerComponent implements OnInit{
  public contacts: Icontact[] = [] as Icontact[];
  public loading:boolean=false;
  public filteredContacts: Icontact[] = [];

  constructor(private contactServices:ContactService){}

  ngOnInit(): void 
  {
    this.loadDataFromService();
  }
  loadDataFromService() 
  {
    this.loading=true;
    this.contactServices.getContacts().subscribe
    (
      (data)=>
      {
        this.contacts=data;
        this.filteredContacts=this.contacts;
        this.loading=false;
      }      
    )
  }

  onDelete(id?:string){
    if(id)
    {
        this.contactServices.deleteContact(id).subscribe((data)=>{
      }); 
    }
  }
  
}
