import { Component, OnInit } from '@angular/core';
import { NgbModalRef } from '@ng-bootstrap/ng-bootstrap';

@Component({
    selector: 'zy-navbar',
    templateUrl: './navbar.component.html',
    styleUrls: ['navbar.scss']

})
export class NavbarComponent {
  modalRef: NgbModalRef;

}
