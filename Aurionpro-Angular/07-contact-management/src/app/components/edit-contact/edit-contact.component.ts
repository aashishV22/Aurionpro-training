
import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';

import { IContact } from 'src/app/models/icontact';

import { IGroup } from 'src/app/models/igroup';

import { ContactService } from 'src/app/services/contact.service';

import { ActivatedRoute } from '@angular/router';

 

@Component({

  selector: 'app-edit-contact',

  templateUrl: './edit-contact.component.html',

  styleUrls: ['./edit-contact.component.css'],

})

export class EditContactComponent {

  public contact: IContact = {} as IContact;

  public groups: IGroup[] = [] as IGroup[];

  public contactId: string | null = null;

  public loading: boolean = false;

  public errorMessage: string | null = null;

 

  constructor(

    private contactService: ContactService,

    private router: Router,

    private activatedRoute: ActivatedRoute

  ) {}

 

  ngOnInit(): void {

    this.contactService.getGroups().subscribe((data) => {

      this.groups = data;

    });

 

    this.activatedRoute.paramMap.subscribe((param) => {

      this.contactId = param.get('contactId');

      if (this.contactId != null) {

        this.loading = true;

        this.contactService.getContact(this.contactId).subscribe(

          (data) => {

            this.contact = data;

          },

          (err) => {

            this.errorMessage = err + ' : Could not fetch data';

            this.loading = false;

          }

        );

      }

    });

  }

 

  onSubmit() {

    if(this.contactId){

      this.contactService

      .updateContact(this.contactId, this.contact)

      .subscribe((data) => {

        this.router.navigate(['/']).then();

      });

    }
  }

}

 