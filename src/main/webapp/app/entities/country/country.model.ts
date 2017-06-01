import { Client } from '../client';
export class Country {
    constructor(
        public id?: number,
        public countryname?: string,
        public countrycode?: string,
        public clients?: Client,
    ) {
    }
}
