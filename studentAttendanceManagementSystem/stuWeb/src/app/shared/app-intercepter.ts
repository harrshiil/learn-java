import { Injectable } from '@angular/core';
import { HttpEvent, HttpInterceptor, HttpHandler, HttpRequest, HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SharedService, ToasterService } from './services';
import { NgxSpinnerService } from 'ngx-spinner';
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/do';
import { CONSTANTS } from './constants';

@Injectable()
export class AppInterceptor implements HttpInterceptor {

    constructor(
        private sharedService: SharedService,
        private toaster: ToasterService,
        private spinner: NgxSpinnerService
    ) { }

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        const authToken = this.sharedService.getUserData('token');
        let authRequest;
        if (authToken) {
            authRequest = req.clone({ headers: req.headers.set('Authorization', 'Bearer ' + authToken) });
        } else {
            authRequest = req.clone();
        }
        this.spinner.show();
        return next
            .handle(authRequest)
            .do(event => {
                if (event instanceof HttpResponse) {
                    this.requestSuccess(event, req.method);
                }
            })
            .catch((error: HttpErrorResponse) => {
                if (error.error instanceof Error) {
                    // A client-side or network error occurred. Handle it accordingly.
                    console.log('An error occurred:', error.error.message);
                } else {
                    if (error.status === 403) {
                    }
                    // The backend returned an unsuccessful response code.
                    // The response body may contain clues as to what went wrong,
                    console.log(`Backend returned code ${error.status}, body was: ${error.error}`);
                }
                if (error.status === 400) {
                    this.toaster.error(error.error.message, 'Error');
                } else if (error.status === 401) {
                    this.toaster.error(CONSTANTS.MESSAGES.UNAUTHORIZED, 'Error');
                } else {
                    this.toaster.error(CONSTANTS.MESSAGES.SERVER_ERROR, 'Error');
                }
                this.spinner.hide();
                return Observable.throw(error);
            });
    }

    private requestSuccess(res: HttpResponse<any>, method: String) {
        if (method !== 'GET') {
            setTimeout(() => {
                this.toaster.success(CONSTANTS.MESSAGES.SUCCESS, 'Success');
            }, 100);
        }
        this.spinner.hide();
        return res;
    }
}
