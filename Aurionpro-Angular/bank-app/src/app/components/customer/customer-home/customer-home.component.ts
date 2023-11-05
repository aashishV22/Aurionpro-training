import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CustomerService } from 'src/app/customer.service';
import { ICustomer } from 'src/app/models/icustomer';

@Component({
  selector: 'app-customer-home',
  templateUrl: './customer-home.component.html',
  styleUrls: ['./customer-home.component.css']
})
export class CustomerHomeComponent {
  public customer: ICustomer={} as ICustomer;
  public customerId: string | null = null;
  public loading: boolean = false;
  public errorMessage: string | null = null;

  constructor(
    private activatedRoute: ActivatedRoute,
    private customerService: CustomerService,
  ) {}
  ngOnInit(): void 
  {
    this.activatedRoute.paramMap.subscribe((param) => {
      this.customerId = param.get('userId');
      console.log(this.customerId)
      if (this.customerId != null) 
      {
        this.loading = true;
        this.customerService.getCustomerById(this.customerId).subscribe((data) => 
        {
          this.customer = data;
        },(err)=>
        {
          this.errorMessage=err+" : Could not fetch data";
          this.loading = false;
        });
      }
    });

  }



}
