import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Icontact } from '../models/icontact';
import { Igroup } from '../models/igroup';
import { ContactService } from '../services/contact-service';

@Component({
  selector: 'app-add-contact',
  templateUrl: './add-contact.component.html',
  styleUrls: ['./add-contact.component.css']
})
export class AddContactComponent implements OnInit{
  public contact:Icontact={} as Icontact;
  public groups:Igroup[]=[] ;
  constructor(private contactServices:ContactService,private router:Router){}

  ngOnInit(): void {
    this.contactServices.getGroups().subscribe((data)=>{
      this.groups=data;
    });
  }

  onSubmit(){
    this.contactServices.addContact(this.contact).subscribe(()=>{
      this.router.navigate(['/']).then();
    })
  }

}
