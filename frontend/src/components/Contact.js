import React from "react";
import {Helmet} from "react-helmet";
import {FaviconConstants} from "../utils/constants";

export default class Contact extends React.Component {
    render() {
        return <div className="container">
            {Contact.getHead()}
            <h1>Contact</h1>
        </div>;
    }

    static getHead() {
        return <Helmet>
            <title>Prashant Chaubey - Contact</title>
            <link rel="icon" type="image/png" href={FaviconConstants.URL} sizes="16x16"/>
        </Helmet>
    }
}