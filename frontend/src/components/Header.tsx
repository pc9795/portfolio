import React from "react";
import {BrowserRouter as Router, Link, Route, Switch} from "react-router-dom";
import HomePage from "./pages/HomePage";
import BlogPage from "./pages/BlogPage";
import WorkPage from "./pages/WorkPage";
import ListsPage from "./pages/ListsPage";
import ContactPage from "./pages/ContactPage";
import {AppRoutes} from "../utils/constants";
import BlogPostPage from './pages/BlogPostPage';

function Header() {
    return <Router>
        <nav className="navbar navbar-expand-md navbar-dark bg-dark">
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
        </nav>

        <Switch>
            <Route exact path={AppRoutes.HOME} component={HomePage}/>
            <Route exact path={AppRoutes.BLOG} component={BlogPage}/>
            <Route exact path={AppRoutes.WORK} component={WorkPage}/>
            <Route exact path={AppRoutes.LISTS} component={ListsPage}/>
            <Route exact path={AppRoutes.CONTACT} component={ContactPage}/>
            <Route exact path={AppRoutes.BLOG + "/:name"} component={BlogPostPage}/>
        </Switch>
    </Router>;
}

export default Header;