import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { EventManager, AlertService } from 'ng-jhipster';

import { Country } from './country.model';
import { CountryPopupService } from './country-popup.service';
import { CountryService } from './country.service';
import { Client, ClientService } from '../client';
import { ResponseWrapper } from '../../shared';

@Component({
    selector: 'jhi-country-dialog',
    templateUrl: './country-dialog.component.html'
})
export class CountryDialogComponent implements OnInit {

    country: Country;
    authorities: any[];
    isSaving: boolean;

    clients: Client[];

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: AlertService,
        private countryService: CountryService,
        private clientService: ClientService,
        private eventManager: EventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
        this.authorities = ['ROLE_USER', 'ROLE_ADMIN'];
        this.clientService.query()
            .subscribe((res: ResponseWrapper) => { this.clients = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
    }
    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.country.id !== undefined) {
            this.subscribeToSaveResponse(
                this.countryService.update(this.country));
        } else {
            this.subscribeToSaveResponse(
                this.countryService.create(this.country));
        }
    }

    private subscribeToSaveResponse(result: Observable<Country>) {
        result.subscribe((res: Country) =>
            this.onSaveSuccess(res), (res: Response) => this.onSaveError(res));
    }

    private onSaveSuccess(result: Country) {
        this.eventManager.broadcast({ name: 'countryListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError(error) {
        try {
            error.json();
        } catch (exception) {
            error.message = error.text();
        }
        this.isSaving = false;
        this.onError(error);
    }

    private onError(error) {
        this.alertService.error(error.message, null, null);
    }

    trackClientById(index: number, item: Client) {
        return item.id;
    }
}

@Component({
    selector: 'jhi-country-popup',
    template: ''
})
export class CountryPopupComponent implements OnInit, OnDestroy {

    modalRef: NgbModalRef;
    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private countryPopupService: CountryPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.modalRef = this.countryPopupService
                    .open(CountryDialogComponent, params['id']);
            } else {
                this.modalRef = this.countryPopupService
                    .open(CountryDialogComponent);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
