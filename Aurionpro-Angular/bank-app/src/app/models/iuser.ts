import { IRole } from "./irole";

export interface IUser {
  userId:number;
  userName: string;
  password: string;
  roleId:IRole;
}
