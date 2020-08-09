import axios from 'axios';
import ApiClientUtils from "../utils/apiClientUtils";
import ListItem from "../models/listItem";

const RESOURCE_URL = process.env.REACT_APP_API_URL + "/lists";

export class ListsClient {
    static async getTechnicalList(page?: number, size?: number): Promise<Page<ListItem>> {
        const url = ApiClientUtils.getPageableURL(new URL(`${RESOURCE_URL}/technical`), page, size);
        const res = await axios.get(url.href);

        return res.data;
    }

    static async getGamingList(page?: number, size?: number) {
        const url = ApiClientUtils.getPageableURL(new URL(`${RESOURCE_URL}/gaming`), page, size);
        const res = await axios.get(url.href);

        return res.data;
    }
}