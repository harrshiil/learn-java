import { Injectable } from '@angular/core';
import {
  CanActivate, Router,
  ActivatedRouteSnapshot,
  RouterStateSnapshot
} from '@angular/router';
import { SharedService } from './shared.service';

@Injectable()
export class AuthGuardService {

  constructor(private sharedService: SharedService,
    private router: Router) { }


  canActivate(): boolean {
    if (this.sharedService.isLoggedIn()) {
      return true;
    }
    this.router.navigate(['login']);
    return false;
  }

  // canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
  //   const url: string = state.url;
  //   return this.checkLogin(url, route.data);
  // }

  // checkLogin(url: string, data: object): boolean {
  //   if (this.sharedService.isAuthenticated()) {
  //     if (this.sharedService.checkRole(data['roles'])) {
  //       return true;
  //     } else {
  //       this.toaster.error(es['authError'], es['error']);
  //       this.router.navigate(['/home']);
  //       return false;
  //     }
  //   } else {
  //     this.sharedService.setRedirectUrl(url);
  //     this.modalService.show(LoginComponent);
  //     return false;
  //   }
  // }

}


@Injectable()
export class NonAuthGuardService {

  constructor(private sharedService: SharedService,
    private router: Router) { }


  canActivate(): boolean {
    if (this.sharedService.isLoggedIn() === false) {
      return true;
    }
    this.router.navigate(['dashboard']);
    return false;
  }

  // canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
  //   const url: string = state.url;
  //   return this.checkLogin(url, route.data);
  // }

  // checkLogin(url: string, data: object): boolean {
  //   if (this.sharedService.isAuthenticated()) {
  //     if (this.sharedService.checkRole(data['roles'])) {
  //       return true;
  //     } else {
  //       this.toaster.error(es['authError'], es['error']);
  //       this.router.navigate(['/home']);
  //       return false;
  //     }
  //   } else {
  //     this.sharedService.setRedirectUrl(url);
  //     this.modalService.show(LoginComponent);
  //     return false;
  //   }
  // }

}
