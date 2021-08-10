import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SharedService } from '../../shared/services';
declare var jQuery: any;

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
})
export class HeaderComponent implements OnInit {

  constructor(private router: Router,
    private sharedService: SharedService) { }

  ngOnInit() {
  }

  toggleNavigation(): void {
    jQuery('body').toggleClass('mini-navbar');
    this.smoothlyMenu();
  }

  smoothlyMenu() {
    if (!jQuery('body').hasClass('mini-navbar') || jQuery('body').hasClass('body-small')) {
      jQuery('#side-menu').hide();
      setTimeout(
        function () {
          jQuery('#side-menu').fadeIn(400);
        }, 200);
    } else if (jQuery('body').hasClass('fixed-sidebar')) {
      jQuery('#side-menu').hide();
      setTimeout(
        function () {
          jQuery('#side-menu').fadeIn(400);
        }, 100);
    } else {
      jQuery('#side-menu').removeAttr('style');
    }
  }

  doLogout() {
    this.sharedService.logout();
    this.router.navigate(['/login']);
  }

}
