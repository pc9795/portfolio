import React from 'react';
import Comment from "./Comment";
import CommentCreator from "./CommentCreator";

function Comments() {
    return <div>
        <CommentCreator/>
        <Comment/>
        <Comment/>
        <Comment/>
    </div>
}

export default Comments;