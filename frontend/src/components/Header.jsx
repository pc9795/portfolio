import React from "react";
import {BrowserRouter as Router, Link, Route, Switch} from "react-router-dom";
import Home from "./pages/Home";
import Blog from "./pages/Blog";
import Work from "./pages/Work";
import Lists from "./pages/Lists";
import Contact from "./pages/Contact";
import {AppRoutes} from "../utils/constants";
import BlogPost from './pages/BlogPost';

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
            </div>

            <Switch>
                <Route exact path={AppRoutes.HOME} component={Home}/>
                <Route exact path={AppRoutes.BLOG} component={Blog}/>
                <Route exact path={AppRoutes.WORK} component={Work}/>
                <Route exact path={AppRoutes.LISTS} component={Lists}/>
                <Route exact path={AppRoutes.CONTACT} component={Contact}/>
                <Route exact path={AppRoutes.BLOG + "/:name"} component={BlogPost}/>
            </Switch>
        </Router>;
    }
}