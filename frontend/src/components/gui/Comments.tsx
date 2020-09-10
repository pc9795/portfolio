import React, {useContext, useState, Fragment} from 'react';
import CommentCreator from "./CommentCreator";
import {useMountEffect} from "../../utils/hooks";
import CommentClient from "../../data/commentClient";
import Comment from "../../models/comment";
import {BlogPostPageContext} from "../pages/BlogPostPage";
import CommentUI from "./CommentUI";
import UserCommentReaction from "../../models/userCommentReaction";

function Comments() {
    const {blogPost} = useContext(BlogPostPageContext);

    const [comments, setComments] = useState([]as Comment[]);
    const [userCommentReactions, setUserCommentReactions] = useState([]as UserCommentReaction[]);

    useMountEffect(() => {
        CommentClient.getAllComments(blogPost.id).then((data: Comment[]) => setComments(data));
        CommentClient.getAllReactions(blogPost.id).then((data: UserCommentReaction[]) => setUserCommentReactions(data));
    });

    const renderComments = () => {
        const userCommentReactionMap = new Map<number, UserCommentReaction>();
        userCommentReactions.forEach((userCommentReaction) => {
            userCommentReactionMap.set(userCommentReaction.commentId, userCommentReaction);
        });

        return comments.map(comment => {
            const reaction = userCommentReactionMap.get(comment.id);
            if (reaction) {
                return <CommentUI key={comment.id} comment={comment} reaction={reaction.type}/>
            }
            return <CommentUI key={comment.id} comment={comment}/>
        });
    };

    return <Fragment>
        <CommentCreator/>
        <div className="mt-3"/>
        {renderComments()}
    </Fragment>
}

export default Comments;