import React from "react";
import {Helmet} from "react-helmet";
import {FaviconConstants} from "../../utils/constants";
import DummyData from "../../dummyData";

function Lists() {
    return <div className="container">
        {getHead()}
        <div className="row mt-3">
            <div className="col-md-6 col-sm-12">
                <h3>Technical Readings <i className="fa fa-meh-o"/></h3>
                {getTechnicalList()}
            </div>
            <div className="col-md-6 col-sm-12">
                <h3>Video Games <i className="fa fa-smile-o"/></h3>
                {getVideoGameList()}
            </div>
        </div>
        {getOtherLists()}
    </div>;
}

function getHead() {
    return <Helmet>
        <title>Prashant Chaubey - Lists</title>
        <link rel="icon" type="image/png" href={FaviconConstants.URL} sizes="16x16"/>
    </Helmet>;
}

function getTechnicalList() {
    return DummyData.getTechnicalBooksListForListsPage();
}

function getVideoGameList() {
    return DummyData.getVideogamesListForListsPage();
}

function getOtherLists() {
    return <div className="row mt-3">
        <div className="col-12">
            I use IMDb to maintain my watch list for Movies/TV-shows&nbsp;
            <a href="https://www.imdb.com/user/ur98268122/"><u>peek</u>&nbsp;<i className="fa fa-imdb"/></a>
        </div>
        <div className="col-12">
            I use Goodreads for managing my non-technical readings&nbsp;
            <a href="https://www.goodreads.com/user/show/45195709-prashant-chaubey"><u>peek</u>&nbsp;
                <i className="fa fa-book"/>
            </a>
        </div>
    </div>
}

export default Lists;