import { Component } from '@angular/core';

@Component({
  selector: 'app-daughter',
  templateUrl: './daughter.component.html',
  styleUrls: ['./daughter.component.css']
})
export class DaughterComponent {
  toDos:any[]=[];
  completed:any[]=[];
  id:number=0;
  save(value:string){
    this.toDos.push({id:this.id++ , task:value});
  }

  delete(id:number){
    this.toDos=this.toDos.filter((todo)=>{
      return !(todo.id==id);
    })
  }

  deleteCompletedTask(id:number){
    this.completed=this.completed.filter((todo)=>{
      return !(todo.id==id);
    })
  }

  move(todo:any){
    this.completed.push(todo);
    this.delete(todo.id);
  }
}
