import React from "react";
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import Sunshine from "./components/pages/Sunshine";
import Header from "./components/Header";
import Footer from "./components/Footer";

function App() {
    return <Router>
        <Switch>
            <Route exact path="/sunshine" component={Sunshine}/>
            <Route path="/">
                <Header/>
                <Footer/>
            </Route>
        </Switch>
    </Router>;
}

export default App;