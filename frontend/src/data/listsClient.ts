import axios from 'axios';
import ApiClientUtils from "../utils/apiClientUtils";
import ListItem from "../models/listItem";
import {Page} from "../react-app-env";

const RESOURCE_URL = process.env.REACT_APP_API_BASE_URL + "/v1/lists";

export class ListsClient {
    static async getTechnicalList(page?: number, size?: number): Promise<Page<ListItem>> {
        const url = ApiClientUtils.getPageableURL(new URL(`${RESOURCE_URL}/technical`), page, size);
        const res = await axios.get(url.href, ApiClientUtils.getConfig());

        return res.data;
    }

    static async getGamingList(page?: number, size?: number): Promise<Page<ListItem>> {
        const url = ApiClientUtils.getPageableURL(new URL(`${RESOURCE_URL}/gaming`), page, size);
        const res = await axios.get(url.href, ApiClientUtils.getConfig());

        return res.data;
    }
}