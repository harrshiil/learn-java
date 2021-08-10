import { Injectable } from '@angular/core';
import { ToastyService, ToastyConfig, ToastOptions, ToastData } from 'ng2-toasty';
import { CONSTANTS } from '../constants';

@Injectable()
export class ToasterService {

  toastOptions: ToastOptions;

  constructor(private toastyService: ToastyService, private toastyConfig: ToastyConfig) {
    // Or create the instance of ToastOptions
    this.toastOptions = {
      title: '',
      msg: '',
      showClose: true,
      timeout: CONSTANTS['TOASTER'].toasterTimeout,
      theme: CONSTANTS['TOASTER'].theme,
      onAdd: (toast: ToastData) => {
        console.log('Toast ' + toast.id + ' has been added!');
      },
      onRemove: function (toast: ToastData) {
        console.log('Toast ' + toast.id + ' has been removed!');
      }
    };
    this.toastyConfig.limit = 1;
    this.toastyConfig.position = 'top-right';
  }

  info(msg: string, title?: string) {
    this.toastOptions = {
      title: title,
      msg: msg
    };
    this.toastyService.info(this.toastOptions);
  }

  success(msg: string, title?: string) {
    this.toastOptions = {
      title: title,
      msg: msg
    };
    this.toastyService.success(this.toastOptions);
  }

  wait(msg: string, title?: string) {
    this.toastOptions = {
      title: title,
      msg: msg
    };
    this.toastyService.wait(this.toastOptions);
  }

  error(msg: string, title?: string) {
    this.toastOptions = {
      title: title,
      msg: msg
    };
    this.toastyService.error(this.toastOptions);
  }

  warning(msg: string, title?: string) {
    this.toastOptions = {
      title: title,
      msg: msg
    };
    this.toastyService.warning(this.toastOptions);
  }

  default(msg: string, title?: string) {
    this.toastOptions = {
      title: title,
      msg: msg
    };
    this.toastyService.default(this.toastOptions);
  }
}
