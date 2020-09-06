import React from 'react';
import PropTypes from 'prop-types';
import Comment from "../../models/comment";
import {ImageConstants} from "../../utils/constants";

function CommentUI(props: any) {
    const comment = props.comment as Comment;

    const getCreatedAtText = (createdAt: string) => {
        try {
            // for + see: https://github.com/microsoft/TypeScript/issues/5710
            const createdAtObj = +new Date(createdAt);
            const currDate = +new Date();
            const diffTime = currDate - createdAtObj;
            if (diffTime < 1000) {
                return "just now";
            }
            if (diffTime < 1000 * 60) {
                return `${Math.round(diffTime / 1000)} seconds ago`;
            }
            if (diffTime < 1000 * 60 * 60) {
                return `${Math.round(diffTime / (1000 * 60))} minutes ago`;
            }
            if (diffTime < 1000 * 60 * 60 * 24) {
                return `${Math.round(diffTime / (1000 * 60 * 60))} hours ago`;
            }
            if (diffTime < 1000 * 60 * 60 * 24 * 365) {
                return `${Math.round(diffTime / (1000 * 60 * 60 * 24))} days ago`;
            }
            return `${Math.round(diffTime / (1000 * 60 * 60 * 24 * 365))} years ago`;
        } catch (e) {
            //todo make configurable according to environment or use a custom logger
            console.log(e);
            //we don't want to crash the page due to silly date conversions.
            return "";
        }
    };

    return <div className="row">
        <div className="col-2 col-sm-1">
            <img src={comment.commenterImageUrl ? comment.commenterImageUrl : ImageConstants.AVATAR} height="50"
                 width="50" alt="Default Avatar"/>
            <small>{comment.commenterName}</small>
        </div>
        <div className="col-10 col-sm-6">
            <small>
                created {getCreatedAtText(comment.createdAt)}
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