import React from 'react';
import {FaviconConstants} from "../../utils/constants";
import {Helmet} from "react-helmet";
import DummyData from "../../dummyData";

function BlogPost(props) {
    const {blogPostName} = props.match.params.name;

    return <div className="container my-3">
        {getHead(blogPostName)}
        {getBlogPost()}
    </div>;
}

function getHead(title) {
    return <Helmet>
        <title>{title}</title>
        <link rel="icon" type="image/png" href={FaviconConstants.URL} sizes="16x16"/>
    </Helmet>
}

function getBlogPost() {
    return <div className="container">
        {DummyData.getBlogPostForBlogPostPage()}
    </div>;
}

export default BlogPost;