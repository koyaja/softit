import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { ServeurEticketClientModule } from './client/client.module';
import { ServeurEticketGroupeModule } from './groupe/groupe.module';
import { ServeurEticketCountryModule } from './country/country.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    imports: [
        ServeurEticketClientModule,
        ServeurEticketGroupeModule,
        ServeurEticketCountryModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ServeurEticketEntityModule {}
