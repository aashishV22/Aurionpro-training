import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserLoginComponent } from './components/user-login/user-login.component';
import { CustomerHomeComponent } from './components/customer/customer-home/customer-home.component';
import { AdminHomeComponent } from './components/admin/admin-home/admin-home.component';
import { CustomerNavbarComponent } from './components/customer/customer-navbar/customer-navbar.component';

const routes: Routes = [
  { path: 'user-login',            component: UserLoginComponent     },
  { path: 'admin-home/:userId',    component: AdminHomeComponent     },
  { path: 'customer-home/:userId', component: CustomerHomeComponent  },
  { path: 'accounts/:customerId',  component: CustomerNavbarComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
