import React, {ReactElement, useReducer} from "react";
import {Route, Switch} from "react-router-dom";
import SunshinePage from "./components/pages/SunshinePage";
import Header from "./components/Header";
import Footer from "./components/Footer";
import ListsPage from "./components/pages/ListsPage";
import BlogPostPage from "./components/pages/BlogPostPage";
import OAuth2RedirectHandler from "./components/OAuth2RedirectHandler";
import {AppRoutes} from "./utils/constants";
import BlogPage from "./components/pages/BlogPage";
import ContactPage from "./components/pages/ContactPage";
import HomePage from "./components/pages/HomePage";
import WorkPage from "./components/pages/WorkPage";
import NotFound from "./components/pages/NotFound";
import Alarm, {AlarmType} from "./components/gui/Alarm";
import TokenManager from "./utils/tokenManager";
import {AlarmPayload, AppReducerAction, AppState, StringPayload, UserPayload} from "./react-app-env";
import UsersClient from "./data/userClient";
import User from "./models/user";
import {AxiosError} from "axios";
import {useMountEffect} from "./utils/hooks";

export const AppContext = React.createContext({} as { appState: AppState, dispatch: Function });

export enum AppReducerActionType {
    SET_ALARM = "set_alarm",
    AUTHENTICATE = "authenticate",
    LOGOUT = "logout",
    REMOVE_ALARM = "remove_alarm",
    SET_USER = "set_user"
}

function App() {
    const appInitialState: AppState = {
        currUser: null,
        alarmMap: new Map()
    };

    const appReducer = (state: AppState, action: AppReducerAction): AppState => {
        switch (action.type) {
            case AppReducerActionType.SET_ALARM:
                let additionMap = new Map(state.alarmMap);
                additionMap.set((action.payload as AlarmPayload).message, <Alarm
                    key={(action.payload as AlarmPayload).message}
                    type={(action.payload as AlarmPayload).type}
                    message={(action.payload as AlarmPayload).message}/>);
                return {...state, alarmMap: additionMap};
            case AppReducerActionType.REMOVE_ALARM:
                let deletionMap = new Map(state.alarmMap);
                deletionMap.delete((action.payload as StringPayload).data);
                return {...state, alarmMap: deletionMap};
            case AppReducerActionType.AUTHENTICATE:
                TokenManager.setAccessToken((action.payload as StringPayload).data);
                return state;
            case AppReducerActionType.LOGOUT:
                TokenManager.removeAccessToken();
                return {...state, currUser: null};
            case AppReducerActionType.SET_USER:
                return {...state, currUser: (action.payload as UserPayload).data};
            default:
                return state;
        }
    };

    const [appState, dispatch] = useReducer(appReducer, appInitialState);

    const renderAlarms = () => {
        const alarms: any = [];
        appState.alarmMap.forEach((value: ReactElement) => alarms.push(value));

        return alarms;
    };

    useMountEffect(() => {
        if (TokenManager.hasAccessToken()) {
            getCurrentUser();
        }
    });

    const getCurrentUser = () => {
        UsersClient.getCurrentUser().then((data: User) => dispatch({
            type: AppReducerActionType.SET_USER,
            payload: {data}
        }as AppReducerAction)).catch((e: AxiosError) => {
            if (e.response && e.response.status === 401) {
                dispatch({
                    type: AppReducerActionType.SET_ALARM,
                    payload: {type: AlarmType.ERROR, message: "Unable to sign in automatically! Please sign-in again"}
                }as AppReducerAction);
            } else {
                dispatch({
                    type: AppReducerActionType.SET_ALARM,
                    payload: {
                        type: AlarmType.ERROR,
                        message: "Something is not working correctly! Please try after sometime"
                    }
                }as AppReducerAction);
            }
        })
    };

    return <Switch>
        <Route exact path="/sunshine" component={SunshinePage}/>
        <AppContext.Provider value={{appState, dispatch}}>
            <Route path="/">
                <Header/>
                <div className="container mt-3"> {renderAlarms()}</div>
                <Switch>
                    <Route exact path={AppRoutes.HOME} component={HomePage}/>
                    <Route exact path={AppRoutes.BLOG} component={BlogPage}/>
                    <Route exact path={AppRoutes.WORK} component={WorkPage}/>
                    <Route exact path={AppRoutes.LISTS} component={ListsPage}/>
                    <Route exact path={AppRoutes.CONTACT} component={ContactPage}/>
                    <Route exact path={AppRoutes.BLOG + "/:name"} component={BlogPostPage}/>
                    <Route exact path={AppRoutes.OAUTH2_REDIRECT} component={OAuth2RedirectHandler}/>
                    <Route component={NotFound}/>
                </Switch>
                <Footer/>
            </Route>
        </AppContext.Provider>
    </Switch>
}

export default App;