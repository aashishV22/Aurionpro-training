import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContactManagerComponent } from './components/contact-manager/contact-manager.component';
import { AddContactComponent } from './components/add-contact/add-contact.component';
import { EditContactComponent } from './components/edit-contact/edit-contact.component';
import { ViewContactComponent } from './components/view-contact/view-contact.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { NewAddContactComponent } from "./components/new-add-contact/new-add-contact.component";

const routes: Routes = 
[
  {path:'',redirectTo:'contacts/admin',pathMatch:'full'},
  {path:'contacts/admin', component:ContactManagerComponent},
  {path:'contacts/add', component:AddContactComponent},
  {path:'contacts/edit/:contactId',component:EditContactComponent},
  {path:'contacts/view/:contactId',component:ViewContactComponent},
  {path:'**',component:PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
