import axios from 'axios';
import ApiClientUtils from "../utils/apiClientUtils";
import Comment from "../models/comment";
import UserCommentReaction from "../models/userCommentReaction";

const RESOURCE_URL = process.env.REACT_APP_API_BASE_URL + "/v1/comments";

export default class CommentClient {
    static async createComment(message: string, blogPostId: number): Promise<Comment> {
        const res = await axios.post(RESOURCE_URL, {message, blogPostId}, ApiClientUtils.getConfig());

        return res.data;
    }

    static async getAllComments(blogPostId: number): Promise<Comment[]> {
        const url = new URL(RESOURCE_URL);
        url.searchParams.append('blog_post_id', blogPostId.toString());
        const res = await axios.get(url.href, ApiClientUtils.getConfig());

        return res.data;
    }

    static async getAllReactions(blogPostId: number): Promise<UserCommentReaction[]> {
        const url = new URL(RESOURCE_URL);
        url.searchParams.append('blog_post_id', blogPostId.toString());
        const res = await axios.get(url.href, ApiClientUtils.getConfig());

        return res.data;
    }

    static async updateComment(id: number, message: string): Promise<Comment> {
        const res = await axios.put(`${RESOURCE_URL}/${id}`, {message}, ApiClientUtils.getConfig());

        return res.data;
    }

    static async deleteComment(id: number, message: string) {
        const res = await axios.delete(`${RESOURCE_URL}/${id}`, ApiClientUtils.getConfig());

        return res.data;
    }
}