import React, {useEffect, useState} from "react";
import {Helmet} from "react-helmet";
import {FaviconConstants} from "../../utils/constants";
import ListItem from "../../models/listItem";
import {ListsClient} from "../../data/listsClient";
import {Page} from "../../react-app-env";

function ListsPage() {
    const [technicalList, setTechnicalList] = useState([] as ListItem[]);
    const [gamingList, setGamingList] = useState([] as ListItem[]);

    useEffect(() => {
        ListsClient.getTechnicalList().then((data: Page<ListItem>) => setTechnicalList(data.content));
        ListsClient.getGamingList().then((data: Page<ListItem>) => setGamingList(data.content));
    }, []);

    const renderHead = () => {
        return <Helmet>
            <title>Prashant Chaubey - Lists</title>
            <link rel="icon" type="image/png" href={FaviconConstants.URL} sizes="16x16"/>
        </Helmet>;
    };

    const renderTechnicalList = () => {
        return technicalList.map(technicalListItem => {
            return <li key={technicalListItem.name}>{technicalListItem.name} <span
                className="text-secondary">{technicalListItem.createdAt}</span>
            </li>
        })
    };

    const renderVideoGameList = () => {
        return gamingList.map(gamingListItem => {
            return <li key={gamingListItem.name}>{gamingListItem.name} <span
                className="text-secondary">{gamingListItem.createdAt}</span>
            </li>
        })
    };

    const renderOtherLists = () => {
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
    };

    return <div className="container my-3">
        {renderHead()}
        <div className="row mt-3">
            <div className="col-sm-6 col-12">
                <h3>Technical Readings <i className="fa fa-meh-o"/></h3>
                {renderTechnicalList()}
            </div>
            <div className="col-sm-6 col-12">
                <h3>Video Games <i className="fa fa-smile-o"/></h3>
                {renderVideoGameList()}
            </div>
        </div>
        {renderOtherLists()}
    </div>;
}

export default ListsPage;