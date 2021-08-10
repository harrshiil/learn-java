import { Injectable } from '@angular/core';

@Injectable()
export class StorageService {

  constructor() { }

  getObject(objectKey: string) {
    const res = JSON.parse(localStorage.getItem(objectKey));
    return res;
  }
  setObject(objectKey: string, objectValue: any) {
    localStorage.setItem(objectKey, typeof objectValue === 'object' ? JSON.stringify(objectValue) : objectValue);
  }

}
