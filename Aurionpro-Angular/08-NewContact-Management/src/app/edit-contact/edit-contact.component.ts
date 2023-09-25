import { Component } from '@angular/core';
import { Icontact } from '../models/icontact';
import { Igroup } from '../models/igroup';
import { ContactService } from '../services/contact-service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-edit-contact',
  templateUrl: './edit-contact.component.html',
  styleUrls: ['./edit-contact.component.css']
})
export class EditContactComponent {
  public contactId: string | null = null;
  public contact:Icontact={} as Icontact;
  public groups:Igroup[]=[] ;
  public loading:boolean=false;
  public errorMessage: string | null = null;


  constructor(private contactService:ContactService, private activatedRoute:ActivatedRoute, private router:Router ){}
  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((param)=>{
      this.contactId=param.get('contactss');
      if(this.contactId!=null){
        this.loading=true;
        this.contactService.getContact(this.contactId).subscribe((data)=>{
          this.contact=data;
          this.contactService.getGroups().subscribe((data)=>{
            this.groups=data;
            this.loading=false;
          })
          
        },(err)=>{

          this.errorMessage=err+" : Could not fetch data";

          this.loading = false;
        })

      }
    })

  }

  onSubmit(){
    if(this.contactId){
      this.contactService.updateContact(this.contactId,this.contact).subscribe((data)=>{
        this.router.navigate(['/']).then();
      })
    }
  }


}
