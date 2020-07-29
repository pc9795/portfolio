import React from "react";
import {Helmet} from "react-helmet";
import {FaviconConstants} from "../utils/constants";

export default class Home extends React.Component {
    render() {
        return <div className="container">
            <Helmet>
                <title>Prashant Chaubey - Home</title>
                <link rel="icon" type="image/png" href={FaviconConstants.URL} sizes="16x16"/>
            </Helmet>

            <h1>Home</h1>
        </div>;
    }
}