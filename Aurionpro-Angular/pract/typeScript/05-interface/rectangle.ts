import { Shape } from "./Shape";
export class Rectangle implements Shape{
    constructor(private _height:number,private _width:number){
    }
    public getInfo():string{
        return `height=${this._height} and width=${this._width}`
    }

    public calculateArea(): number {
        return this._height*this._width
    }
}
