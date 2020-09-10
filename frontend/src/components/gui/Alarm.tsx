import React, {useContext} from 'react';
import PropTypes from 'prop-types';
import {AppContext, AppReducerActionType} from "../../App";
import {AppReducerAction} from "../../react-app-env";

export enum AlarmType {
    ERROR, SUCCESS
}

function Alarm(props: any) {
    const {dispatch} = useContext(AppContext);

    const getAlertClass = (type: AlarmType) => {
        switch (type) {
            case AlarmType.ERROR:
                return "alert-danger";
            case AlarmType.SUCCESS:
                return "alert-success";
            default:
                return "alert-info";
        }
    };

    return <div
        className={`alert ${getAlertClass(props.type)} alert-dismissible fade show`}>
        {props.message}
        <button type="button" className="close" data-dismiss="alert" onClick={() => dispatch({
            type: AppReducerActionType.REMOVE_ALARM,
            payload: {data: props.message}
        } as AppReducerAction)}>
            <span>&times;</span>
        </button>
    </div>
}

Alarm.propTypes = {
    message: PropTypes.string.isRequired,
    // Not using a `oneOf` because of chrome warning
    type: PropTypes.any.isRequired
};

export default Alarm;