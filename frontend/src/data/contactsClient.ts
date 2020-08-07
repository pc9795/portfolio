import {API_URL} from "../utils/constants";
import axios from 'axios';
import Contact from "../models/contact";

const RESOURCE_URL = API_URL + "/contacts";

export default class ContactsClient {
    static create(contact: Contact) {

    }
}