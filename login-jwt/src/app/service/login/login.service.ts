import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(
    private httpCliente: HttpClient
  ) { }

  login(username: string, password: string) {
    /* Login en memoria asi para noobs 
    if(username === 'javainuse' && password === 'pass'){
      sessionStorage.setItem('username', username);
      return true;
    } else {
      return false;
    }
    */

    // Login con microservicio 
    console.log('Enviaremos el POST para el login');
    let res = this.httpCliente
    .post<any>(
      'http://localhost:6565/login',{
        username, 
        password
      }
    ).pipe(
      map(
        userData => {
          sessionStorage.setItem('username', username);
          console.log(userData);
          let tokenStr = userData.jwttoken;
          console.log('Tenemos token: ' + tokenStr);
          sessionStorage.setItem('token', tokenStr);
          return userData;
        }
      )
    ).subscribe();

    console.log('Respuesta: ');
    console.log(res);
    
    return res;
  }

  testHttp() {
    return this.httpCliente
    .get('http://localhost:6565/saluda', {
      headers: {'Authorization': 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhdWF1IiwiZXhwIjoxNTcwNzY5ODg2LCJpYXQiOjE1NzA3NTE4ODZ9.zBDKkJTK4mJTTVhCLcZ3OK97w8I51Iz43of6CHbdvnBqPCcGeY46pvA-0_RG4t33EHPtsQIITXRa8kVe-D4Ojg'}
    })
    .pipe(
      map(
        res => {
          console.log(res);
        }
      )
    )
    .subscribe();
  }


  existeUsuario(){
    let user = sessionStorage.getItem('username');
    return !(user === null);
  }

  salir() {
    sessionStorage.removeItem('username');
  }

}
