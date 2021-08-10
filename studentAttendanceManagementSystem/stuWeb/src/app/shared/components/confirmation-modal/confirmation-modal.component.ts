import { Component, OnInit } from '@angular/core';
import { BsModalService, BsModalRef, ModalOptions } from 'ngx-bootstrap';

@Component({
  selector: 'app-confirmation-modal',
  templateUrl: './confirmation-modal.component.html',
  styleUrls: ['./confirmation-modal.component.css']
})
export class ConfirmationModalComponent implements OnInit {

  idTobeDel;

  constructor(private modalService: BsModalService, private modalRef: BsModalRef, private modalOptions: ModalOptions) { }

  ngOnInit() {
    this.idTobeDel = this.modalOptions['initialState']['data'];
  }

  confirmDelete() {
    this.modalService.setDismissReason(this.idTobeDel);
    this.modalRef.hide();
  }

  declineDelete() {
    this.modalService.setDismissReason(null);
    this.modalRef.hide();
  }

}
