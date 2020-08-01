import React from "react";
import {Helmet} from "react-helmet";
import {FaviconConstants, RECAPTCHA_KEY, RESUME_URL} from "../../utils/constants";

const styles = {
    gmap: {
        overflow: "auto",
        background: "none!important"
    }
};

function Contact() {
    return <div className="container">
        {getHead()}
        <div className="row">
            <div className="col-sm-12 mt-3 col-md-4 p-1">
                {getContactForm()}
                <div className="row mt-3">
                    <div className="col-12">
                        <a className="btn btn-info" href={RESUME_URL}>See My Resume</a>
                    </div>
                </div>
            </div>
            <div className="col-sm-12 mt-3 col-md-8">
                {getCurrentLocationMap()}
            </div>
        </div>

    </div>;
}

function getHead() {
    return <Helmet>
        <title>Prashant Chaubey - Contact</title>
        <link rel="icon" type="image/png" href={FaviconConstants.URL} sizes="16x16"/>
    </Helmet>
}

function getContactForm() {
    return <form>
        <div className="form-group row">
            <div className="col-12">
                <input className="form-control" placeholder="Name"/>
                <small className="form-text text-muted">
                    How should I address you <i className="fa fa-question"> </i>
                </small>
            </div>
        </div>
        <div className="form-group row">
            <div className="col-12">
                <input className="form-control" placeholder="Contact"/>
                <small className="form-text text-muted">
                    I will keep it safely <i className="fa fa-smile-o"/>
                </small>
            </div>
        </div>
        <div className="form-group row">
            <div className="col-12">
                <input className="form-control" placeholder="Email"/>
                <small className="form-text text-muted">
                    No spams I promise <i className="fa fa-hand-peace-o"/></small>
            </div>
        </div>
        <div className="form-group row">
            <div className="col-12">
                <textarea rows={3} className="form-control" placeholder="Purpose"/>
                <small className="form-text text-muted">
                    How can I help you <i className="fa fa-question"/>
                </small>
            </div>
        </div>
        <div className="g-recaptcha" data-sitekey={RECAPTCHA_KEY}/>
        <button type="button" className="btn btn-success mt-1">Say Hello!</button>
    </form>
}

function getCurrentLocationMap() {
    return <div className="row">
        <div className="col-12 text-right">
            <div className="mapouter">
                <div className="gmap_canvas">
                    <iframe title="Current location" style={styles.gmap} width="600" height="500" id="gmap_canvas"
                            src="https://maps.google.com/maps?q=Dublin%20&t=&z=11&ie=UTF8&iwloc=&output=embed"
                            frameBorder="0" scrolling="no" marginHeight={0} marginWidth={0}>
                    </iframe>
                </div>
            </div>
        </div>
        <div className="col-12 text-center">
            <h3 className="text-right">I live here <i className="fa fa-hand-o-up"/></h3>
        </div>
    </div>
}

export default Contact;