import React from 'react';
import {FaviconConstants} from "../../utils/constants";
import {Helmet} from "react-helmet";
import DummyData from "../../dummyData";

function BlogPostPage(props: any) {
    const {blogPostName} = props.match.params.name;

    const getHead = () => {
        return <Helmet>
            <title>{blogPostName}</title>
            <link rel="icon" type="image/png" href={FaviconConstants.URL} sizes="16x16"/>
        </Helmet>
    };

    const getBlogPost = () => {
        return <div className="container">
            {DummyData.getBlogPostForBlogPostPage()}
        </div>;
    };

    return <div className="container my-3">
        {getHead()}
        {getBlogPost()}
    </div>;
}

export default BlogPostPage;