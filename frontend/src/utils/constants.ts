export class FaviconConstants {
    static URL = process.env.REACT_APP_BASE_URL + "/favicon-16x16.png";
    static BIRTHDAY_URL = process.env.REACT_APP_BASE_URL + "/favicon-brithday-16x16.png";
}

export class ImageConstants {
    static CAKE = process.env.REACT_APP_BASE_URL + "/img/cake.png";
    static TWENTY_FIVE = process.env.REACT_APP_BASE_URL + "/img/25.png";
    static PROFILE_PICTURE = process.env.REACT_APP_BASE_URL + "/img/profile.jpg";
    static GOOGLE_LOGO = process.env.REACT_APP_BASE_URL + "/img/google-logo.png";
    static AVATAR = process.env.REACT_APP_BASE_URL + "/img/avatar.png";
}

export class AppRoutes {
    static LISTS = "/lists";
    static HOME = "/";
    static BLOG = "/blog";
    static CONTACT = "/contact";
    static WORK = "/work";
    static OAUTH2_REDIRECT = "/oauth2/redirect";
    static GOOGLE_AUTH_URL = `${process.env.REACT_APP_API_BASE_URL}/oauth2/authorize/google?redirect_uri=${process.env.REACT_APP_BASE_URL}${AppRoutes.OAUTH2_REDIRECT}`;
}

export const RESUME_URL = process.env.REACT_APP_BASE_URL + "/PrashantChaubey_resume.pdf";
export const RECAPTCHA_KEY = process.env.REACT_APP_RECAPTCHA_KEY as string;
export const ACCESS_TOKEN = "accessToken";
export const COMMENT_CHARS_MAX_LIMIT = 600;
export const COMMENT_CHARS_MIN_LIMIT = 15;