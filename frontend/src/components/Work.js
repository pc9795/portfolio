import React from "react";
import {Helmet} from "react-helmet";
import {FaviconConstants} from "../utils/constants";

export default class Work extends React.Component {
    render() {
        return <div className="container">
            {Work.getHead()}
            <h1>Work</h1>
        </div>;
    }

    static getHead() {
        return <Helmet>
            <title>Prashant Chaubey - Work</title>
            <link rel="icon" type="image/png" href={FaviconConstants.URL} sizes="16x16"/>
        </Helmet>;
    }
}