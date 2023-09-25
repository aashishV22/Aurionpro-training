import { Component } from '@angular/core';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent {
  show=false;
  color='blue';
  players:string[]=['ash','ved','tanz'];

  students=[
    {
      id:12,
      firstName:'Aashish',
      percentage:82.31,
    },
    {
      id:22,
      firstName:'Vedang',
      percentage:85.31,
    },
    {
      id:32,
      firstName:'Tanz',
      percentage:89.31,
    }
  
  ]



}
