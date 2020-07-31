import React from "react";
import {Helmet} from "react-helmet";
import {FaviconConstants, ReactRoutes} from "../../utils/constants";
import {Link} from "react-router-dom";
import DummyData from "../../dummy_data";
import Card from "../gui/Card";
import {StaticData} from "../../static_data";

export default class Home extends React.Component {
    render() {
        return <div className="container mt-3 mb-3">
            {Home.getHead()}
            {Home.getInfoCards()}
            <hr/>
            {Home.getArticleCardsHeading()}
            {Home.getArticleCards()}
            <hr/>
            {Home.getProjectsHeading()}
            {Home.getProjectCards()}
        </div>;
    }

    static getHead() {
        return <Helmet>
            <title>Prashant Chaubey - Home</title>
            <link rel="icon" type="image/png" href={FaviconConstants.URL} sizes="16x16"/>
        </Helmet>;
    }

    static getInfoCards() {
        return <div className="row card-deck">
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
        const title = <span>About me <i className="fa fa-superpowers"/></span>;

        return <Card title={title} text={StaticData.getAboutMe()}/>;
    }

    static getInterestsCard() {
        const title = <span>Interests <i className="fa fa-gamepad"/></span>;
        const footer = <Link className="text-secondary" to={ReactRoutes.LISTS}>Gaming List</Link>;

        return <Card title={title} text={StaticData.getInterests()} footer={footer}/>;
    }

    static getReadingsCard() {
        const title = <span>Reading List <i className="fa fa-book"/></span>;
        const footer = <Link className="text-secondary" to={ReactRoutes.LISTS}>Reading List</Link>;

        return <Card title={title} text={StaticData.getReadingsListDesc()} footer={footer}/>;
    }

    static getArticleCardsHeading() {
        return <div className="row my-3">
            <div className="col-8 col-xs-12"><h3>Articles <i className="fa fa-rocket"/></h3></div>
            <div className="col-4 col-xs-12">
                <Link className="text-secondary pull-right" to={ReactRoutes.BLOG}>All articles</Link>
            </div>
        </div>;
    }

    static getArticleCards() {
        return <div className="row card-deck">
            {DummyData.getArticleCardsForHomePage()}
        </div>
    }

    static getProjectsHeading() {
        return <div className="row my-3">
            <div className="col-8 col-xs-12"><h3>Projects <i className="fa fa-code"/></h3></div>
            <div className="col-4 col-xs-12">
                <Link className="text-secondary pull-right" to={ReactRoutes.WORK}>See more of my work</Link>
            </div>
        </div>
    }

    static getProjectCards() {
        return <div className="row card-deck">
            <div className="col-md-4 col-sm-12">
                <Card title={"Portfolio website"} text={StaticData.getPortfolioDesc()}/>
            </div>
            {DummyData.getProjectCardsForHomePage()}
        </div>;
    }
}