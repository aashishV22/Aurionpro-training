import { Shape } from "./Shape";
import { Rectangle} from './rectangle';

let rectangle=new Rectangle(10,20)
let shapes:Shape[]=[];
shapes.push(rectangle);
let rectangle2=new Rectangle(16,20)
shapes.push(rectangle2);
shapes.forEach(shape=>{
    console.log(shape.calculateArea());
})