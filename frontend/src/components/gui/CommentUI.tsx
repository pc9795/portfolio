import React, {useContext} from 'react';
import PropTypes from 'prop-types';
import Comment from "../../models/comment";
import {ImageConstants} from "../../utils/constants";
import Logger from "../../utils/logger";
import CommentClient from "../../data/commentClient";
import {AppContext, AppReducerActionType} from "../../App";
import {AlarmType} from "./Alarm";
import {AxiosError} from "axios";
import {CommentsContext, CommentsReducerActionType, DOWN_VOTE, UP_VOTE} from "./Comments";
import Confirm from "./Confirm";

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
        return <button
            className={`btn btn-sm btn-link p-0 text-decoration-none ${props.reaction && props.reaction === UP_VOTE ? 'text-primary' : 'text-secondary'}`}
            onClick={() => {
                handleUpVote()
            }}>
            <i className="fa fa-thumbs-o-up"/>&nbsp;{comment.upVotes}
        </button>
    };

    const handleUpVote = () => {
        (document.activeElement as HTMLElement).blur();
        let promise;
        if (props.reaction) {
            if (props.reaction === DOWN_VOTE) {
                promise = CommentClient.removeDownvoteComment(comment.id).then((updatedComment: Comment) => {
                    dispatchComments({
                        type: CommentsReducerActionType.REMOVE_REACTION,
                        payload: {data: updatedComment}
                    }as CommentsReducerAction);

                    CommentClient.upvoteComment(comment.id).then((updatedComment: Comment) => {
                        dispatchComments({
                            type: CommentsReducerActionType.UP_VOTE,
                            payload: {data: updatedComment}
                        }as CommentsReducerAction);
                    });
                });
            } else if (props.reaction === UP_VOTE) {
                promise = CommentClient.removeUpvoteComment(comment.id).then((updatedComment: Comment) => {
                    dispatchComments({
                        type: CommentsReducerActionType.REMOVE_REACTION,
                        payload: {data: updatedComment}
                    }as CommentsReducerAction);
                });
            }
        } else {
            promise = CommentClient.upvoteComment(comment.id).then((updatedComment: Comment) => {
                dispatchComments({
                    type: CommentsReducerActionType.UP_VOTE,
                    payload: {data: updatedComment}
                }as CommentsReducerAction);
            });
        }
        if (!promise) {
            Logger.log("Promise is not initialized while handling up-vote", props.reaction);
            return;
        }
        promise.catch((error: AxiosError) => {
            const message = error.response ? (error.response.data as ServerError).error.message : "Something bad happened";
            Logger.log("Error while up-voting comment", error);
            dispatchApp({
                type: AppReducerActionType.SET_ALARM,
                payload: {
                    message,
                    type: AlarmType.ERROR
                }
            } as AppReducerAction)
        });
    };

    const renderDownVoteOption = () => {
        return <button
            className={`btn btn-sm btn-link p-0 text-decoration-none ${props.reaction && props.reaction === DOWN_VOTE ? 'text-danger' : 'text-secondary'}`}
            onClick={() => {
                handleDownVote()
            }}>
            <i className="fa fa-thumbs-o-down"/>&nbsp;{comment.downVotes}
        </button>
    };

    const handleDownVote = () => {
        (document.activeElement as HTMLElement).blur();
        let promise;
        if (props.reaction) {
            if (props.reaction === UP_VOTE) {
                promise = CommentClient.removeUpvoteComment(comment.id).then((updatedComment: Comment) => {
                    dispatchComments({
                        type: CommentsReducerActionType.REMOVE_REACTION,
                        payload: {data: updatedComment}
                    }as CommentsReducerAction);
                    CommentClient.downvoteComment(comment.id).then((updatedComment: Comment) => {
                        dispatchComments({
                            type: CommentsReducerActionType.DOWN_VOTE,
                            payload: {data: updatedComment}
                        }as CommentsReducerAction);
                    });
                });
            } else if (props.reaction === DOWN_VOTE) {
                promise = CommentClient.removeDownvoteComment(comment.id).then((updatedComment: Comment) => {
                    dispatchComments({
                        type: CommentsReducerActionType.REMOVE_REACTION,
                        payload: {data: updatedComment}
                    }as CommentsReducerAction);
                });
            }
        } else {
            promise = CommentClient.downvoteComment(comment.id).then((updatedComment: Comment) => {
                dispatchComments({
                    type: CommentsReducerActionType.DOWN_VOTE,
                    payload: {data: updatedComment}
                }as CommentsReducerAction);
            });
        }
        if (!promise) {
            Logger.log("Promise is not initialized while handling down-vote", props.reaction);
            return;
        }
        promise.catch((error: AxiosError) => {
            const message = error.response ? (error.response.data as ServerError).error.message : "Something bad happened";
            Logger.log("Error while down-voting comment", error);
            dispatchApp({
                type: AppReducerActionType.SET_ALARM,
                payload: {
                    message,
                    type: AlarmType.ERROR
                }
            } as AppReducerAction)
        });
    };

    const renderUserOptions = () => {
        if (!comment.createdByRequester) {
            return null;
        }
        return <Confirm title={"Confirm delete"} body={"Do you want to DELETE this comment?"} confirmText={"Delete"}
                        onClick={handleDelete}
                        childBtnBSClassName={"btn btn-sm btn-link text-secondary p-0 text-sm-left"}
                        childBtnText="delete"/>
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