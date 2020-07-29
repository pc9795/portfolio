import React from "react";

const headerDivStyle = {
    padding: '0 !important'
};

export default class Header extends React.Component {
    render() {
        return <div style={headerDivStyle} className="container">
            <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                <a id="home_link" className="navbar-brand" href="#">Prashant Chaubey</a>
                <button className="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent">
                    <span className="navbar-toggler-icon"/>
                </button>

                <div className="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul className="navbar-nav mr-auto">
                        <li className="nav-item">
                            <a className="nav-link" href="#">Blog</a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" href="#">Work</a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" href="#">Lists</a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" href="#">Contact</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>;
    }
}