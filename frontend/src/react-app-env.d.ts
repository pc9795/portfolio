/// <reference types="react-scripts" />

import Alarm from "./components/gui/Alarm";
import {AppReducerActionType} from "./App";
import User from "./models/user";

interface Page<T> {
    content: T[]
}

interface ServerError {
    error: ServerErrorInfo
}

interface ServerErrorInfo {
    code: string,
    message: string
}

declare interface AppReducerAction {
    payload?: StringPayload | AlarmPayload,
    type: AppReducerActionType
}

declare interface StringPayload {
    data: string
}

declare interface AlarmPayload {
    message: string
    type: Alarm.Type
}

declare interface AppState {
    currUser: null | User,
    alarmMap: Map
}