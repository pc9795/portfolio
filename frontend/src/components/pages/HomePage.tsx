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

const HOME_PAGE_BLOG_POSTS_COUNT = 3;
const HOME_PAGE_PROJECTS_COUNT = 2;

function HomePage() {
    const [blogPosts, setBlogPosts] = useState([] as BlogPost[]);
    const [projects, setProjects] = useState([] as Project[]);

    useEffect(() => {
        BlogPostsClient.getAll(0, HOME_PAGE_BLOG_POSTS_COUNT).then((data: Page<BlogPost>) => {
            setBlogPosts(data.content);
        });
        ProjectsClient.getAll(0, HOME_PAGE_PROJECTS_COUNT).then((data: Page<Project>) => {
            setProjects(data.content);
        });
    }, []);

    const renderHead = () => {
        return <Helmet>
            <title>Prashant Chaubey - Home</title>
            <link rel="icon" type="image/png" href={FaviconConstants.URL} sizes="16x16"/>
        </Helmet>;
    };

    const renderInfoCards = () => {
        return <div className="row card-deck">
            <div className="col-md-4 col-xs-12">
                {renderAboutMeCard()}
            </div>
            <div className="col-md-4 col-xs-12">
                {renderInterestsCard()}
            </div>
            <div className="col-md-4 col-xs-12">
                {renderReadingsCard()}
            </div>
        </div>;
    };

    const renderAboutMeCard = () => {
        const title = <span>About me <i className="fa fa-superpowers"/></span>;

        return <Card title={title} text={StaticData.getAboutMe()}/>;
    };

    const renderInterestsCard = () => {
        const title = <span>Interests <i className="fa fa-gamepad"/></span>;
        const footer = <Link className="text-secondary" to={AppRoutes.LISTS}>Gaming List</Link>;

        return <Card title={title} text={StaticData.getInterests()} footer={footer}/>;
    };

    const renderReadingsCard = () => {
        const title = <span>Reading List <i className="fa fa-book"/></span>;
        const footer = <Link className="text-secondary" to={AppRoutes.LISTS}>Reading List</Link>;

        return <Card title={title} text={StaticData.getReadingsListDesc()} footer={footer}/>;
    };

    const renderBlogPostsHeading = () => {
        return <div className="row my-3">
            <div className="col-8 col-xs-12"><h3>Articles <i className="fa fa-rocket"/></h3></div>
            <div className="col-4 col-xs-12">
                <Link className="text-secondary pull-right" to={AppRoutes.BLOG}>All articles</Link>
            </div>
        </div>;
    };

    const renderBlogPostCards = () => {
        return <div className="row card-deck">
            {blogPosts.map(blogPost => renderBlogPostCard(blogPost))}
        </div>
    };

    const renderBlogPostCard = (blogPost: BlogPost) => {
        const footer = <a href={AppRoutes.BLOG + "/" + blogPost.name} className="text-secondary">Read More</a>;

        return <div key={blogPost.name} className="col-md-4 col-sm-12">
            <Card title={blogPost.heading} text={blogPost.description} footer={footer}/>
        </div>
    };

    const renderProjectsHeading = () => {
        return <div className="row my-3">
            <div className="col-8 col-xs-12"><h3>Projects <i className="fa fa-code"/></h3></div>
            <div className="col-4 col-xs-12">
                <Link className="text-secondary pull-right" to={AppRoutes.WORK}>See more of my work</Link>
            </div>
        </div>
    };

    const renderProjectCards = () => {
        return <div className="row card-deck">
            <div className="col-md-4 col-sm-12">
                <Card title={"Portfolio website"} text={StaticData.getPortfolioDesc()}/>
            </div>
            {projects.map(project => renderProjectCard(project))}
        </div>;
    };

    const renderProjectCard = (project: Project) => {
        const footer = <a href={project.link} className="text-secondary">Project Repo</a>;

        return <div key={project.name} className="col-md-4 col-sm-12">
            <Card title={project.heading} text={project.description} footer={footer}/>
        </div>
    };
    return <div className="container my-3">
        {renderHead()}
        {renderInfoCards()}
        <hr/>
        {renderBlogPostsHeading()}
        {renderBlogPostCards()}
        <hr/>
        {renderProjectsHeading()}
        {renderProjectCards()}
    </div>;
}

export default HomePage;