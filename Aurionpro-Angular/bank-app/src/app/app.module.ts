import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { UserLoginComponent } from './components/user-login/user-login.component';
import { AdminHomeComponent } from './components/admin/admin-home/admin-home.component';
import { CustomerHomeComponent } from './components/customer/customer-home/customer-home.component';
import { CustomerNavbarComponent } from './components/customer/customer-navbar/customer-navbar.component';

@NgModule({
  declarations: [
    AppComponent,
    UserLoginComponent,
    CustomerHomeComponent,
    UserLoginComponent,
    AdminHomeComponent,
    CustomerNavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CommonModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
