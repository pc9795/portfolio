import React, {useEffect, useState} from "react";
import {Helmet} from "react-helmet";
import {FaviconConstants, ImageConstants, RESUME_URL} from "../../utils/constants";
import {StaticData} from "../../data/staticData";
import Project from "../../models/project";
import ProjectsClient from "../../data/projectsClient";
import Card from "../gui/Card";

function WorkPage() {
    const [projects, setProjects] = useState([] as Project[]);

    useEffect(() => {
        ProjectsClient.getAll().then((data: Page<Project>) => setProjects(data.content));
    }, []);

    const renderHead = () => {
        return <Helmet>
            <title>Prashant Chaubey - Work</title>
            <link rel="icon" type="image/png" href={FaviconConstants.URL} sizes="16x16"/>
        </Helmet>;
    };

    const renderResumeLink = () => {
        return <div className="row">
            <div className="col-12 mt-3">
                <a className="btn btn-info" href={RESUME_URL}>Resume</a>
            </div>
        </div>;
    };

    const renderProjectCards = () => {
        return <div className="row card-deck">
            {projects.map(project => renderProjectCard(project))}
        </div>
    };

    const renderProjectCard = (project: Project) => {
        return <div className="col-sm-4 col-12 mt-3">
            <Card key={project.name} title={project.heading} text={project.description}
                  footer={<a href={project.link} className="text-secondary">Github Link</a>}/>
        </div>
    };

    const renderGameTrailersHeading = () => {
        return <div className="row my-3">
            <div className="col-sm-8 col-12"><h3>Game Trailers <i className="fa fa-gamepad"/></h3></div>
        </div>;
    };

    const renderGameTrailerVideos = () => {
        return StaticData.getGameTrailerVideos()
    };

    const renderProfileSummary = () => {
        return <div className="row">
            <div className="col-sm-4 bg-light col-12">
                {renderProfileSideBar()}
            </div>
            <div className="col-sm-8 col-12 mt-3">
                {StaticData.getProfileInfo()}
            </div>
        </div>
    };

    const renderProfileSideBar = () => {
        return <div>
            <div className="text-center">
                <img src={ImageConstants.PROFILE_PICTURE} className="mt-3 text-center img-fluid" alt="profile"/>
            </div>
            <div className="mt-3">
                {StaticData.getProfileSideBarInfo()}
            </div>
        </div>
    };

    return <div className="container my-3">
        {renderHead()}
        {renderProfileSummary()}
        {renderResumeLink()}
        {renderProjectCards()}
        {renderGameTrailersHeading()}
        {renderGameTrailerVideos()}
    </div>;
}

export default WorkPage;