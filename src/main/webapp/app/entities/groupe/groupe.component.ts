import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs/Rx';
import { EventManager, ParseLinks, PaginationUtil, JhiLanguageService, AlertService } from 'ng-jhipster';

import { Groupe } from './groupe.model';
import { GroupeService } from './groupe.service';
import { ITEMS_PER_PAGE, Principal, ResponseWrapper } from '../../shared';
import { PaginationConfig } from '../../blocks/config/uib-pagination.config';

@Component({
    selector: 'jhi-groupe',
    templateUrl: './groupe.component.html'
})
export class GroupeComponent implements OnInit, OnDestroy {
groupes: Groupe[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private groupeService: GroupeService,
        private alertService: AlertService,
        private eventManager: EventManager,
        private principal: Principal
    ) {
    }

    loadAll() {
        this.groupeService.query().subscribe(
            (res: ResponseWrapper) => {
                this.groupes = res.json;
            },
            (res: ResponseWrapper) => this.onError(res.json)
        );
    }
    ngOnInit() {
        this.loadAll();
        this.principal.identity().then((account) => {
            this.currentAccount = account;
        });
        this.registerChangeInGroupes();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: Groupe) {
        return item.id;
    }
    registerChangeInGroupes() {
        this.eventSubscriber = this.eventManager.subscribe('groupeListModification', (response) => this.loadAll());
    }

    private onError(error) {
        this.alertService.error(error.message, null, null);
    }
}
