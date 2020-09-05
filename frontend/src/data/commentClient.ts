import axios from 'axios';
import ApiClientUtils from "../utils/apiClientUtils";

const RESOURCE_URL = process.env.REACT_APP_API_BASE_URL + "/v1/comments";

export default class CommentClient {
    static async createComment(message: string, blogPostId: number) {
        const res = await axios.post(RESOURCE_URL, {message, blogPostId}, ApiClientUtils.getConfig());

        return res.data;
    }
}