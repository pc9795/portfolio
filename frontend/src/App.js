import React from "react";
import {Route, BrowserRouter as Router, Switch} from "react-router-dom";
import Sunshine from "./components/Sunshine";
import Header from "./components/Header";
import Footer from "./components/Footer";

export default class App extends React.Component {

    render() {
        return <Router>
            <Switch>
                <Route exact path="/sunshine">
                    <Sunshine/>
                </Route>
                <Route path="/">
                    <Header/>
                    <Footer/>
                </Route>
            </Switch>
        </Router>;
    }
}