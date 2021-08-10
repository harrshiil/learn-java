import { Component, OnInit, AfterViewInit } from '@angular/core';
import { SharedService } from '../../shared/services';

declare const jQuery: any;

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
})
export class SidebarComponent implements OnInit, AfterViewInit {

  constructor(private sharedService: SharedService) { }

  ngOnInit() {
  }

  ngAfterViewInit() {
    jQuery('#side-menu').metisMenu();
  }

  toggleSidebar(): void {
    this.sharedService.toggleSidebar();
  }

  activeRoute(routename: string) {
    return this.sharedService.activeRoute(routename);
  }

}
