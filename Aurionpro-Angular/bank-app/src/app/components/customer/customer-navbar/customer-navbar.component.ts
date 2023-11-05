import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { ICustomer } from 'src/app/models/icustomer';

@Component({
  selector: 'customer-navbar',
  templateUrl: './customer-navbar.component.html',
  styleUrls: ['./customer-navbar.component.css']
})
export class CustomerNavbarComponent{
  @Input() customer: ICustomer | undefined;

  constructor(private router: Router) { }

  logOut() {
    // Perform any necessary logout actions
    // For example, clear user authentication, session, or tokens
    // Then navigate to the user login page
    this.router.navigate(['/user-login']);
  }
}
