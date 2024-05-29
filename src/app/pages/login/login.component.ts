import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  constructor(private userService: UserService, private router: Router) {}

  public loginData = {
    email: '',
    password: ''
  };

  onSubmit() {
    console.log(this.loginData);
    if (this.loginData.email === '' || this.loginData.email === null) {
      alert('Email is required');
      return;
    }

    // Login using UserService
    this.userService.loginUser(this.loginData).subscribe(
      (data) => {
        // Success
        console.log(data);
        alert("Login successful");
        this.router.navigate(['/main']); // Redirect to the main page
      },
      (error: HttpErrorResponse) => {
        // Error
        console.error(error);
        if (error.status === 409) {
          // Conflict - Email does not exist
          alert("User does not exist , Please SignIn !");
        } else {
          alert("Login failed: " + error.message);
        }
      }
    );
  }
}
