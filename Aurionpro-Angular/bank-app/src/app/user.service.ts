import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IUser }      from './models/iuser';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  
  private apiUrl = 'http://localhost:8080/app/users';

  constructor(private http: HttpClient) { }

  getUsers(): Observable<IUser[]> 
  {
    return this.http.get<IUser[]>(this.apiUrl);
  }

  validateUser(userLogin: IUser,users: IUser[]) {
    for (let index = 0; index < users.length; index++) {
      const user = users[index];
      
      if (user.userName === userLogin.userName && user.password === userLogin.password && user.roleId.roleId === userLogin.roleId.roleId) {
        return user; // User is found
      }
    }
    return null;
  }


}
