import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'child-communication';
  data:number=10;
  movies:any[]= [ ];
  inputValue:string='';
  saveMovies(value:any){
    this.movies=value
  }
}
