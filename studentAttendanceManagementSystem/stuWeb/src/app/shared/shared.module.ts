import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StorageService, SharedService, AuthGuardService, NonAuthGuardService, ToasterService } from './services';
import { ErrorMessagesComponent } from './components';
import { IsNumberDirective,
  EmailValidator,
  PhoneValidator,
  PasswordValidator, EqualValidator } from './directives/validation.directive';
import { SearchPipe } from './pipes/search.pipe';
import { EllipsisPipe } from './pipes/ellipsis.pipe';
import { ConfirmationModalComponent } from './components/confirmation-modal/confirmation-modal.component';
import { CapitalizePipe } from './pipes/capitalize.pipe';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { SportListPipe } from './pipes/sport-list.pipe';

@NgModule({
  imports: [
    CommonModule
  ],
  providers: [
    StorageService,
    SharedService,
    AuthGuardService,
    NonAuthGuardService,
    ToasterService
  ],
  declarations: [
    ErrorMessagesComponent,
    IsNumberDirective,
    EmailValidator,
    PhoneValidator,
    PasswordValidator,
    EqualValidator,
    SearchPipe,
    EllipsisPipe,
    ConfirmationModalComponent,
    CapitalizePipe,
    NotFoundComponent,
    SportListPipe
  ],
  exports: [
    ErrorMessagesComponent,
    IsNumberDirective,
    EmailValidator,
    PhoneValidator,
    PasswordValidator,
    EqualValidator,
    SearchPipe,
    EllipsisPipe,
    ConfirmationModalComponent,
    CapitalizePipe,
    SportListPipe
  ],
  entryComponents: [
    ConfirmationModalComponent
  ]
})
export class SharedModule { }
