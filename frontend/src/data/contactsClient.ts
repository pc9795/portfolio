import axios from 'axios';
import Contact from "../models/contact";
import ApiClientUtils from "../utils/apiClientUtils";

const RESOURCE_URL = process.env.REACT_APP_API_BASE_URL + "/v1/contacts";

export default class ContactsClient {
    static async create(contact: Contact) {
        const res = await axios.post(RESOURCE_URL, contact, ApiClientUtils.getConfig());

        return res.data;
    }
}