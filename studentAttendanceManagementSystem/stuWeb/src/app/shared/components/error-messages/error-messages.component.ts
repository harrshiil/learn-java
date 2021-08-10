import { Component, OnInit, Input } from '@angular/core';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-error-messages',
  template: `<div class="input-error" *ngIf="errorMessage !== null">{{errorMessage}}</div>`,
  styleUrls: ['./error-messages.component.css']
})
export class ErrorMessagesComponent implements OnInit {

  @Input() control: FormControl;

  constructor() { }

  get errorMessage() {
    for (const propertyName in this.control.errors) {
      if (this.control.errors.hasOwnProperty(propertyName) && this.control.touched) {
        return this.getValidatorErrorMessage(propertyName, this.control.errors[propertyName]);
      }
    }
    return null;
  }

  getValidatorErrorMessage(validatorName: string, validatorValue?: any) {
    const config = {
      'required': 'Required Field',
      'appPhoneValidate': 'Invalid Phone',
      'appEmailValidate': 'Invalid Email Address',
      'appPasswordValidate': 'Password must containt 8 characters, capital letters, lowercase, numbers and special character.',
      'minlength': `Minimum Length ${validatorValue.requiredLength}`,
      'min': `Minumum Value ${validatorValue.min}`,
      'max': `Maximum Value ${validatorValue.max}`,
      'appEqualvalidate': 'Password Mismatch',
    };

    return config[validatorName];
  }

  ngOnInit() {
  }

}
