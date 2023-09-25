// let found:boolean=false;
// let firstName:string='Aashish';
// let scores:number[]=[23,42,43,42,11,4,55];
// console.log(found);
// scores.forEach(score=>{
//     console.log(score);
// })
var Customer = /** @class */ (function () {
    function Customer(firstName, lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    Customer.prototype.setFistName = function (firstName) {
        this.firstName = firstName;
    };
    Customer.prototype.getFisrtName = function () {
        return this.firstName;
    };
    Customer.prototype.setLastName = function (lastName) {
        this.lastName = lastName;
    };
    Customer.prototype.getLastName = function () {
        return this.lastName;
    };
    return Customer;
}());
var customer1 = new Customer("Aashish", "Verma");
customer1.setLastName("Varma");
console.log(customer1.getLastName());
