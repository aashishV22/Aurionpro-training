import { Shape } from "./Shape";
import { Rectangle} from './rectangle';

let rectangle=new Rectangle(31,33,10,20)
let shapes:Shape[]=[];
shapes.push(rectangle);

shapes.forEach(shape=>{
    console.log(shape.getInfo());
    console.log(shape.calculateArea());
})