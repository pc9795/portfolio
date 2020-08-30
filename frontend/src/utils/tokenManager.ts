import {ACCESS_TOKEN} from "./constants";

export default class TokenManager {
    static hasAccessToken() {
        return !!localStorage.getItem(ACCESS_TOKEN);

    }

    static setAccessToken(token: string) {
        localStorage.setItem(ACCESS_TOKEN, token);
    }

    static getAccessToken() {
        return localStorage.getItem(ACCESS_TOKEN);
    }

    static removeAccessToken() {
        localStorage.removeItem(ACCESS_TOKEN);
    }
}