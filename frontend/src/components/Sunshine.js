import React from "react";
import {Helmet} from "react-helmet";
import {FaviconConstants, ImageConstants} from "../utils/constants";

const styles = {
    mainContainer: {
        backgroundColor: '#6cbf84'
    },
    img: {
        minWidth: '100%',
        height: 'auto'
    },
    startBtn: {
        backgroundColor: '#323339',
        color: '#dfe2d2'
    },
    showBtn: {
        backgroundColor: '#323339',
        color: '#dfe2d2'
    },
    redColor: {
        color: '#f26968'
    }
};


export default class Sunshine extends React.Component {
    static START_BTN_TEXT = "This is what I feel for you.\nI don't know whether\nI can pen it down properly\nor not, " +
        "but I want to try\n\nPRESS IT!!!";

    constructor(props) {
        super(props);
        this.state = {
            poemShown: false,
            secretShown: false,
            showBtnShown: false,
            showBtnClickCount: 0,
        }
    };

    render() {
        return <div style={styles.mainContainer} className="container">
            {Sunshine.getHead()}
            <div style={styles.redColor} className="row mt-3">
                <div className="col-12 text-center">
                    <h1>Happy Birthday Sheenam :)</h1>
                </div>
            </div>
            <div className="row mt-5 b">
                <div className="col-12 col-sm-3 b mt-3">
                    <img alt="It should be a cake" className="img-fluid b"
                         src={ImageConstants.CAKE}/>
                </div>
                <div className="col-12 col-sm-6 b text-center mt-3">
                    {this.getStartBtn()}
                    {this.getPoem()}
                    {this.getShowBtn()}
                </div>
                <div className="col-12 col-sm-3 b mt-3">
                    <img alt="25 year old diva" className="img-fluid b" src={ImageConstants.TWENTY_FIVE}/>
                </div>
            </div>
        </div>;
    }

    static getHead() {
        return <Helmet>
            <title>Happy Birthday Sunshine</title>
            <link rel="icon" type="image/png" href={FaviconConstants.BIRTHDAY_URL} sizes="16x16"/>
        </Helmet>;
    }

    getStartBtn() {
        if (this.state.poemShown) {
            return null;
        }

        return <button style={styles.startBtn} onClick={this.handleStartBtnClick} className="btn btn-info b">
            <span className="display-linebreak">{Sunshine.START_BTN_TEXT}</span>
        </button>;
    }

    handleStartBtnClick = () => {
        this.setState({poemShown: true, showBtnShown: true});
    };

    getPoem() {
        if (!this.state.poemShown) {
            return null;
        }

        if (!this.state.secretShown) {
            return <p className="display-linebreak">{Sunshine.getPoemText()}</p>;
        }

        return <p>{Sunshine.renderSecretInPoem(Sunshine.getPoemText())}</p>
    }

    static getPoemText() {
        return "How strange it is? \n" +
            "And I never thought it would ever happen\n" +
            "Person of my dreams \n" +
            "Person with whom I wish to be with\n" +
            "Young like a newly formed river\n" +
            "Beautiful as the heavenly night sky\n" +
            "Irresistible she is \n" +
            "Radiant like daylight \n" +
            "That person will become a part of my life\n" +
            "How strange it is? \n" +
            "Deep inside my heart \n" +
            "A feeling was there  \n" +
            "Yet I never expressed  \n" +
            "Surrounded by fears and anxieties\n" +
            "Hopes were not able to breed\n" +
            "Either it was luck or destiny\n" +
            "Either it was fluke or coincidence\n" +
            "Now I am with that person \n" +
            "And I will never leave her \n" +
            "My sunshine :)  "
    }

    static renderSecretInPoem(poemText) {
        return poemText.toString().split("\n").map((line, index) => {
            return Sunshine.getSpanWithFirstWordInRed(line, index)
        });
    }

    static getSpanWithFirstWordInRed(line, index) {
        if (!line) {
            return null;
        }
        if (line.length === 1) {
            return <span key={index} className="display-linebreak" style={styles.redColor}>{line + "\n"}</span>
        }
        return <span className="display-linebreak" key={index}>
                    <span style={styles.redColor}>{line[0]}</span>{line.slice(1) + "\n"}
                </span>
    }

    getShowBtn() {
        if (!this.state.showBtnShown) {
            return null;
        }

        return <button style={styles.showBtn} onClick={this.handleShowBtnClick} className="btn btn-info b">
            <span className="display-linebreak">{this.getShowBtnText()}</span>
        </button>;
    }

    handleShowBtnClick = () => {
        if (this.state.showBtnClickCount <= 3) {
            this.setState({showBtnClickCount: this.state.showBtnClickCount + 1});
        } else {
            this.setState({showBtnShown: false, secretShown: true});
        }
    };

    getShowBtnText() {
        switch (this.state.showBtnClickCount) {
            case 0:
                return "If you read it\n PRESS IT!!!";
            case 1:
                return "PAKKA!!!";
            case 2:
                return "NO CHEATING!!!";
            case 3:
                return "MEHNAT LAGI THI, PADH LO!!!";
            case 4:
                return "OKAY, GO ON!!!";
            default:
                return "";
        }
    }
};

