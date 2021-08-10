import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AuthService } from './../auth.service';
import { CONSTANTS } from '../../shared/constants';

@Component({
  selector: 'app-activation',
  templateUrl: './activation.component.html',
  styleUrls: ['./activation.component.css']
})
export class ActivationComponent implements OnInit {

  isActivateDone: Boolean = false;
  loading: Boolean = false;
  constants;

  constructor(private activatedRoute: ActivatedRoute, private authService: AuthService) { }

  ngOnInit() {
    this.constants = CONSTANTS;
    // this.activatedRoute.queryParams.subscribe((params) => {
    //   this.authService.activateAccount(params['key']).subscribe(
    //     () => {
    //       this.isActivateDone = true;
    //     }
    //   );
    //   this.loading = true;
    // });
  }

}
