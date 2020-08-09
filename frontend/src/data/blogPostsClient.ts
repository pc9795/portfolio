import axios from 'axios';
import BlogPost from "../models/blogPost";
import ApiClientUtils from "../utils/apiClientUtils";

const RESOURCE_URL = process.env.REACT_APP_API_URL + "/blog-posts";

export default class BlogPostsClient {
    static async getAll(page?: number, size?: number): Promise<Page<BlogPost>> {
        const url = ApiClientUtils.getPageableURL(new URL(RESOURCE_URL), page, size);
        const res = await axios.get(url.href);

        return res.data;
    }

    static async getByYear(year: string, page?: number, size?: number): Promise<Page<BlogPost>> {
        const url = ApiClientUtils.getPageableURL(new URL(`${RESOURCE_URL}/year/${year}`), page, size);
        const res = await axios.get(url.href);

        return res.data;
    }

    static async getByMonthYear(year: string, month: string, page?: number, size?: number): Promise<Page<BlogPost>> {
        const url = ApiClientUtils.getPageableURL(new URL(`${RESOURCE_URL}/year/${year}/month/${month}`), page, size);
        const res = await axios.get(url.href);

        return res.data;
    }

    static async search(searchText: string, page?: number, size?: number): Promise<Page<BlogPost>> {
        const url = ApiClientUtils.getPageableURL(new URL(`${RESOURCE_URL}/search/${searchText}`), page, size);
        const res = await axios.get(url.href);

        return res.data;
    }

    static async getByName(blogPostName: string): Promise<BlogPost> {
        const res = await axios.get(`${RESOURCE_URL}/${blogPostName}`);

        return res.data;
    }

    static async getByTagName(blogTagName: string, page?: number, size?: number): Promise<Page<BlogPost>> {
        const url = ApiClientUtils.getPageableURL(new URL(`${RESOURCE_URL}/blog-tags/${blogTagName}`), page, size);
        const res = await axios.get(url.href);

        return res.data;
    }
}