import { Component } from '@angular/core';
import { AdminService } from '../../admin-service/admin.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent {

  products: any[] = [];

  constructor(
    private adminService: AdminService) { }

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

}
