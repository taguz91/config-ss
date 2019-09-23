import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/service/login/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = 'johnny';
  password = '';
  isValid = false;

  constructor(private router: Router, private loginService: LoginService) { }

  ngOnInit() {
  }

  checkLogin() {
    if(this.loginService.login(
      this.username, 
      this.password
    )){
      this.router.navigate([''])
      this.isValid = true;
    } else {
      this.isValid = false;
    }
  }

  salir() {
    this.loginService.salir();
    this.router.navigate['login'];
  }

}
