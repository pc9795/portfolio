import React, {ReactElement} from 'react';
import PropTypes from 'prop-types';

function Card(props: any) {
    return <div className="card">
        <div className="card-body">
            <h4 className="card-title">{props.title}</h4>
            <div className="card-text text-justify">
                {props.text}
            </div>
        </div>
        {getFooter(props.footer)}
    </div>;
}

function getFooter(footer: ReactElement) {
    if (footer) {
        return <div className="card-footer">
            {footer}
        </div>;
    }

    return null;
}

Card.propTypes = {
    title: PropTypes.oneOfType([PropTypes.element, PropTypes.string]).isRequired,
    text: PropTypes.oneOfType([PropTypes.element, PropTypes.string]).isRequired,
    footer: PropTypes.element
};

export default Card;