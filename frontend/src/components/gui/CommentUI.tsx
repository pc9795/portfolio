import React, {Fragment, useContext} from 'react';
import PropTypes from 'prop-types';
import Comment from "../../models/comment";
import {ImageConstants} from "../../utils/constants";
import Logger from "../../utils/logger";
import CommentClient from "../../data/commentClient";
import {AppContext, AppReducerActionType} from "../../App";
import {AlarmType} from "./Alarm";
import {AxiosError} from "axios";
import {CommentsContext, CommentsReducerActionType} from "./Comments";

const UP_VOTE = "UP_VOTE";
const DOWN_VOTE = "DOWN_VOTE";

function CommentUI(props: any) {
    const comment = props.comment as Comment;
    const {dispatch: dispatchApp} = useContext(AppContext);
    const {dispatch: dispatchComments} = useContext(CommentsContext);

    const getCreatedAtText = (createdAt: string) => {
        try {
            // for '+' see: https://github.com/microsoft/TypeScript/issues/5710
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
            Logger.log("Error while creating 'created at' text for a comment", e);
            return ""; //we don't want to crash the page due to silly date conversions.
        }
    };

    const renderUpVoteOption = () => {
        if (props.reaction && props.reaction === UP_VOTE) {
            return <button style={{textDecoration: 'none', color: 'blue'}} onClick={() => {
                handleUpVote()
            }}>
                <i className="fa fa-thumbs-o-up"/>&nbsp;{comment.upVotes}
            </button>
        }
        return <Fragment> <i className="fa fa-thumbs-o-up"/>&nbsp;{comment.upVotes}</Fragment>
    };

    const handleUpVote = () => {
        //todo implement
    };

    const renderDownVoteOption = () => {
        if (props.reaction && props.reaction === DOWN_VOTE) {
            return <button style={{textDecoration: 'none', color: 'red'}} onClick={() => {
                handleDownVote()
            }}>
                <i className="fa fa-thumbs-o-down"/>&nbsp;{comment.downVotes}
            </button>
        }
        return <Fragment> <i className="fa fa-thumbs-o-down"/>&nbsp;{comment.downVotes}</Fragment>
    };

    const handleDownVote = () => {
        //todo implement
    };

    const renderUserOptions = () => {
        if (!comment.createdByRequester) {
            return null;
        }
        return <Fragment>
            <button className="btn btn-sm btn-link text-secondary p-0 text-sm-left" onClick={() => {
                handleUpdate()
            }}>edit
            </button>
            &nbsp;
            <button className="btn btn-sm btn-link text-secondary p-0 text-sm-left" onClick={() => {
                handleDelete()
            }}>delete
            </button>
        </Fragment>
    };

    const handleDelete = () => {
        CommentClient.deleteComment(comment.id).then(() => {
            dispatchComments({
                type: CommentsReducerActionType.DELETE_COMMENT,
                payload: {data: comment}
            }as CommentsReducerAction)
        }).catch((error: AxiosError) => {
            const message = error.response ? (error.response.data as ServerError).error.message : "Something bad happened";
            Logger.log("Error while creating comment", error);
            dispatchApp({
                type: AppReducerActionType.SET_ALARM,
                payload: {
                    message,
                    type: AlarmType.ERROR
                }
            } as AppReducerAction)
        });
    };

    const handleUpdate = () => {
        //todo implement
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
            <small>
                {renderUpVoteOption()}
                &nbsp;
                {renderDownVoteOption()}
                &nbsp;
                {renderUserOptions()}
            </small>
        </div>
    </div>
}

CommentUI.propTypes = {
    // Not using a `instanceOf(Comment)` because of chrome warning
    comment: PropTypes.object.isRequired,
    reaction: PropTypes.string
}
;

export default CommentUI;