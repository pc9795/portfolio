import React from "react";
import {Helmet} from "react-helmet";
import {FaviconConstants} from "../../utils/constants";
import DummyData from "../../dummyData";

const MONTH_NAMES = ["January", "February", "March", "April", "May", "June",
    "July", "August", "September", "October", "November", "December"
];

function BlogPage() {
    const getHead = () => {
        return <Helmet>
            <title>Prashant Chaubey - Blog</title>
            <link rel="icon" type="image/png" href={FaviconConstants.URL} sizes="16x16"/>
        </Helmet>
    };

    //todo handle when there are no blog posts
    const getBlogPosts = () => {
        return DummyData.getBlogPostsForBlogPage();
    };

    //todo handle search button click
    //todo show a message like "x results found" on a search
    const getSearchArea = () => {
        return <div className="col-12">
            <div className="row">
                <div className="col-8">
                    <input name="search" className="form-control" type="text"/>
                </div>
                <div className="col-4">
                    <button className="btn btn-secondary" type="submit">Search</button>
                </div>
            </div>
        </div>;
    };

    const getBlogTags = () => {
        return <div className="col-12 mt-3">
            <h2>Tags</h2>
            {DummyData.getBlogTagsForBlogPage()}
        </div>
    };

    const getArchiveList = () => {
        return <div className="col-12 mt-3">
            <h2>Archives</h2>
            <ul>
                {getArchiveListItems().map(listItem => {
                    return listItem
                })}
            </ul>
        </div>
    };

    const getArchiveListItems = () => {
        const currDate = new Date();
        const prevYear = currDate.getFullYear() - 1;

        let archiveListItems = [];
        archiveListItems.push(<li><a className="text-secondary" href="#">{prevYear}</a></li>);

        for (let i = 0; i <= currDate.getMonth(); i++) {
            archiveListItems.push(
                <li>
                    <a className="text-secondary" href="#">{MONTH_NAMES[i] + " " + currDate.getFullYear()}</a>
                </li>
            );
        }

        return archiveListItems;
    };

    return <div className="container my-3">
        {getHead()}
        <div className="row">
            <div className="col-md-8 col-sm-12">
                {getBlogPosts()}
            </div>
            <div className="col-md-4 col-sm-12">
                <div className="row mt-3">
                    {getSearchArea()}
                    {getBlogTags()}
                    {getArchiveList()}
                </div>
            </div>
        </div>
    </div>;
}

export default BlogPage;