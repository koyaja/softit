import { Client } from '../client';
export class Groupe {
    constructor(
        public id?: number,
        public name?: string,
        public client?: Client,
    ) {
    }
}
