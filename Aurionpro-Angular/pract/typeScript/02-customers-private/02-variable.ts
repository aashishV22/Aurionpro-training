// let found:boolean=false;
// let firstName:string='Aashish';

// let scores:number[]=[23,42,43,42,11,4,55];

// console.log(found);
// scores.forEach(score=>{
//     console.log(score);
// })
export class Customer2
{

    constructor(private _firstName:string,private _lastName:string){
        this._firstName=_firstName;
        this._lastName=_lastName;
    }
    public setFistName(firstName:string){
        this._firstName=firstName;
    }
    public getFisrtName():string{
        return this._firstName;
    }
    public setLastName(lastName:string){
        this._lastName=lastName;
    }
    public getLastName():string{
        return this._lastName;
    }

}

// let customer2=new Customer2("Vedang","Badwe")
// customer2.setLastName("bhatam")
// console.log(customer2.getLastName());