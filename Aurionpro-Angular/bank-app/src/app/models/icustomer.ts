import { IUser } from "./iuser";

export interface ICustomer
{
    customerId: number,
    firstName : string,
    lastName  : string,
    email     : string,
    user_id   : IUser
}