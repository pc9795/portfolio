import React from 'react';
import {FaviconConstants} from "../../utils/constants";
import {Helmet} from "react-helmet";
import DummyData from "../../dummy_data";

export default class BlogPost extends React.Component {
    render() {
        const {blogPostName} = this.props.match.params.name;

        return <div className="container">
            {BlogPost.getHead(blogPostName)}
            {BlogPost.getBlogPost()}
        </div>;
    }

    static getHead(title) {
        return <Helmet>
            <title>{title}</title>
            <link rel="icon" type="image/png" href={FaviconConstants.URL} sizes="16x16"/>
        </Helmet>
    }

    static getBlogPost() {
        return <div className="container">
            {DummyData.getBlogPost()}
        </div>;
    }
}
