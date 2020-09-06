import React from 'react';
import PropTypes from 'prop-types';

enum Type {
    ERROR, SUCCESS, INFO
}

function Alarm(props: any) {
    const getAlertClass = (type: Type) => {
        switch (type) {
            case Type.ERROR:
                return "alert-danger";
            case Type.SUCCESS:
                return "alert-success";
            default:
                return "alert-info";
        }
    };

    return <div
        className={`alert ${getAlertClass(props.type)} alert-dismissible fade show`}>
        {props.message}
        <button type="button" className="close" data-dismiss="alert">
            <span>&times;</span>
        </button>
    </div>
}

Alarm.propTypes = {
    message: PropTypes.string.isRequired,
    // Not using a `oneOf` because of chrome warning
    type: PropTypes.any.isRequired
};

Alarm.Type = Type;

export default Alarm;