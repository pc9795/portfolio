import React, {SyntheticEvent, useState} from "react";
import {Helmet} from "react-helmet";
import {FaviconConstants, RECAPTCHA_KEY, RESUME_URL} from "../../utils/constants";
import Contact from "../../models/contact";
import ContactsClient from "../../data/contactsClient";
import {AxiosError} from "axios";
import ReCAPTCHA from "react-google-recaptcha";

const styles = {
    gmap: {
        overflow: "auto",
        background: "none!important"
    }
};

enum FormSubmissionState {
    NOT_SUBMITTED,
    SUBMITTED_SUCCESSFULLY,
    SUBMITTED_UNSUCCESSFULLY
}

const RECAPTCHA_VALIDATION_ERROR = "Please verify CAPTCHA";

function ContactPage() {
    const [name, setName] = useState("");
    const [contact, setContact] = useState("");
    const [email, setEmail] = useState("");
    const [purpose, setPurpose] = useState("");
    const [formSubmissionState, setFormSubmittedState] = useState(FormSubmissionState.NOT_SUBMITTED);
    const [formSubmissionResult, setFormSubmissionResult] = useState("");
    const [recaptchaToken, setRecaptchaToken] = useState(null as null | string);

    const renderHead = () => {
        return <Helmet>
            <title>Prashant Chaubey - Contact</title>
            <link rel="icon" type="image/png" href={FaviconConstants.URL} sizes="16x16"/>
        </Helmet>
    };

    const renderContactForm = () => {
        return <form onSubmit={handleSubmit}>
            <div className="form-group row">
                <div className="col-12">
                    <input className="form-control" placeholder="Name" value={name}
                           onChange={event => setName(event.target.value)}/>
                    <small className="form-text text-muted">
                        How should I address you <i className="fa fa-question"> </i>
                    </small>
                </div>
            </div>
            <div className="form-group row">
                <div className="col-12">
                    <input className="form-control" placeholder="Contact" value={contact}
                           onChange={event => setContact(event.target.value)}/>
                    <small className="form-text text-muted">
                        I will keep it safely <i className="fa fa-smile-o"/>
                    </small>
                </div>
            </div>
            <div className="form-group row">
                <div className="col-12">
                    <input className="form-control" placeholder="Email" value={email}
                           onChange={event => setEmail(event.target.value)}/>
                    <small className="form-text text-muted">
                        No spams I promise <i className="fa fa-hand-peace-o"/></small>
                </div>
            </div>
            <div className="form-group row">
                <div className="col-12">
                    <textarea rows={3} className="form-control" placeholder="Purpose" value={purpose}
                              onChange={(event => setPurpose(event.target.value))}/>
                    <small className="form-text text-muted">
                        How can I help you <i className="fa fa-question"/>
                    </small>
                </div>
            </div>
            <ReCAPTCHA sitekey={RECAPTCHA_KEY} onChange={(token) => setRecaptchaToken(token)}/>
            <button type="submit" className="btn btn-success mt-1">Say Hello!</button>
        </form>
    };

    const handleSubmit = (event: SyntheticEvent) => {
        (document.activeElement as HTMLElement).blur();
        event.preventDefault();

        if (recaptchaToken === null) {
            setFormSubmittedState(FormSubmissionState.SUBMITTED_UNSUCCESSFULLY);
            setFormSubmissionResult(RECAPTCHA_VALIDATION_ERROR);
            return;
        }

        const contactObj = new Contact(name, contact, email, purpose);
        ContactsClient.create(contactObj).then(() => {
                setFormSubmittedState(FormSubmissionState.SUBMITTED_SUCCESSFULLY);
                setFormSubmissionResult("Details submitted successfully");
            }
        ).catch((error: AxiosError) => {
            setFormSubmittedState(FormSubmissionState.SUBMITTED_UNSUCCESSFULLY);
            if (error.response) {
                setFormSubmissionResult((error.response.data as ServerError).error.message);
            } else {
                setFormSubmissionResult("Something bad happened!")
            }
        });
    };

    const renderFormSubmissionResult = () => {
        if (formSubmissionState === FormSubmissionState.SUBMITTED_SUCCESSFULLY) {
            return <div className="alert alert-success">
                {formSubmissionResult}
            </div>
        }

        if (formSubmissionState === FormSubmissionState.SUBMITTED_UNSUCCESSFULLY) {
            return <div className="alert alert-danger">
                {formSubmissionResult}
            </div>
        }

        return null;
    };

    const renderCurrentLocationMap = () => {
        return <div className="row">
            <div className="col-12 text-right">
                <div className="mapouter">
                    <div className="gmap_canvas">
                        <iframe title="Current location" style={styles.gmap} width="600" height="500"
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
    };

    return <div className="container">
        {renderHead()}
        <div className="row">
            <div className="col-sm-12 mt-3 col-md-4 p-1">
                {renderFormSubmissionResult()}
                {renderContactForm()}
                <div className="row mt-3">
                    <div className="col-12">
                        <a className="btn btn-info" href={RESUME_URL}>See My Resume</a>
                    </div>
                </div>
            </div>
            <div className="col-sm-12 mt-3 col-md-8">
                {renderCurrentLocationMap()}
            </div>
        </div>

    </div>;
}

export default ContactPage;