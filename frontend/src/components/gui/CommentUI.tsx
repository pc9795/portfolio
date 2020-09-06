import React from 'react';
import PropTypes from 'prop-types';
import Comment from "../../models/comment";
import {ImageConstants} from "../../utils/constants";

function CommentUI(props: any) {
    const comment = props.comment as Comment;

    return <div className="row">
        <div className="col-2 col-sm-1">
            <img src={comment.commenterImageUrl ? comment.commenterImageUrl : ImageConstants.AVATAR} height="50"
                 width="50" alt="Default Avatar"/>
            <small>{comment.commenterName}</small>
        </div>
        <div className="col-10 col-sm-6">
            <small>
                created on {comment.createdAt}
            </small>
            <div>{comment.message}</div>
            <small>{`up-votes: ${comment.upVotes} down-votes: ${comment.downVotes}`}</small>
        </div>
    </div>
}

CommentUI.propTypes = {
    // Not using a `instanceOf(Comment)` because of chrome warning
    comment: PropTypes.object.isRequired
};

export default CommentUI;