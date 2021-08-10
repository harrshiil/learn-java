import { Component, OnInit } from '@angular/core';
import { Utils } from '../../shared/helpers/app.helper';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
})
export class FooterComponent implements OnInit {

  year = Utils.getCopyrightYear();

  constructor() { }

  ngOnInit() {
  }

}
