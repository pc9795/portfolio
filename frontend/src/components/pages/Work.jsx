import React from "react";
import {Helmet} from "react-helmet";
import {FaviconConstants} from "../../utils/constants";

function Work() {
    return <div className="container">
        {getHead()}
        <h1>Work</h1>
    </div>;
}

function getHead() {
    return <Helmet>
        <title>Prashant Chaubey - Work</title>
        <link rel="icon" type="image/png" href={FaviconConstants.URL} sizes="16x16"/>
    </Helmet>;
}

export default Work;