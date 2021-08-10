import { Observable } from 'rxjs/Observable';

export const utils: any = {
    handleError: (error: Response | any) => {
        let errMsg: string;
        if (error instanceof Response) {
            const body = error.json() || '';
            const err = body['error'] || JSON.stringify(body);
            errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
        } else {
            errMsg = error.message ? error.message : error.toString();
        }
        return Observable.throw(errMsg);
    },
    extractData: (res: Response) => {
        return res;
    },

};

export class Utils {
    public static getCopyrightYear() {
        const startYear = 2018;
        const currentYear = new Date().getFullYear();
        if (startYear === currentYear) {
            return currentYear;
        } else {
            return startYear + '-' + currentYear;
        }
    }
}
