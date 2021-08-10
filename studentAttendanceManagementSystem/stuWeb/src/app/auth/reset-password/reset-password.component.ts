import { Component, OnInit } from '@angular/core';
import { AuthService } from './../auth.service';
import { ActivatedRoute } from '@angular/router';
import { Utils } from '../../shared/helpers/app.helper';

@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.css']
})
export class ResetPasswordComponent implements OnInit {

  confirmPassword: string;
  doNotMatch: string;
  error: string;
  resetAccount: any;
  success: string;
  key: string;
  keyMissing: boolean;
  year = Utils.getCopyrightYear();

  constructor(
    private authService: AuthService,
    private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.activatedRoute.queryParams.subscribe((params) => {
      this.key = params['key'];
    });
    this.resetAccount = {};
    this.keyMissing = !this.key;
  }

  resetPassword() {
    const param = {
      key: this.key,
      newPassword: this.resetAccount.password
    };
    this.doNotMatch = null;
    this.error = null;
    if (this.resetAccount.password !== this.confirmPassword) {
      this.doNotMatch = 'ERROR';
    } else {
      // this.authService.resetPassword(param).subscribe((res: object) => {
      //   this.success = 'OK';
      // }, () => {
      //   this.success = null;
      //   this.error = 'ERROR';
      // });
    }
  }
}
