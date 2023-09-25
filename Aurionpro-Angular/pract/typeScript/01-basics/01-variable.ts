// let found:boolean=false;
// let firstName:string='Aashish';

// let scores:number[]=[23,42,43,42,11,4,55];

// console.log(found);
// scores.forEach(score=>{
//     console.log(score);
// })

class Customer{
    firstName:string;
    lastName:string;

    constructor(firstName:string,lastName:string){
        this.firstName=firstName;
        this.lastName=lastName;
    }
    public setFistName(firstName:string){
        this.firstName=firstName;
    }
    public getFisrtName():string{
        return this.firstName;
    }
    public setLastName(lastName:string){
        this.lastName=lastName;
    }
    public getLastName():string{
        return this.lastName;
    }

}

let customer1=new Customer("Aashish","Verma")
customer1.setLastName("Varma")
console.log(customer1.getLastName());