import axios from 'axios';
import Contact from "../models/contact";

const RESOURCE_URL = process.env.REACT_APP_API_URL + "/contacts";

export default class ContactsClient {
    static async create(contact: Contact) {
        const res = await axios.post(RESOURCE_URL, contact);

        return res.data;
    }
}