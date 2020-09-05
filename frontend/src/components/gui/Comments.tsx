import React, {useContext, useState, Fragment} from 'react';
import CommentCreator from "./CommentCreator";
import {useMountEffect} from "../../utils/hooks";
import CommentClient from "../../data/commentClient";
import Comment from "../../models/comment";
import {BlogPostPageContext} from "../pages/BlogPostPage";
import CommentUI from "./CommentUI";

function Comments() {
    const {blogPost} = useContext(BlogPostPageContext);
    const [comments, setComments] = useState([]as Comment[]);

    useMountEffect(() => {
        CommentClient.getAllComments(blogPost.id).then((data: Comment[]) => setComments(data));
    });


    const renderComments = () => {
        return comments.map(comment => <CommentUI comment={comment}/>);
    };

    return <Fragment>
        <CommentCreator/>
        {renderComments()}
    </Fragment>
}

export default Comments;