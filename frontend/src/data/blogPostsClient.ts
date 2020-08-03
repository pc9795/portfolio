import {API_URL} from "../utils/constants";
import axios from 'axios';
import BlogPost from "../models/blogPost";
import ApiClientUtils from "../utils/apiClientUtils";

const RESOURCE_URL = API_URL + "/blog-posts";

export default class BlogPostsClient {
    static async getAll(page: number, size: number): Promise<Page<BlogPost>> {
        const url = ApiClientUtils.getPageableURL(new URL(RESOURCE_URL), page, size);
        const res = await axios.get(url.href);

        return res.data;
    }

    static getByYear(year: string) {
    }

    static getByMonthYear(year: string, month: string) {
    }

    static search(searchText: string) {
    }

    static getByName(blogPostName: string) {
    }
}