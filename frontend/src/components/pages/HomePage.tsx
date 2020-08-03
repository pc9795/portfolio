import React, {useEffect, useState} from "react";
import {Helmet} from "react-helmet";
import {AppRoutes, FaviconConstants} from "../../utils/constants";
import {Link} from "react-router-dom";
import Card from "../gui/Card";
import {StaticData} from "../../staticData";
import BlogPost from "../../models/blogPost";
import BlogPostsClient from "../../data/blogPostsClient";
import Project from "../../models/project";
import ProjectsClient from "../../data/projectsClient";

function HomePage() {
    const [blogPosts, setBlogPosts] = useState([] as BlogPost[]);
    const [projects, setProjects] = useState([] as Project[]);

    useEffect(() => {
        BlogPostsClient.getAll(0, 3).then((data: Page<BlogPost>) => {
            setBlogPosts(data.content);
        });
        ProjectsClient.getAll(0, 2).then((data: Page<Project>) => {
            setProjects(data.content);
        });
    }, []);

    const getHead = () => {
        return <Helmet>
            <title>Prashant Chaubey - Home</title>
            <link rel="icon" type="image/png" href={FaviconConstants.URL} sizes="16x16"/>
        </Helmet>;
    };

    const getInfoCards = () => {
        return <div className="row card-deck">
            <div className="col-md-4 col-xs-12">
                {getAboutMeCard()}
            </div>
            <div className="col-md-4 col-xs-12">
                {getInterestsCard()}
            </div>
            <div className="col-md-4 col-xs-12">
                {getReadingsCard()}
            </div>
        </div>;
    };

    const getAboutMeCard = () => {
        const title = <span>About me <i className="fa fa-superpowers"/></span>;

        return <Card title={title} text={StaticData.getAboutMe()}/>;
    };

    const getInterestsCard = () => {
        const title = <span>Interests <i className="fa fa-gamepad"/></span>;
        const footer = <Link className="text-secondary" to={AppRoutes.LISTS}>Gaming List</Link>;

        return <Card title={title} text={StaticData.getInterests()} footer={footer}/>;
    };

    const getReadingsCard = () => {
        const title = <span>Reading List <i className="fa fa-book"/></span>;
        const footer = <Link className="text-secondary" to={AppRoutes.LISTS}>Reading List</Link>;

        return <Card title={title} text={StaticData.getReadingsListDesc()} footer={footer}/>;
    };

    const getBlogPostsHeading = () => {
        return <div className="row my-3">
            <div className="col-8 col-xs-12"><h3>Articles <i className="fa fa-rocket"/></h3></div>
            <div className="col-4 col-xs-12">
                <Link className="text-secondary pull-right" to={AppRoutes.BLOG}>All articles</Link>
            </div>
        </div>;
    };

    const getBlogPostCards = () => {
        return <div className="row card-deck">
            {blogPosts.map(blogPost => getBlogPostCard(blogPost))}
        </div>
    };

    const getBlogPostCard = (blogPost: BlogPost) => {
        const footer = <a href={AppRoutes.BLOG + "/" + blogPost.name} className="text-secondary">Read More</a>;

        return <div key={blogPost.name} className="col-md-4 col-sm-12">
            <Card title={blogPost.heading} text={blogPost.description} footer={footer}/>
        </div>
    };

    const getProjectsHeading = () => {
        return <div className="row my-3">
            <div className="col-8 col-xs-12"><h3>Projects <i className="fa fa-code"/></h3></div>
            <div className="col-4 col-xs-12">
                <Link className="text-secondary pull-right" to={AppRoutes.WORK}>See more of my work</Link>
            </div>
        </div>
    };

    const getProjectCards = () => {
        return <div className="row card-deck">
            <div className="col-md-4 col-sm-12">
                <Card title={"Portfolio website"} text={StaticData.getPortfolioDesc()}/>
            </div>
            {projects.map(project => getProjectCard(project))}
        </div>;
    };

    const getProjectCard = (project: Project) => {
        const footer = <a href={project.link} className="text-secondary">Project Repo</a>;

        return <div key={project.name} className="col-md-4 col-sm-12">
            <Card title={project.heading} text={project.description} footer={footer}/>
        </div>
    };
    return <div className="container my-3">
        {getHead()}
        {getInfoCards()}
        <hr/>
        {getBlogPostsHeading()}
        {getBlogPostCards()}
        <hr/>
        {getProjectsHeading()}
        {getProjectCards()}
    </div>;
}

export default HomePage;