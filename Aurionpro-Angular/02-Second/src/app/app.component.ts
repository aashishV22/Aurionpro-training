import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = '02-Second';
  toDos:any[]=[];
  id:number=0;
  save(value:string){
    this.toDos.push({id:this.id++ , task:value});
  }

  delete(id:number){
    this.toDos=this.toDos.filter((todo)=>{
      return !(todo.id==id);
    })
  }
}
