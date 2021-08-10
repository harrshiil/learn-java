import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'sportList'
})
export class SportListPipe implements PipeTransform {

  transform(sportList: any[]): string {
    let sportString = '';

    for (let index = 0; index < sportList.length; index++) {
      if (index + 1 === sportList.length) {
        sportString = sportString + sportList[index].name;
      } else {
        sportString = sportString + sportList[index].name + ', ';
      }
    }
    return sportString;
  }

}
