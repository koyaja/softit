import { Country } from '../country';
import { Groupe } from '../groupe';
export class Client {
    constructor(
        public id?: number,
        public name?: string,
        public signature?: string,
        public apigetwayurl?: string,
        public country?: Country,
        public groupe?: Groupe,
    ) {
    }
}
