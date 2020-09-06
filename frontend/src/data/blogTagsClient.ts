import axios from 'axios';
import ApiClientUtils from "../utils/apiClientUtils";
import BlogTag from "../models/blogTag";
import {Page} from "../react-app-env";

const RESOURCE_URL = process.env.REACT_APP_API_BASE_URL + "/v1/blog-tags";

export class BlogTagsClient {
    static async getAll(page?: number, size?: number): Promise<Page<BlogTag>> {
        const url = ApiClientUtils.getPageableURL(new URL(RESOURCE_URL), page, size);
        const res = await  axios.get(url.href, ApiClientUtils.getConfig());

        return res.data;
    }
}