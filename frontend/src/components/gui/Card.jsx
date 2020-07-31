import React from 'react';
import PropTypes from 'prop-types';

export default class Card extends React.Component {

    static propTypes = {
        title: PropTypes.element.isRequired,
        text: PropTypes.element.isRequired,
        footer: PropTypes.element
    };

    render() {
        return <div className="card">
            <div className="card-body">
                <h4 className="card-title">{this.props.title}</h4>
                <p className="card-text text-justify">
                    {this.props.text}
                </p>
            </div>
            {this.getFooter()}
        </div>;
    }

    getFooter() {
        if (this.props.footer) {
            return <div className="card-footer">
                {this.props.footer}
            </div>;
        }

        return null;
    }
}