import React from "react";

const footerStyle = {
    height: '80px',
    position: 'absolute',
    right: '0',
    bottom: '0',
    left: '0'
};
const footerDivStyle = {
    padding: '0 !important'
};
const footerDivPStyle = {
    marginBottom: '0 !important'
};
const githubIconStyle = {
    color: '#373C40'
};
const linkedinIconStyle = {
    color: '#0090C1'
};
const stackOverflowIconStyle = {
    color: '#F48024'
};

export default class Footer extends React.Component {
    render() {
        return <footer style={footerStyle}>
            <div style={footerDivStyle} className="container bg-light">
                <p style={footerDivPStyle} className="text-center pt-3">
                    <span>Follow me on </span>
                    <span><a href="https://www.linkedin.com/in/pc9795/"><i style={linkedinIconStyle}
                                                                           className="fa fa-linkedin"/></a> </span>
                    <span><a href="https://github.com/pc9795"><i style={githubIconStyle}
                                                                 className="fa fa-github"/> </a> </span>
                    <span><a style={stackOverflowIconStyle}
                             href="https://stackoverflow.com/users/5366276/prashant-chaubey">
                    <i className="fa fa-stack-overflow"/></a> </span>
                </p>
                <p className="text-center pb-3">Copyright @2020 Prashant Chaubey</p>
            </div>
        </footer>
    };
}