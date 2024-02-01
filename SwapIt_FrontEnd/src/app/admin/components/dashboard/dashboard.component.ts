import { Component } from '@angular/core';
import { AdminService } from '../../admin-service/admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent {

  products: any[] = [];

  constructor(
    private adminService: AdminService,
    private router: Router) { }

  ngOnInit() {
    this.getAllProducts()
  }

  getAllProducts() {
    this.adminService.getAllProducts().subscribe((res)=>{
      console.log(res);
      res.forEach((element:any) => {
        element.processedImage = "data:image/jpeg;base64,"+element.returnedImage;
        this.products.push(element as any);
      });
    })
  }

  deleteProduct(id:number) {
    console.log(id);
    this.adminService.deleteProduct(id).subscribe((res)=> {
      console.log(res)
      alert("Product is deleted succesfully!!");
      this.router.navigateByUrl("/admin/product")
    })
  }

}
