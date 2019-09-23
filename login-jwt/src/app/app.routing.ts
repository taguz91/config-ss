import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './component/login/login.component';
import { HelloComponent } from './component/hello/hello.component';
import { HomeComponent } from './component/home/home.component';
import { LogoutComponent } from './component/logout/logout.component';
import { RegisterComponent } from './component/register/register.component';
import { NavFilterService } from './service/login/nav-filter.service';

const routes: Routes = [
  { 
    path: 'login', 
    component: LoginComponent
  },
  { 
    path: 'logout', 
    component: LogoutComponent,
    canActivate: [NavFilterService]
  },
  { 
    path: 'hola', 
    component: HelloComponent,
    canActivate: [NavFilterService]
  },
  { 
    path: 'register', 
    component: RegisterComponent
  },
  { 
    path: '', 
    component: HomeComponent,
    canActivate: [NavFilterService]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }