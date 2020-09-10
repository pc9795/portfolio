/// <reference types="react-scripts" />

import {AlarmType} from "./components/gui/Alarm";
import {AppReducerActionType} from "./App";
import User from "./models/user";
import UserCommentReaction from "./models/userCommentReaction";
import {CommentsReducerActionType} from "./components/gui/Comments";
import Comment from "./models/comment";

// todo remove imports so that these types don't need an explicit import
// todo one possible solution: https://stackoverflow.com/questions/39040108/import-class-in-definition-file-d-ts

interface Page<T> {
    content: T[]
}

interface ServerError {
    error: { code: string, message: string }
}

declare interface AppReducerAction {
    payload?: StringPayload | UserPayload | AlarmPayload,
    type: AppReducerActionType
}

declare interface StringPayload {
    data: string
}

declare interface UserPayload {
    data: User
}

declare interface AlarmPayload {
    message: string
    type: AlarmType
}

declare interface AppState {
    currUser: null | User,
    alarmMap: Map
}

declare interface CommentsState {
    comments: Comment[],
    userCommentReactions: UserCommentReaction[]
}

declare interface CommentsReducerAction {
    payload?: CommentsPayload | UserCommentReactionsPayload | CommentPayload,
    type: CommentsReducerActionType
}

declare interface CommentsPayload {
    data: Comment[]
}

declare interface UserCommentReactionsPayload {
    data: UserCommentReaction[]
}

declare interface CommentPayload {
    data: Comment
}

declare interface UserCommentReactionPayload {
    data: UserCommentReaction
}