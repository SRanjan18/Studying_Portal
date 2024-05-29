import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private http: HttpClient) {}

  // Add new user
  public addUser(user: any) {
    return this.http.post(`${baseUrl}/save`, user, { responseType: 'text' });
  }
   // Login user
   public loginUser(user: any) {
    return this.http.post(`${baseUrl}/login`, user);
  }
}
