import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  constructor(private userService: UserService, private router: Router) {}

  public user = {
    username: '',
    email: '',
    password: ''
  };

  onSubmit() {
    console.log(this.user);
    if (this.user.username === '' || this.user.username == null) {
      alert('Username is required');
      return;
    }

    // Add user using UserService
    this.userService.addUser(this.user).subscribe(
      (data) => {
        // Success
        console.log(data);
        alert("Registration successful: " + data);
        this.router.navigate(['/main']); // Redirect to the main page
      },
      (error: HttpErrorResponse) => {
        // Error
        console.error(error);
        if (error.status === 409) {
          // Conflict - User already exists
          alert("User already exists , Please Log In !");
        } else {
          alert("Registration failed: " + error.message);
        }
      }
    );
  }
}
