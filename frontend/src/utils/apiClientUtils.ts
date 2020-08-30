import {ACCESS_TOKEN} from "./constants";

export default class ApiClientUtils {
    static getPageableURL(url: URL, page?: number, size?: number): URL {
        if (page) {
            url.searchParams.append('page', page.toString());
        }
        if (size) {
            url.searchParams.append('size', size.toString());
        }
        return url;
    }

    static getConfig() {
        const accessToken = localStorage.getItem(ACCESS_TOKEN);
        if (accessToken) {
            return {
                headers: {Authorization: `Bearer ${accessToken}`}
            }
        }
        return {};
    }
}
