import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
    name: 'search'
})
export class SearchPipe implements PipeTransform {

    transform(value: Array<any>, args: any[]) {
        if (value !== undefined) {
            return value.filter(item => {
                let count = 0;
                let match = true;
                for (let i = 0; i < args.length; i++) {
                    if (args[i][1] === undefined || args[i][1] === '') {
                        count = count + 1;
                        continue;
                    }
                    // tslint:disable-next-line:max-line-length
                    if (item[args[i][0]] != null && item[args[i][0]].toString().toLowerCase().indexOf(args[i][1].toString().toLowerCase()) >= 0) {
                        count = count + 1;
                        continue;
                    } else {
                        match = false;
                    }
                }
                if (count > 0) {
                    match = true;
                }
                return match;
            });
        }
    }
}
