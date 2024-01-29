import { Component } from '@angular/core';
import { FormBuilder, FormGroup,FormControl, Validators } from '@angular/forms';
import { provideAnimations } from '@angular/platform-browser/animations';
import { AuthService } from '../../services/auth-service/auth.service';
import { Route, Router } from '@angular/router';
import { LocalStorageService } from '../../services/storage-service/local-storage.service';
import { Token } from '@angular/compiler';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {
  validateForm!:FormGroup;

  constructor (private authService: AuthService,
    private fb: FormBuilder,
    private router: Router) {  }

  ngOnInit() {
    this.validateForm=this.fb.group({
      username:[null,[Validators.required]],
      password:[null,[Validators.required]]
    })
  }

  

  login(): any {
    console.log(this.validateForm);
    this.authService.login(this.validateForm.get(['username'])!.value,this.validateForm.get(['password'])!.value).subscribe((res:any) =>{
      console.log(res);
      
    //   if (LocalStorageService.isAdminLoggedIn()) {
    //     this.router.navigateByUrl("/admin/dashboard");
    //   }else if(LocalStorageService.isUserLoggedIn()) {
    //     this.router.navigateByUrl("/user/dashboard");
    //   }
    // }, (error: any)=> {
    //   console.log(error)
    //   if(error.status == 406) {
    //     alert("ERROR! \n Account is not active. Please Register!!!")
    //   }
    //   else {
    //     alert("Error! \n Bad Credentials!!!")
    //   }
    const role = res.body.role;
    const token=res.body.token;
    LocalStorageService.roleSaver = role
    LocalStorageService.tokenSaver = token

      if (role === 'ADMIN') {
        this.router.navigateByUrl("/admin/dashboard");
        
      } else if (role === 'USER') {
        this.router.navigateByUrl("/user/dashboard");
        
      }
    },
    (error: any) => {
      console.log(error);

      if (error.status == 406) {
        alert("ERROR! \n Account is not active. Please Register!!!");
      } else {
        alert("Error! \n Bad Credentials!!!");
      }
    }
    
    )
    
     }
}
