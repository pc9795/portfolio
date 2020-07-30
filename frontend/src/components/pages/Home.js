import React from "react";
import {Helmet} from "react-helmet";
import {FaviconConstants} from "../../utils/constants";
import {Link} from "react-router-dom";

export default class Home extends React.Component {
    render() {
        return <div className="container">
            {Home.getHead()}
            {Home.getInfoCards()}
            <hr/>
            {Home.getArticleCardsHeading()}
            {Home.getArticleCards()}
            <hr/>
            {Home.getProjectsHeading()}
            {Home.getProjectsCards()}
        </div>;
    }

    static getHead() {
        return <Helmet>
            <title>Prashant Chaubey - Home</title>
            <link rel="icon" type="image/png" href={FaviconConstants.URL} sizes="16x16"/>
        </Helmet>;
    }

    static getInfoCards() {
        return <div className="mt-3 row card-deck">
            <div className="col-md-4 col-xs-12">
                {Home.getAboutMeCard()}
            </div>
            <div className="col-md-4 col-xs-12">
                {Home.getInterestsCard()}
            </div>
            <div className="col-md-4 col-xs-12">
                {Home.getReadingsCard()}
            </div>
        </div>;
    }

    static getAboutMeCard() {
        return <div className="card">
            <div className="card-body">
                <h4 className="card-title">About me <i className="fa fa-superpowers"/>
                </h4>
                <p className="card-text text-justify">
                    Currently, a&nbsp;
                    <span className="badge badge-secondary">Software Engineer</span>
                    &nbsp;in the Notifications platform team at&nbsp;
                    <span className="badge badge-secondary">HubSpot</span>
                    &nbsp;, ensuring millions of notifications are delivered successfully. Masters in Computer Science
                    from&nbsp;
                    <span className="badge badge-secondary">University College Dublin</span>
                    &nbsp;. A polyglot programmer who developed everything from an application's front-end to the
                    back-end and everything between. In the past, I built web and desktop applications, delivered
                    distributed RPA systems, and worked on areas like automatic code generation and text classification.
                </p>
            </div>
        </div>;
    }

    static getInterestsCard() {
        return <div className="card">
            <div className="card-body">
                <h4 className="card-title">Interests <i className="fa fa-gamepad"/></h4>
                <p className="card-text text-justify">
                    I spend most of my time playing&nbsp;
                    <span className="badge badge-secondary">Chess</span>
                    &nbsp;or&nbsp;
                    <span className="badge badge-secondary">Videogames</span>
                    &nbsp;. I mostly play for story or campaigns, not much multi-player. If you are into Counter-Strike
                    (1.6/GO) or Age of empires 3 just tell me the time and place and I will be there. If you are a chess
                    aficionado you can find me on
                    <a href="https://lichess.org/@/pc9795"> Lichess</a>. I took up cooking seriously
                    last year. I love Trap music.
                    <br/>
                    Care to check which games I play <i className="fa fa-smile-o"/>
                </p>
            </div>
            <div className="card-footer">
                <Link className="text-secondary" to="/list">Gaming List</Link>
            </div>
        </div>;
    }

    static getReadingsCard() {
        return <div className="card">
            <div className="card-body">
                <h4 className="card-title">Reading List <i className="fa fa-book"/></h4>
                <p className="card-text text-justify">I prefer traditional way of learning through books and like to
                    maintain a
                    list.</p>
            </div>
            <div className="card-footer">
                <Link className="text-secondary" to="/list">Reading List</Link>
            </div>
        </div>;
    }

    static getArticleCardsHeading() {
        return <div className="row my-3">
            <div className="col-8 col-xs-12"><h3>Recent articles <i className="fa fa-rocket"/></h3></div>
            <div className="col-4 col-xs-12">
                <Link className="text-secondary pull-right" to="/blog">All articles</Link>
            </div>
        </div>;
    }

    static getArticleCards() {
        return null;
    }

    static getProjectsHeading() {
        return <div className="row my-3">
            <div className="col-8 col-xs-12"><h3>Personal projects <i class="fa fa-code"/></h3></div>
            <div className="col-4 col-xs-12">
                <Link className="text-secondary pull-right" to="/work">See more of my work</Link>
            </div>
        </div>
    }

    static getProjectsCards() {
        return null;
    }
}