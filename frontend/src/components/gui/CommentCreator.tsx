import React, {SyntheticEvent, useContext, useState} from 'react';
import {AppContext, AppReducerActionType} from "../../App";
import {AppRoutes, COMMENT_CHARS_MAX_LIMIT, COMMENT_CHARS_MIN_LIMIT, ImageConstants} from "../../utils/constants";
import {BlogPostPageContext} from "../pages/BlogPostPage";
import CommentClient from "../../data/commentClient";
import {AxiosError} from "axios";
import {AlarmType} from "./Alarm";
import {AppReducerAction, ServerError} from "../../react-app-env";

function CommentCreator() {
    const {appState, dispatch} = useContext(AppContext);
    const {blogPost} = useContext(BlogPostPageContext);
    const [message, setMessage] = useState("");
    const [messageCharsCount, setMessageCharsCount] = useState(0);

    const renderTextArea = () => {
        if (!appState.currUser) {
            return renderLoginButton();
        }

        return <form className="row" onSubmit={handleSubmit}>
            <div className="col-2 col-sm-1">
                <img src={ImageConstants.AVATAR} height="50" width="50" alt="Default Avatar"/>
            </div>
            <div className="col-10 col-sm-6">
                <div className="form-group">
                <textarea className="form-control" rows={4} placeholder="Join the discussion..." value={message}
                          onChange={(event => {
                                  setMessage(event.target.value);
                                  setMessageCharsCount(event.target.value.length);
                              }
                          )}/>
                    <small className="form-text text-muted">
                        {renderCommentHelpText()}
                    </small>
                    <button type="submit"
                            disabled={messageCharsCount > COMMENT_CHARS_MAX_LIMIT || messageCharsCount < COMMENT_CHARS_MIN_LIMIT}
                            className="btn btn-secondary float-right">Comment
                    </button>
                </div>
            </div>
        </form>
    };

    const renderLoginButton = () => {
        return <span>
                <span style={{fontSize: '1.3em'}}>Please&nbsp;</span>
                <a href={AppRoutes.GOOGLE_AUTH_URL} className="btn btn-outline-secondary">
                    <img src={ImageConstants.GOOGLE_LOGO} height="25" width="25" alt="Google"/> Log In
                </a>
                <span style={{fontSize: '1.3em'}}>&nbsp;to post a comment</span>
            </span>
    };

    const renderCommentHelpText = () => {
        if (messageCharsCount === 0) {
            return `enter at least ${COMMENT_CHARS_MIN_LIMIT} characters`;
        }
        if (messageCharsCount < COMMENT_CHARS_MIN_LIMIT) {
            return `${COMMENT_CHARS_MIN_LIMIT - messageCharsCount} more to go...`
        }
        if (messageCharsCount > COMMENT_CHARS_MAX_LIMIT) {
            return <span
                className="text-danger">too long by {messageCharsCount - COMMENT_CHARS_MAX_LIMIT} characters</span>;
        }
        return `${COMMENT_CHARS_MAX_LIMIT - messageCharsCount} characters left`
    };

    const handleSubmit = (event: SyntheticEvent) => {
        (document.activeElement as HTMLElement).blur();
        event.preventDefault();

        CommentClient.createComment(message, blogPost.id).then(() => {
            dispatch({
                type: AppReducerActionType.SET_ALARM,
                payload: {message: "Comment posted!", type: AlarmType.SUCCESS}
            } as AppReducerAction);
            setMessage("");
            setMessageCharsCount(0);
        }).catch((error: AxiosError) => {
            dispatch({
                type: AppReducerActionType.SET_ALARM,
                payload: {
                    message: error.response ? (error.response.data as ServerError).error.message : "Something bad happened",
                    type: AlarmType.ERROR
                }
            } as AppReducerAction)
        });
    };

    return renderTextArea();
}

export default CommentCreator;