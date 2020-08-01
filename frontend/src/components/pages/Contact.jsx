import React from "react";
import {Helmet} from "react-helmet";
import {FaviconConstants} from "../../utils/constants";

function Contact() {
    return <div className="container">
        {getHead()}
        <h1>Contact</h1>
    </div>;
}

function getHead() {
    return <Helmet>
        <title>Prashant Chaubey - Contact</title>
        <link rel="icon" type="image/png" href={FaviconConstants.URL} sizes="16x16"/>
    </Helmet>
}

export default Contact;