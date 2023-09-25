import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { IContact } from 'src/app/models/icontact';
import { IGroup } from 'src/app/models/igroup';
import { ContactService } from 'src/app/services/contact.service';
import { v4 as uuid } from 'uuid';

@Component({
  selector: 'app-add-contact',
  templateUrl: './add-contact.component.html',
  styleUrls: ['./add-contact.component.css']
})
export class AddContactComponent {
  public contact: IContact = {} as IContact;
  public groups: IGroup[] = [];
  public id: string = uuid();

  constructor(private contactService: ContactService,private router:Router) {}
  ngOnInit(): void {
      this.contactService.getGroups().subscribe((data) => {
      this.groups = data;
    });
  }


  onSubmit() {
    // this.contact.id = this.id;
    // console.log(this.contact);
    this.contactService.addContacts(this.contact).subscribe((data)=>{
      this.router.navigate(['/']).then();
    })
  }
}
