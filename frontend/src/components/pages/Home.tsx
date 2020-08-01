import React from "react";
import {Helmet} from "react-helmet";
import {AppRoutes, FaviconConstants} from "../../utils/constants";
import {Link} from "react-router-dom";
import DummyData from "../../dummyData";
import Card from "../gui/Card";
import {StaticData} from "../../staticData";

function Home() {
    return <div className="container my-3">
        {getHead()}
        {getInfoCards()}
        <hr/>
        {getArticleCardsHeading()}
        {getArticleCards()}
        <hr/>
        {getProjectsHeading()}
        {getProjectCards()}
    </div>;
}

function getHead() {
    return <Helmet>
        <title>Prashant Chaubey - Home</title>
        <link rel="icon" type="image/png" href={FaviconConstants.URL} sizes="16x16"/>
    </Helmet>;
}

function getInfoCards() {
    return <div className="row card-deck">
        <div className="col-md-4 col-xs-12">
            {getAboutMeCard()}
        </div>
        <div className="col-md-4 col-xs-12">
            {getInterestsCard()}
        </div>
        <div className="col-md-4 col-xs-12">
            {getReadingsCard()}
        </div>
    </div>;
}

function getAboutMeCard() {
    const title = <span>About me <i className="fa fa-superpowers"/></span>;

    return <Card title={title} text={StaticData.getAboutMe()}/>;
}

function getInterestsCard() {
    const title = <span>Interests <i className="fa fa-gamepad"/></span>;
    const footer = <Link className="text-secondary" to={AppRoutes.LISTS}>Gaming List</Link>;

    return <Card title={title} text={StaticData.getInterests()} footer={footer}/>;
}

function getReadingsCard() {
    const title = <span>Reading List <i className="fa fa-book"/></span>;
    const footer = <Link className="text-secondary" to={AppRoutes.LISTS}>Reading List</Link>;

    return <Card title={title} text={StaticData.getReadingsListDesc()} footer={footer}/>;
}

function getArticleCardsHeading() {
    return <div className="row my-3">
        <div className="col-8 col-xs-12"><h3>Articles <i className="fa fa-rocket"/></h3></div>
        <div className="col-4 col-xs-12">
            <Link className="text-secondary pull-right" to={AppRoutes.BLOG}>All articles</Link>
        </div>
    </div>;
}

function getArticleCards() {
    return <div className="row card-deck">
        {DummyData.getArticleCardsForHomePage()}
    </div>
}

function getProjectsHeading() {
    return <div className="row my-3">
        <div className="col-8 col-xs-12"><h3>Projects <i className="fa fa-code"/></h3></div>
        <div className="col-4 col-xs-12">
            <Link className="text-secondary pull-right" to={AppRoutes.WORK}>See more of my work</Link>
        </div>
    </div>
}

function getProjectCards() {
    return <div className="row card-deck">
        <div className="col-md-4 col-sm-12">
            <Card title={"Portfolio website"} text={StaticData.getPortfolioDesc()}/>
        </div>
        {DummyData.getProjectCardsForHomePage()}
    </div>;
}

export default Home;