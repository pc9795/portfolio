import React from "react";
import {Helmet} from "react-helmet";
import {FaviconConstants} from "../utils/constants";

export default class Lists extends React.Component {
    render() {
        return <div className="container">
            {Lists.getHead()}
            <h1>Lists</h1>
        </div>;
    }

    static getHead() {
        return <Helmet>
            <title>Prashant Chaubey - Lists</title>
            <link rel="icon" type="image/png" href={FaviconConstants.URL} sizes="16x16"/>
        </Helmet>;
    }
}