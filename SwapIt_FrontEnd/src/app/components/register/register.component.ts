import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth-service/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {
  validateForm!: FormGroup;

  constructor(private fb: FormBuilder, private authService: AuthService) {
    }

  ngOnInit() {
    this.validateForm = this.fb.group({
      name: [null, [Validators.required]],
      email: [null, [Validators.required, Validators.email]],
      password: [null, [Validators.required, Validators.pattern(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/)]],
      confirmPassword: [null, [Validators.required, this.confirmationValidator]]
    });
  }

  register() {
    console.log(this.validateForm.value);
    this.authService.register(this.validateForm.value).subscribe((res) =>{
      console.log(res);
    })
     }

  hasErrorMessages(): boolean {
    return !!(
      this.validateForm.get('email')?.hasError('required') ||
      this.validateForm.get('password')?.hasError('pattern') ||
      this.validateForm.get('confirmPassword')?.hasError('required') ||
      this.validateForm.hasError('confirm', 'confirmPassword') ||
      this.validateForm.get('name')?.hasError('required')
    );
  }

  confirmationValidator = (control: FormControl): { [s: string]: boolean } => {
    if (!control.value) {
      return { required: true };
    } else if (control.value !== this.validateForm.controls['password'].value) {
      return { confirm: true, error: true };
    }
    return {};
  };
}
