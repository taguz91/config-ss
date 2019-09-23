import { Injectable } from '@angular/core';

import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { LoginService } from './login.service';
import { resolve } from 'url';

@Injectable({
  providedIn: 'root'
})
export class NavFilterService implements CanActivate {

  constructor(
    private router: Router,
    private loginService: LoginService
  ) { }

  
  canActivate(
    route: ActivatedRouteSnapshot, 
    state: RouterStateSnapshot
  ){
    if(this.loginService.existeUsuario()){
      return true;
    } else {
      this.router.navigate(['login']);
      return false;
    }
  }

}
