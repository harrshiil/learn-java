import { Component, OnInit } from '@angular/core';
import { Utils } from '../../shared/helpers/app.helper';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  year = Utils.getCopyrightYear();

  constructor() { }

  ngOnInit() {
  }

}
