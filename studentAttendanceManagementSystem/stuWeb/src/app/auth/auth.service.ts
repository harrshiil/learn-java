import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CONSTANTS } from '../shared/constants';
import { utils } from '../shared/helpers';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import { StorageService } from '../shared/services/storage.service';

@Injectable()
export class AuthService {

  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient, private storageService: StorageService) { }

  getOptions(params: object) {
    const requestOptions = {
      body: params,
      headers: this.headers
    };
    return requestOptions;
  }

  login(params: object) {
    // const url = CONSTANTS.ENDPOINTS.LOGIN;
    // return this.http.request(
    //   'POST',
    //   url,
    //   this.getOptions(params)
    // )
    //   .map(utils.extractData)
    //   .catch(utils.handleError);
  }

  forgotPassword(params: object) {
    // const url = CONSTANTS.ENDPOINTS.FORGOTPASSWORD;
    // return this.http.request(
    //   'POST',
    //   url,
    //   this.getOptions(params)
    // )
    //   .map(utils.extractData)
    //   .catch(utils.handleError);
  }

  resetPassword(params: object) {
    // const url = CONSTANTS.ENDPOINTS.RESETPASSWORD;
    // return this.http.request(
    //   'POST',
    //   url,
    //   this.getOptions(params)
    // )
    //   .map(utils.extractData)
    //   .catch(utils.handleError);
  }

  activateAccount(key: object) {
    // const url = CONSTANTS.ENDPOINTS.PLAYER_ACTIVATE + '?key=' + key;
    // return this.http.request(
    //   'PUT',
    //   url,
    // )
    //   .map(utils.extractData)
    //   .catch(utils.handleError);
  }

  activateCoachAccount(key: object) {
    // const url = CONSTANTS.ENDPOINTS.COACH_ACTIVATE + '?key=' + key;
    // return this.http.request(
    //   'PUT',
    //   url,
    // )
    //   .map(utils.extractData)
    //   .catch(utils.handleError);
  }

}
