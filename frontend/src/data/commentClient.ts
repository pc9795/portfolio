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
        const url = new URL(`${RESOURCE_URL}/reactions`);
        url.searchParams.append('blog_post_id', blogPostId.toString());
        const res = await axios.get(url.href, ApiClientUtils.getConfig());

        return res.data;
    }

    static async deleteComment(id: number) {
        const res = await axios.delete(`${RESOURCE_URL}/${id}`, ApiClientUtils.getConfig());

        return res.data;
    }

    static async upvoteComment(id: number): Promise<Comment> {
        const res = await axios.patch(`${RESOURCE_URL}/${id}/up_vote`, {}, ApiClientUtils.getConfig());

        return res.data;
    }

    static async removeUpvoteComment(id: number): Promise<Comment> {
        const res = await axios.patch(`${RESOURCE_URL}/${id}/up_vote/remove`, {}, ApiClientUtils.getConfig());

        return res.data;
    }

    static async downvoteComment(id: number): Promise<Comment> {
        const res = await axios.patch(`${RESOURCE_URL}/${id}/down_vote`, {}, ApiClientUtils.getConfig());

        return res.data;
    }

    static async removeDownvoteComment(id: number): Promise<Comment> {
        const res = await axios.patch(`${RESOURCE_URL}/${id}/down_vote/remove`, {}, ApiClientUtils.getConfig());

        return res.data;
    }

}