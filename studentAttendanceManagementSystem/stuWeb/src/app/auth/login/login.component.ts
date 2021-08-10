import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Utils } from '../../shared/helpers/app.helper';
import { AuthService } from '../auth.service';
import { SharedService } from '../../shared/services';

@Component({
    moduleId: module.id,
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
    email: string;
    password: string;
    confirmPassword: string;
    year = Utils.getCopyrightYear();

    constructor(
        private router: Router,
        private authService: AuthService,
        private sharedService: SharedService) { }

    ngOnInit() {
    }

    login() {
        const param = {
            email: this.email,
            password: this.password
        };
        // this.authService.login(param).subscribe((res: object) => {
        //     this.sharedService.setUserData(res);
        //     this.router.navigate(['/dashboard']);
        // });

    }
}
