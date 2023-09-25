import { Component,EventEmitter,Input,Output } from '@angular/core';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent {
  @Input() inputData:any;
  @Output() output=new EventEmitter<any>();

  // onSubmit(value:string){
  //   this.output.emit(value);
  // }

  movies:any[]= [];
  
  onSubmit(movie: string, description: string) {
    if(movie.length!=0 && description.length!-0){
      this.movies.push({
        name: movie,
        description: description,
      });
      this.output.emit(this.movies);
    }
  }
  
}
