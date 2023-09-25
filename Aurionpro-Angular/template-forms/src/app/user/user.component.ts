import { Component, EventEmitter, Input, Output } from '@angular/core';
import { NgForm } from "@angular/forms";
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {
  mssg='';
  @Input() inputData:any;
  @Output() output=new EventEmitter<any>();
  details:any=[]
  onSubmit(form:NgForm){
    console.log(form);
    // this.checkValid(form);
      this.details.push({
        username: form.form.value.username,
        email: form.form.value.email,
      });
      this.output.emit(this.details);
    
  }

  // checkValid(form:NgForm):string{
  //   if(form.status=="INVALID"){
  //     this.mssg = "border-danger"
  //   }
  //   return this.mssg;
  // }
}
