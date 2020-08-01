import React from "react";

const styles = {
    footer: {
        height: '80px',
        position: 'absolute',
        right: '0',
        bottom: '0',
        left: '0'
    },
    footerDivP: {
        marginBottom: '0 !important'
    },
    githubIcon: {
        color: '#373C40'
    },
    linkedinIcon: {
        color: '#0090C1'
    },
    stackOverflowIcon: {
        color: '#F48024'
    }
};

function Footer() {
    return <footer style={styles.footer}>
        <div className="bg-light text-center py-3">
            <span>Follow me on </span>
            <span>
                <a href="https://www.linkedin.com/in/pc9795/">
                    &nbsp;<i style={styles.linkedinIcon} className="fa fa-linkedin"/>
                </a>
            </span>
            <span>
                <a href="https://github.com/pc9795">
                    &nbsp;<i style={styles.githubIcon} className="fa fa-github"/>
                </a>
            </span>
            <span>
                <a href="https://stackoverflow.com/users/5366276/prashant-chaubey">
                    &nbsp;<i style={styles.stackOverflowIcon} className="fa fa-stack-overflow"/>
                </a>
            </span>
            <br/>
            Copyright @2020 Prashant Chaubey
        </div>
    </footer>
}

export default Footer;