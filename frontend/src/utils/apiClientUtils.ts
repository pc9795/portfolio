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
}
