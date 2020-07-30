import React from "react";
import {Helmet} from "react-helmet";
import {FaviconConstants} from "../../utils/constants";

export default class Blog extends React.Component {
    render() {
        return <div className="container">
            {Blog.getHead()}
            <h1>Blog</h1>
        </div>;
    }

    static getHead() {
        return <Helmet>
            <title>Prashant Chaubey - Blog</title>
            <link rel="icon" type="image/png" href={FaviconConstants.URL} sizes="16x16"/>
        </Helmet>
    }
}