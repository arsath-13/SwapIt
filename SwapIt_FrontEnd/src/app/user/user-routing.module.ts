import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { UserGuard } from '../guards/user-guard/user.guard';
import { AboutComponent } from './components/about/about.component';

const routes: Routes = [
  {path:"dashboard",component:DashboardComponent, canActivate:[UserGuard]},
  {path:"about",component:AboutComponent, canActivate:[UserGuard]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule { }
