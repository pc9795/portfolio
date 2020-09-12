import React, {Fragment} from 'react';
import PropTypes from 'prop-types';

function Confirm(props: any) {
    return <Fragment>
        <div className="modal fade" id="confirmModal" tabIndex={-1}>
            <div className="modal-dialog">
                <div className="modal-content">
                    <div className="modal-header">
                        <h5 className="modal-title">{props.title}</h5>
                        <button type="button" className="close" data-dismiss="modal">
                            <span>&times;</span>
                        </button>
                    </div>
                    <div className="modal-body">
                        <h6 className="font-weight-bold">{props.body}</h6>
                    </div>
                    <div className="modal-footer">
                        <button type="button" className="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="button" className="btn btn-danger"
                                onClick={props.onClick} data-dismiss="modal">{props.confirmText}</button>
                    </div>
                </div>
            </div>
        </div>
        <button type="button" className={props.childBtnBSClassName} data-toggle="modal" data-target="#confirmModal">
            {props.childBtnText}
        </button>
        {props.children}
    </Fragment>;
}

Confirm.propTypes = {
    title: PropTypes.oneOfType([PropTypes.element, PropTypes.string]).isRequired,
    body: PropTypes.oneOfType([PropTypes.element, PropTypes.string]).isRequired,
    confirmText: PropTypes.string.isRequired,
    onClick: PropTypes.func.isRequired,
    childBtnBSClassName: PropTypes.string.isRequired,
    childBtnText: PropTypes.oneOfType([PropTypes.element, PropTypes.string]).isRequired
};

export default Confirm;