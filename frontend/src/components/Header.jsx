import React from "react";
import {BrowserRouter as Router, Link, Route, Switch} from "react-router-dom";
import Home from "./pages/Home";
import Blog from "./pages/Blog";
import Work from "./pages/Work";
import Lists from "./pages/Lists";
import Contact from "./pages/Contact";
import Sunshine from "./pages/Sunshine";
import {ReactRoutes} from "../utils/constants";

const styles = {
    headerDiv: {
        padding: '0 !important'
    }
};

export default class Header extends React.Component {
    render() {
        return <Router>
            <div style={styles.headerDiv} className="container">
                <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                    <Link className="navbar-brand" to={ReactRoutes.HOME}>Prashant Chaubey</Link>
                    <button className="navbar-toggler" type="button" data-toggle="collapse"
                            data-target="#navbarSupportedContent">
                        <span className="navbar-toggler-icon"/>
                    </button>

                    <div className="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul className="navbar-nav mr-auto">
                            <li className="nav-item">
                                <Link className="nav-link" to={ReactRoutes.BLOG}>Blog</Link>
                            </li>
                            <li className="nav-item">
                                <Link className="nav-link" to={ReactRoutes.WORK}>Work</Link>
                            </li>
                            <li className="nav-item">
                                <Link className="nav-link" to={ReactRoutes.LISTS}>Lists</Link>
                            </li>
                            <li className="nav-item">
                                <Link className="nav-link" to={ReactRoutes.CONTACT}>Contact</Link>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>

            <Switch>
                <Route exact path={ReactRoutes.HOME}>
                    <Home/>
                </Route>
                <Route exact path={ReactRoutes.BLOG}>
                    <Blog/>
                </Route>
                <Route exact path={ReactRoutes.WORK}>
                    <Work/>
                </Route>
                <Route exact path={ReactRoutes.LISTS}>
                    <Lists/>
                </Route>
                <Route exact path={ReactRoutes.CONTACT}>
                    <Contact/>
                </Route>
            </Switch>
        </Router>;
    }
}