import { Injectable } from '@angular/core';
import { Location } from '@angular/common';
import { StorageService } from './storage.service';
import { Http, Response, URLSearchParams } from '@angular/http';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { CONSTANTS } from '../constants';
import { utils } from '../helpers';

@Injectable()
export class SharedService {

  constructor(private storageService: StorageService, private http: HttpClient,
    private location: Location) { }

  setUserData(data: object) {
    this.storageService.setObject('user', data);
  }

  public getUserData(key: string) {
    return this.storageService.getObject('user') ? this.storageService.getObject('user')[key] : null;
  }

  public isLoggedIn() {
    const token = this.getUserData('token');
    if (token != null) {
      return true;
    }
    return false;
  }

  public logout() {
    this.storageService.setObject('user', null);
  }

  deleteUser(id) {
    // const url = CONSTANTS.ENDPOINTS.DELETEUSER;
    // return this.http.request('DELETE', url + '/' + id)
    //   .map(utils.extractData)
    //   .catch(utils.handleError);
  }

  public toggleSidebar() {
    jQuery('#middle').toggleClass('mini-navbar');
    if (!jQuery('#middle').hasClass('mini-navbar') || jQuery('#middle').hasClass('body-small')) {
      jQuery('#side-menu').hide();
      setTimeout(
        function () {
          jQuery('#side-menu').fadeIn(400);
        }, 200);
    } else if (jQuery('#middle').hasClass('fixed-sidebar')) {
      jQuery('#side-menu').hide();
      setTimeout(
        function () {
          jQuery('#side-menu').fadeIn(400);
        }, 100);
    } else {
      jQuery('#side-menu').removeAttr('style');
    }
  }

  public activeRoute(routename: string): boolean {
    const routes = routename.split(',');
    let check = false;
    for (let i = 0; i < routes.length; i++) {
      if (this.location.path().indexOf(routes[i]) >= 0) {
        check = true;
        break;
      } else {
        check = false;
        continue;
      }
    }
    return check;
  }

}
