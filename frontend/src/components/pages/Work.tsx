import React from "react";
import {Helmet} from "react-helmet";
import {FaviconConstants, ImageConstants, RESUME_URL} from "../../utils/constants";
import DummyData from "../../dummyData";
import {StaticData} from "../../staticData";

function Work() {
    return <div className="container my-3">
        {getHead()}
        {getProfileSummary()}
        {getResumeLink()}
        {getWorkCards()}
        {getGameTrailersHeading()}
        {getGameTrailerVideos()}
    </div>;
}

function getHead() {
    return <Helmet>
        <title>Prashant Chaubey - Work</title>
        <link rel="icon" type="image/png" href={FaviconConstants.URL} sizes="16x16"/>
    </Helmet>;
}

function getResumeLink() {
    return <div className="row">
        <div className="col-12 mt-3">
            <a className="btn btn-info" href={RESUME_URL}>Resume</a>
        </div>
    </div>;
}

function getWorkCards() {
    return <div className="row card-deck mt-3">
        {DummyData.getProjectCardsForWorkPage()}
    </div>
}

function getGameTrailersHeading() {
    return <div className="row my-3">
        <div className="col-8 col-xs-12"><h3>Game Trailers <i className="fa fa-gamepad"/></h3></div>
    </div>;
}

function getGameTrailerVideos() {
    return StaticData.getGameTrailerVideos()
}

function getProfileSummary() {
    return <div className="row">
        <div className="col-md-4 bg-light col-sm-12">
            {getProfileSideBar()}
        </div>
        <div className="col-md-8 col-sm-12 mt-3">
            {StaticData.getProfileInfo()}
        </div>
    </div>
}

function getProfileSideBar() {
    return <div>
        <div className="text-center">
            <img src={ImageConstants.PROFILE_PICTURE} className="mt-3 text-center img-fluid" alt="profile"/>
        </div>
        <div className="mt-3">
            {StaticData.getProfileSideBarInfo()}
        </div>
    </div>
}

export default Work;