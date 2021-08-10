import { AuthService } from './../auth.service';
import { Component, OnInit } from '@angular/core';
import { Utils } from '../../shared/helpers/app.helper';
import { Router } from '@angular/router';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {
  email: string;
  year = Utils.getCopyrightYear();

  constructor(private authService: AuthService,
    private router: Router) { }

  ngOnInit() {
  }

  forgotPassword() {
    const param = {
      email: this.email
    };
    // this.authService.forgotPassword(param).subscribe((res: object) => {
    //   this.router.navigate(['/login']);
    // });
  }

}
