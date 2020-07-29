import React from "react";
import {BrowserRouter as Router, Switch, Route, Link} from "react-router-dom";
import Home from "./Home";
import Blog from "./Blog";
import Work from "./Work";
import Lists from "./Lists";
import Contact from "./Contact";

const headerDivStyle = {
    padding: '0 !important'
};

export default class Header extends React.Component {
    render() {
        return <Router>
            <div style={headerDivStyle} className="container">
                <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                    <Link className="navbar-brand" to="/">Prashant Chaubey</Link>
                    <button className="navbar-toggler" type="button" data-toggle="collapse"
                            data-target="#navbarSupportedContent">
                        <span className="navbar-toggler-icon"/>
                    </button>

                    <div className="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul className="navbar-nav mr-auto">
                            <li className="nav-item">
                                <Link className="nav-link" to="/blog">Blog</Link>
                            </li>
                            <li className="nav-item">
                                <Link className="nav-link" to="/work">Work</Link>
                            </li>
                            <li className="nav-item">
                                <Link className="nav-link" to="/lists">Lists</Link>
                            </li>
                            <li className="nav-item">
                                <Link className="nav-link" to="/contact">Contact</Link>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>

            <Switch>
                <Route exact path="/">
                    <Home/>
                </Route>
                <Route exact path="/blog">
                    <Blog/>
                </Route>
                <Route exact path="/work">
                    <Work/>
                </Route>
                <Route exact path="/lists">
                    <Lists/>
                </Route>
                <Route exact path="/contact">
                    <Contact/>
                </Route>
            </Switch>
        </Router>;
    }
}