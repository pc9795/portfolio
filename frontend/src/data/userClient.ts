import axios from 'axios';
import User from "../models/user";
import ApiClientUtils from "../utils/apiClientUtils";

const RESOURCE_URL = process.env.REACT_APP_API_BASE_URL + "/v1/users";

export default class UsersClient {
    static async getCurrentUser(): Promise<User> {
        const res = await axios.get(`${RESOURCE_URL}/me`, ApiClientUtils.getConfig());

        return res.data;
    }
}