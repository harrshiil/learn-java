import { Component, OnInit } from '@angular/core';
// import { PostManagementService } from '.././post-management/post-management.service';
// import { Dashboard } from '../post-management';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  dashboard: any;

  constructor(
  ) { }

  ngOnInit() {
    // this.getDashboardValues();
  }

}
