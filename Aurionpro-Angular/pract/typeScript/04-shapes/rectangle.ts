import { Shape } from "./Shape";
export class Rectangle extends Shape{
    constructor(theX:number,theY:number,private _height:number,private _width:number){
        super(theX,theY);
    }
    public getInfo():string{
        return super.getInfo()+` height=${this._height} and width=${this._width}`
    }

    public calculateArea(): number {
        return this._height*this._width
    }
}
