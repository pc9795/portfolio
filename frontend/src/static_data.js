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

    static getProfileSideBarInfo() {
        return <div>
            <p>
                <span className="font-weight-bold">Languages of Choice: </span>
                <i style={{color: "red"}} className="fa fa-heart"/> Java, Python
            </p>
            <p>
                <span className="font-weight-bold">Areas of interest: </span>
                Distributed Computing, Micro-services, Multi-agent systems, and Machine learning
            </p>
        </div>
    }

    static getProfileInfo() {
        return <div>
            <h4>Education <i className="fa fa-university"/></h4>
            <ul>
                <li>University College Dublin, M.S. Computer Science, 2020, 4.09/4.2</li>
                <li>Jaypee Institute of Information Technology, B.Tech ECE, 2016, 8.9/10</li>
            </ul>
            <h4>Work Ex <i className="fa fa-road"/></h4>
            <ul>
                <li>Software Engineer, HubSpot, (June 2020 - Present)</li>
                <li>Software Engineer, Soroco, (May 2019 - Aug 2019)</li>
                <li>Java Developer, Wipro technologies, (Aug 2016 - April 2018)</li>
            </ul>
        </div>
    }

    static getGameTrailerVideos() {
        const iframeWidth = 350;
        const iframeHeight = 200;

        const bitNightmareTrailer = <iframe title="Bit nightmare game trailer"
                                            width={iframeWidth} height={iframeHeight}
                                            src="https://www.youtube.com/embed/uUo7J69Sr_w"
                                            frameBorder="0"
                                            allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
                                            allowFullScreen/>;
        const bumperFuryTrailer = <iframe title="Bumper fury game trailer"
                                          width={iframeWidth} height={iframeHeight}
                                          src="https://www.youtube.com/embed/0y7qBGYuIDE"
                                          frameBorder="0"
                                          allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
                                          allowFullScreen/>;

        const gameTrailers = [bitNightmareTrailer, bumperFuryTrailer].map(trailer => {
            return <div className="mx-1 col-12 col-sm-4">{trailer}</div>
        });

        return <div className="row">
            {gameTrailers}
        </div>;
    }
}