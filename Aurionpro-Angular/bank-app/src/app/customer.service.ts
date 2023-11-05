import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ICustomer  } from './models/icustomer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  
  private getCustomersUrl = 'http://localhost:8080/app/users';
  private getCustomerByIdUrl='http://localhost:8080/app/customers/userid/';

  constructor(private http: HttpClient) { }

  getAllCustomers(): Observable<ICustomer[]> 
  {
    return this.http.get<ICustomer[]>(this.getCustomersUrl);
  }

  getCustomerById(customersUserId:string):Observable<ICustomer>{
    let dataUrl = `${this.getCustomerByIdUrl}${customersUserId}`;
    return this.http.get<ICustomer>(dataUrl);
  }


}
