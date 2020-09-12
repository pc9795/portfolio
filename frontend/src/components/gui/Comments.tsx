import React, {useContext, useReducer} from 'react';
import CommentCreator from "./CommentCreator";
import {useMountEffect} from "../../utils/hooks";
import CommentClient from "../../data/commentClient";
import Comment from "../../models/comment";
import {BlogPostPageContext} from "../pages/BlogPostPage";
import CommentUI from "./CommentUI";
import UserCommentReaction from "../../models/userCommentReaction";
import {AppContext, AppReducerActionType} from "../../App";
import {AlarmType} from "./Alarm";
import {AxiosError} from "axios";
import Logger from "../../utils/logger";

export const UP_VOTE = "UP_VOTE";
export const DOWN_VOTE = "DOWN_VOTE";

export const CommentsContext = React.createContext({}as{ commentsState: CommentsState, dispatch: Function });

export enum CommentsReducerActionType {
    SET_COMMENTS = "set_comments",
    SET_USER_COMMENT_REACTIONS = "set_user_reactions",
    ADD_COMMENT = "add_comment",
    DELETE_COMMENT = "delete_comment",
    UP_VOTE = "up_vote",
    DOWN_VOTE = "down_vote",
    REMOVE_REACTION = "remove_reaction",
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
            case CommentsReducerActionType.UP_VOTE:
                return {
                    ...state,
                    comments: state.comments.map(comment => {
                        return comment.id === (action.payload as CommentPayload).data.id ? (action.payload as CommentPayload).data : comment;
                    }),
                    userCommentReactions: [...state.userCommentReactions, {
                        commentId: (action.payload as CommentPayload).data.id,
                        type: UP_VOTE
                    }]
                };
            case CommentsReducerActionType.DOWN_VOTE:
                return {
                    ...state,
                    comments: state.comments.map(comment => {
                        return comment.id === (action.payload as CommentPayload).data.id ? (action.payload as CommentPayload).data : comment;
                    }),
                    userCommentReactions: [...state.userCommentReactions, {
                        commentId: (action.payload as CommentPayload).data.id,
                        type: DOWN_VOTE
                    }]
                };
            case CommentsReducerActionType.REMOVE_REACTION:
                return {
                    ...state,
                    comments: state.comments.map(comment => {
                        return comment.id === (action.payload as CommentPayload).data.id ? (action.payload as CommentPayload).data : comment;
                    }),
                    userCommentReactions: state.userCommentReactions.filter(userCommentReaction =>
                        userCommentReaction.commentId !== (action.payload as CommentPayload).data.id)
                };
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