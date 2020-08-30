import React from 'react';
import PropTypes from 'prop-types';

function Alarm(props: any) {
    return <div className="container mt-3">
        <div className="alert alert-danger alert-dismissible fade show">
            {props.message}
            <button type="button" className="close" data-dismiss="alert">
                <span>&times;</span>
            </button>
        </div>
    </div>;
}

Alarm.propTypes = {
    message: PropTypes.string.isRequired
};

export default Alarm;