import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { PostCategoryComponent } from './components/post-category/post-category.component';
import { AdminGuard } from '../guards/admin-guard/admin.guard';
import { PostProductComponent } from './components/post-product/post-product.component';

const routes: Routes = [
  {path:'dashboard', component:DashboardComponent, canActivate:[AdminGuard]},
  {path:'category', component:PostCategoryComponent, canActivate:[AdminGuard]},
  {path:'product', component:PostProductComponent, canActivate:[AdminGuard]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
