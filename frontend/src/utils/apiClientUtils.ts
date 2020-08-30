import TokenManager from "./tokenManager";

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
        if (TokenManager.hasAccessToken()) {
            return {
                headers: {Authorization: `Bearer ${TokenManager.getAccessToken()}`}
            }
        }
        return {};
    }
}
