import React, {useContext} from "react";
import {FaviconConstants} from "../utils/constants";
import {Redirect} from "react-router";
import {Helmet} from "react-helmet";
import {AppContext, AppReducerActionType} from "../App";
import {useMountEffect} from "../utils/hooks";
import {AlarmType} from "./gui/Alarm";
import {AppReducerAction} from "../react-app-env";

function OAuth2RedirectHandler(props: any) {
    const {dispatch} = useContext(AppContext);
    const params = new URLSearchParams(props.location.search);
    const token = params.get('token');
    const error = params.get('error');

    useMountEffect(() => {
        if (token) {
            dispatch({type: AppReducerActionType.AUTHENTICATE, payload: {data: token}} as AppReducerAction)
        } else if (error) {
            dispatch({
                type: AppReducerActionType.SET_ALARM,
                payload: {message: error, type: AlarmType.ERROR}
            } as AppReducerAction);
        }
    });

    const renderHead = () => {
        return <Helmet>
            <title>Prashant Chaubey - Home</title>
            <link rel="icon" type="image/png" href={FaviconConstants.URL} sizes="16x16"/>
        </Helmet>;
    };

    return <div className="container">
        {renderHead()}
        <Redirect to={{pathname: "/"}}/>;
    </div>
}

export default OAuth2RedirectHandler;