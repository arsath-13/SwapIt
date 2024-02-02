import { Component } from '@angular/core';
import { CustomerService } from '../../service/customer.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent {

  products: any[] = [];

  constructor(private service: CustomerService) {
    // this.getAllProducts();
  }

  ngOnInit(){ 
    this.getAllProducts();
  }

  getAllProducts() {
    this.service.getAllProducts().subscribe((res)=>{
      console.log(res);
      res.forEach((element:any) => {
        element.processedImage = "data:image/jpeg;base64,"+element.returnedImage;
        this.products.push(element as any);
      });
    })
  }

}
