import {API_URL} from "../utils/constants";
import axios from 'axios';
import ApiClientUtils from "../utils/apiClientUtils";
import BlogTag from "../models/blogTag";

const RESOURCE_URL = API_URL + "/blog-tags";

export class BlogTagsClient {
    static async getAll(page?: number, size?: number): Promise<Page<BlogTag>> {
        const url = ApiClientUtils.getPageableURL(new URL(RESOURCE_URL), page, size);
        const res = await  axios.get(url.href);

        return res.data;
    }
}