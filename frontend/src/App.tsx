import React, {useReducer} from "react";
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
import Alarm from "./components/gui/Alarm";
import TokenManager from "./utils/tokenManager";

export const AppContext = React.createContext(undefined as any);

export enum AppReducerActionType {
    SET_ALARM = "set_alarm",
    AUTHENTICATE = "authenticate",
    LOGOUT = "logout"
}

const appInitialState = {
    alarmMessage: "",
    alarmType: Alarm.Type.INFO,
    authenticated: TokenManager.hasAccessToken()
};

function appReducer(state: any, action: AppReducerAction): any {
    switch (action.type) {
        case AppReducerActionType.SET_ALARM:
            return {...state, alarmMessage: action.payload.message, alarmType: action.payload.type};
        case AppReducerActionType.AUTHENTICATE:
            const accessToken = action.payload;
            TokenManager.setAccessToken(accessToken);
            return {...state, authenticated: true};
        case AppReducerActionType.LOGOUT:
            TokenManager.removeAccessToken();
            return {...state, authenticated: false};
        default:
            return state;
    }
}

function App() {
    const [appState, dispatch] = useReducer(appReducer, appInitialState);

    const renderAlarm = () => {
        if (!appState.alarmMessage) {
            return;
        }
        return <Alarm message={appState.alarmMessage} type={appState.alarmType}/>
    };

    return <Switch>
        <Route exact path="/sunshine" component={SunshinePage}/>
        <AppContext.Provider value={{appState, dispatch}}>
            <Route path="/">
                <Header/>
                {renderAlarm()}
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