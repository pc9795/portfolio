import React, {useContext} from "react";
import {Link} from "react-router-dom";
import {AppRoutes, ImageConstants} from "../utils/constants";
import {AppContext, AppReducerActionType} from "../App";

function Header() {
    const {appState, dispatch} = useContext(AppContext);

    const renderUserArea = () => {
        if (appState.currUser) {
            return <div>
                <button className="btn btn-light" onClick={() => {
                    dispatch({type: AppReducerActionType.LOGOUT} as AppReducerAction)
                }}>Logout
                </button>
            </div>;

        }
        return <a href={AppRoutes.GOOGLE_AUTH_URL} className="btn btn-light">
            <img src={ImageConstants.GOOGLE_LOGO} height="25" width="25" alt="Google"/>
            Log In
        </a>
    };

    return <nav className="navbar navbar-expand-md navbar-dark bg-dark">
        <Link className="navbar-brand" to={AppRoutes.HOME}>Prashant Chaubey</Link>
        <button className="navbar-toggler" type="button" data-toggle="collapse"
                data-target="#navbarSupportedContent">
            <span className="navbar-toggler-icon"/>
        </button>

        <div className="collapse navbar-collapse" id="navbarSupportedContent">
            <ul className="navbar-nav mr-auto">
                <li className="nav-item">
                    <Link className="nav-link" to={AppRoutes.BLOG}>Blog</Link>
                </li>
                <li className="nav-item">
                    <Link className="nav-link" to={AppRoutes.WORK}>Work</Link>
                </li>
                <li className="nav-item">
                    <Link className="nav-link" to={AppRoutes.LISTS}>Lists</Link>
                </li>
                <li className="nav-item">
                    <Link className="nav-link" to={AppRoutes.CONTACT}>Contact</Link>
                </li>
            </ul>
        </div>
        <div>
            {renderUserArea()}
        </div>
    </nav>
}

export default Header;