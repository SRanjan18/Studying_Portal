import { Component } from '@angular/core';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  constructor(private userService:UserService){}
public user={
  username:'',
  password:'',
  firstname:'',
  lastname:'',
  email:'',
  phone:''
}

onSubmit(){
  console.log(this.user);
  if(this.user.username =='' || this.user.username==null){
    alert('Username is required');
    return;
  }
//adduser:UserService
this.userService.addUser(this.user).subscribe(
  (data)=>{
    //success
    console.log(data);
    alert("success");
  },
  (error)=>{
    console.log(error);
    alert("error");

  }
)  

}


}
