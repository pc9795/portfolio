/// <reference types="react-scripts" />

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
    payload: any,
    type: ActionType
}