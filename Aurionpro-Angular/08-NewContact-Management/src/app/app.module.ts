import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HttpClientModule } from "@angular/common/http";
import { ContactManagerComponent } from './contact-manager/contact-manager.component';
import { SpinnerComponent } from './spinner/spinner.component';
import { FormsModule } from '@angular/forms';
import { ViewContactComponent } from "./view-contact/view-contact.component";
import { AddContactComponent } from './add-contact/add-contact.component';
import { EditContactComponent } from './edit-contact/edit-contact.component';


@NgModule({
  declarations: [
    AppComponent,
    AddContactComponent,
    NavbarComponent,
    ContactManagerComponent,
    SpinnerComponent,
    ViewContactComponent,
    EditContactComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
