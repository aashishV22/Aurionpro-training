import { Component } from '@angular/core';
import { FormGroup,FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = '06-reactive-form';
  genders:string[]=["Male","Female"];
  invalidUserNames=['admin','superUser']

  userForm!:FormGroup
  ngOnInit():void{
    this.userForm=new FormGroup({
      'username':new FormControl(null,[Validators.required,Validators.minLength(3),Validators.maxLength(8),this.invalidNames.bind(this),Validators.pattern(`^[a-zA-Z\s]*$`)]),
      'email':new FormControl(null,[Validators.required,Validators.email]),
      'number':new FormControl(null),
      'gender':new FormControl('Male'),
    })
  }

  onSubmit(){
    console.log(this.userForm);
  }
  onReset(){
    this.userForm.reset();
  }

  invalidNames(control:FormControl):{[msg:string]:boolean}{
    // if(this.invalidUserNames.indexOf(control.value)!=-1){
    //   return {'invalidName':true};
    // }

    if(this.invalidUserNames.includes(control.value)){
      return {'invalidName':true};
    }
    return{};
  }

}
