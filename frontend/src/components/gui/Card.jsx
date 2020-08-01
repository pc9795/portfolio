import React from 'react';
import PropTypes from 'prop-types';

function Card(props) {
    return <div className="card">
        <div className="card-body">
            <h4 className="card-title">{props.title}</h4>
            <p className="card-text text-justify">
                {props.text}
            </p>
        </div>
        {getFooter(props.footer)}
    </div>;
}

function getFooter(footer) {
    if (footer) {
        return <div className="card-footer">
            {footer}
        </div>;
    }

    return null;
}

Card.propTypes = {
    title: PropTypes.element.isRequired,
    text: PropTypes.element.isRequired,
    footer: PropTypes.element
};

export default Card;