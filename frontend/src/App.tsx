import React from "react";
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

function App() {
    return <Switch>
        <Route exact path="/sunshine" component={SunshinePage}/>
        <Route path="/">
            <Header/>
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
    </Switch>
}

export default App;