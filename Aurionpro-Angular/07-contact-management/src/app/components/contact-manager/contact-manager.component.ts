import { Component, OnInit } from '@angular/core';

import { IContact } from 'src/app/models/icontact';

import { ContactService } from 'src/app/services/contact.service';

 

@Component({

  selector: 'app-contact-manager',

  templateUrl: './contact-manager.component.html',

  styleUrls: ['./contact-manager.component.css'],

})

export class ContactManagerComponent implements OnInit {

  public contacts: IContact[] = [] as IContact[];

  public loading: boolean = false;

  public errorMessage: string | null = null;

  public filteredContacts: IContact[] = [];

 

  constructor(private contactService: ContactService) {}

 

  ngOnInit(): void {

    this.loadDataFromService();

  }

 

  loadDataFromService() {

    this.loading = true;

    this.contactService.getContacts().subscribe(

      (data) => {

        this.contacts = data;

        this.filteredContacts = this.contacts;

        this.loading = false;

      },

      (err) => {

        this.errorMessage = err;

        this.loading = false;

      }

    );

   

  }

 

  onDelete(id?: string) {

    if (id) {

      this.contactService.deleteContact(id).subscribe((data) => {

        this.loadDataFromService();

      });

    }

  }

 

  onSearchContact(searchName:string)
  {

    if (!searchName) {

      this.filteredContacts = this.contacts;

    }

 

    this.filteredContacts = this.contacts.filter(

      // contact => contact?.name.toLowerCase().includes(searchName.toLowerCase())

      contact => JSON.stringify(contact).toLowerCase().includes(searchName.toLowerCase())

    );

  }

}

 