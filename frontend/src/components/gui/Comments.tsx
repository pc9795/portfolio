import React, {Fragment, useContext, useReducer} from 'react';
import CommentCreator from "./CommentCreator";
import {useMountEffect} from "../../utils/hooks";
import CommentClient from "../../data/commentClient";
import Comment from "../../models/comment";
import {BlogPostPageContext} from "../pages/BlogPostPage";
import CommentUI from "./CommentUI";
import UserCommentReaction from "../../models/userCommentReaction";
import {
    AppReducerAction,
    CommentPayload,
    CommentsPayload,
    CommentsReducerAction,
    CommentsState,
    ServerError,
    UserCommentReactionsPayload
} from "../../react-app-env";
import {AppContext, AppReducerActionType} from "../../App";
import {AlarmType} from "./Alarm";
import {AxiosError} from "axios";
import Logger from "../../utils/logger";

export const CommentsContext = React.createContext({}as{ commentsState: CommentsState, dispatch: Function });

export enum CommentsReducerActionType {
    ADD_COMMENT = "add_comment",
    UPDATE_COMMENT = "update_comment",
    DELETE_COMMENT = "delete_comment",
    UPVOTE = "up_vote",
    REMOVE_UPVOTE = "remove_up_vote",
    DOWNVOTE = "down_vote",
    REMOVE_DOWNVOTE = "remove_down_vote",
    SET_COMMENTS = "set_comments",
    SET_USER_COMMENT_REACTIONS = "set_user_reactions",
}

function Comments() {
    const commentsInitialState: CommentsState = {
        comments: [],
        userCommentReactions: []
    };

    const commentsReducer = (state: CommentsState, action: CommentsReducerAction) => {
        switch (action.type) {
            case CommentsReducerActionType.SET_COMMENTS:
                return {...state, comments: (action.payload as CommentsPayload).data};
            case CommentsReducerActionType.SET_USER_COMMENT_REACTIONS:
                return {...state, userCommentReactions: (action.payload as UserCommentReactionsPayload).data};
            case CommentsReducerActionType.ADD_COMMENT:
                return {...state, comments: [(action.payload as CommentPayload).data, ...state.comments]};
            case CommentsReducerActionType.DELETE_COMMENT:
                return {
                    ...state,
                    comments: state.comments.filter(comment => comment.id !== (action.payload as CommentPayload).data.id)
                };
            case CommentsReducerActionType.UPDATE_COMMENT:
                return {
                    ...state,
                    comments: state.comments.map(comment => {
                        return comment.id === (action.payload as CommentPayload).data.id ? (action.payload as CommentPayload).data : comment;
                    })
                };
            case CommentsReducerActionType.UPVOTE:
            case CommentsReducerActionType.REMOVE_UPVOTE:
            case CommentsReducerActionType.DOWNVOTE:
            case CommentsReducerActionType.REMOVE_DOWNVOTE:
            default:
                return state;
        }
    };

    const [commentsState, dispatch] = useReducer(commentsReducer, commentsInitialState);
    const {blogPost} = useContext(BlogPostPageContext);
    const {dispatch: dispatchApp} = useContext(AppContext);

    useMountEffect(() => {
        CommentClient.getAllComments(blogPost.id).then((data: Comment[]) => dispatch({
            type: CommentsReducerActionType.SET_COMMENTS,
            payload: {data}
        } as CommentsReducerAction)).catch((error: AxiosError) => {
            Logger.log("Error while getting all comments", error);
            dispatchApp({
                type: AppReducerActionType.SET_ALARM,
                payload: {
                    message: error.response ? (error.response.data as ServerError).error.message : "Something bad happened",
                    type: AlarmType.ERROR
                }
            } as AppReducerAction);
        });
        CommentClient.getAllReactions(blogPost.id).then((data: UserCommentReaction[]) => dispatch({
            type: CommentsReducerActionType.SET_USER_COMMENT_REACTIONS,
            payload: {data}
        }as CommentsReducerAction)).catch((error: AxiosError) => {
            Logger.log("Error while getting all reactions", error);
            dispatchApp({
                type: AppReducerActionType.SET_ALARM,
                payload: {
                    message: error.response ? (error.response.data as ServerError).error.message : "Something bad happened",
                    type: AlarmType.ERROR
                }
            } as AppReducerAction);
        });
    });

    const renderComments = () => {
        const userCommentReactionMap = new Map<number, UserCommentReaction>();
        commentsState.userCommentReactions.forEach((userCommentReaction) => {
            userCommentReactionMap.set(userCommentReaction.commentId, userCommentReaction);
        });

        return commentsState.comments.map(comment => {
            const reaction = userCommentReactionMap.get(comment.id);
            if (reaction) {
                return <CommentUI key={comment.id} comment={comment} reaction={reaction.type}/>
            }
            return <CommentUI key={comment.id} comment={comment}/>
        });
    };

    return <CommentsContext.Provider value={{commentsState, dispatch}}>
        <CommentCreator/>
        <div className="mt-3"/>
        {renderComments()}
    </CommentsContext.Provider>
}

export default Comments;