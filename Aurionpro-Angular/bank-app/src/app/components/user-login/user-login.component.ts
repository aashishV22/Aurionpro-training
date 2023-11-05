import { Component, OnInit } from '@angular/core';
import { UserService } from '../../user.service';
import { IUser } from "../../models/iuser";
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {
  public userLogin: IUser = {
    userId: 0,
    userName: '',
    password: '',
    roleId: {
      roleId: 1, // Set a default roleId value (e.g., '1' for 'Admin')
      roleName: '' // Set a default roleName
    }
  };
  public users!: IUser[];

  constructor(private userService: UserService, private router: Router) {}

  ngOnInit() {
    this.userService.getUsers().subscribe((data: IUser[]) => {
      if (data) {
        this.users = data;
      }
    });
  }

  onSubmit() {
    this.userLogin.roleId.roleId = parseInt(this.userLogin.roleId.roleId.toString(), 10);
    const foundUser = this.userService.validateUser(this.userLogin, this.users);

    if (foundUser != null && this.userLogin.roleId.roleId === 1) {
      // User validation was successful, navigate to admin-home with user ID.
      this.router.navigate([`admin-home/${foundUser.userId}`]);
      console.log("admin logged in");
    } else if (foundUser != null && this.userLogin.roleId.roleId === 2) {
      // User validation was successful, navigate to customer-home with user ID.
      this.router.navigate([`customer-home/${foundUser.userId}`]);
      console.log("user logged in");
    } else {
      // Handle validation error, e.g., display an error message.
      console.log("password wrong");
    }
  }
}
