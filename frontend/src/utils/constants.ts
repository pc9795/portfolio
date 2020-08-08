export class FaviconConstants {
    static URL = process.env.PUBLIC_URL + "favicon-16x16.png";
    static BIRTHDAY_URL = process.env.PUBLIC_URL + "favicon-brithday-16x16.png";
}

export class ImageConstants {
    static CAKE = process.env.PUBLIC_URL + "img/cake.png";
    static TWENTY_FIVE = process.env.PUBLIC_URL + "img/25.png";
    static PROFILE_PICTURE = process.env.PUBLIC_URL + "img/profile.jpg";
}

export class AppRoutes {
    static LISTS = "/lists";
    static HOME = "/";
    static BLOG = "/blog";
    static CONTACT = "/contact";
    static WORK = "/work";
}

export const RESUME_URL = process.env.PUBLIC_URL + "/PrashantChaubey_resume.pdf";
export const RECAPTCHA_KEY = "6LeWD7kZAAAAADuHZHoxZ8gcJ-Fzxkbugddnms60";

const DEV_API_URL = "http://localhost:8080/api/v1/";
const PROD_API_URL = "";
export const API_URL = process.env.NODE_ENV === "development" ? DEV_API_URL : PROD_API_URL;