import { Component, OnInit } from '@angular/core';
import { Icontact } from '../models/icontact';
import { ContactService } from '../services/contact-service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-view-contact',
  templateUrl: './view-contact.component.html',
  styleUrls: ['./view-contact.component.css']
})
export class ViewContactComponent implements OnInit 
{
  public contact:Icontact={} as Icontact;
  public contactId:string | null=null;
  public loading:boolean=false;
  public groupName:string | null=null;
  public errorMessage: string | null = null;

  constructor(private contactService:ContactService, private activatedRoute:ActivatedRoute ){}
  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((param)=>{
      this.contactId=param.get('contactss');
      if(this.contactId!=null){
        this.loading=true;
        this.contactService.getContact(this.contactId).subscribe((data)=>{
          this.contact=data;
          this.contactService.getGroupName(this.contact).subscribe((data)=>{
            this.groupName=data.name;
            this.loading=false;
          })
          
        },(err)=>{

          this.errorMessage=err+" : Could not fetch data";

          this.loading = false;
        })

      }
    })

  }


}
