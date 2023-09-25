"use strict";
// let found:boolean=false;
// let firstName:string='Aashish';
Object.defineProperty(exports, "__esModule", { value: true });
exports.Customer2 = void 0;
// let scores:number[]=[23,42,43,42,11,4,55];
// console.log(found);
// scores.forEach(score=>{
//     console.log(score);
// })
var Customer2 = /** @class */ (function () {
    function Customer2(_firstName, _lastName) {
        this._firstName = _firstName;
        this._lastName = _lastName;
        this._firstName = _firstName;
        this._lastName = _lastName;
    }
    Customer2.prototype.setFistName = function (firstName) {
        this._firstName = firstName;
    };
    Customer2.prototype.getFisrtName = function () {
        return this._firstName;
    };
    Customer2.prototype.setLastName = function (lastName) {
        this._lastName = lastName;
    };
    Customer2.prototype.getLastName = function () {
        return this._lastName;
    };
    return Customer2;
}());
exports.Customer2 = Customer2;
// let customer2=new Customer2("Vedang","Badwe")
// customer2.setLastName("bhatam")
// console.log(customer2.getLastName());
