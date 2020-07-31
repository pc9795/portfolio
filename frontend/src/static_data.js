import React from 'react';

export class StaticData {
    static getAboutMe() {
        return <span>
            Currently, a&nbsp;
            <span className="badge badge-secondary">Software Engineer</span>
            &nbsp;in the Notifications platform team at&nbsp;
            <span className="badge badge-secondary">HubSpot</span>
            &nbsp;, ensuring millions of notifications are delivered successfully. Masters in Computer Science
                    from&nbsp;
            <span className="badge badge-secondary">University College Dublin</span>
            &nbsp;. A polyglot programmer who developed everything from an application's front-end to the
                    back-end and everything between. In the past, I built web and desktop applications, delivered
                    distributed RPA systems, and worked on areas like automatic code generation and text classification.
        </span>;
    }

    static getInterests() {
        return <span>
             I spend most of my time playing&nbsp;
            <span className="badge badge-secondary">Chess</span>
            &nbsp;or&nbsp;
            <span className="badge badge-secondary">Videogames</span>
            &nbsp;. I mostly play for story or campaigns, not much multi-player. If you are into Counter-Strike
                    (1.6/GO) or Age of empires 3 just tell me the time and place and I will be there. If you are a chess
                    aficionado you can find me on
                    <a href="https://lichess.org/@/pc9795"> Lichess</a>. I took up cooking seriously
                    last year. I love Trap music.
                    <br/>
                    Care to check which games I play <i className="fa fa-smile-o"/>
        </span>;
    }

    static getReadingsListDesc() {
        return <span>
            I prefer traditional way of learning through books and like to
            maintain a list.
        </span>
    }

    static getPortfolioDesc() {
        return <span>
            Powered by React and Spring-boot.
        </span>
    }
}