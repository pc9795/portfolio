import React, {useState} from "react";
import {Helmet} from "react-helmet";
import {AppRoutes, FaviconConstants} from "../../utils/constants";
import BlogPost from "../../models/blogPost";
import Card from "../gui/Card";
import BlogPostsClient from "../../data/blogPostsClient";
import BlogTag from "../../models/blogTag";
import {BlogTagsClient} from "../../data/blogTagsClient";
import {useMountEffect} from "../../utils/hooks";

const MONTH_NAMES = ["January", "February", "March", "April", "May", "June",
    "July", "August", "September", "October", "November", "December"
];
const MONTH_THREE_LETTER_NAMES = ["jan", "feb", "mar", "apr", "may", "jun",
    "jul", "aug", "sep", "oct", "nov", "dec"];

function BlogPage() {
    const [blogPosts, setBlogPosts] = useState([] as BlogPost[]);
    const [blogTags, setBlogTags] = useState([] as BlogTag[]);
    const [navigationPerformed, setNavigationPerformed] = useState(false);
    const [searchPerformed, setSearchPeformed] = useState(false);
    const [searchResultsMessage, setSearchResultsMessage] = useState("");
    const [searchText, setSearchText] = useState("");

    useMountEffect(() => {
        BlogPostsClient.getAll().then((data: Page<BlogPost>) => setBlogPosts(data.content));
        BlogTagsClient.getAll().then((data: Page<BlogTag>) => setBlogTags(data.content));
    });

    const renderHead = () => {
        return <Helmet>
            <title>Prashant Chaubey - Blog</title>
            <link rel="icon" type="image/png" href={FaviconConstants.URL} sizes="16x16"/>
        </Helmet>
    };

    const renderAllPostsNavigation = () => {
        if (!navigationPerformed) {
            return null;
        }

        return <div>
            <button className="btn btn-secondary" onClick={() => handleAllPostsNavigationClick()}>
                <i className="fa fa-backward"/> All Posts
            </button>
            {renderSearchResults()}
        </div>
    };

    const renderSearchResults = () => {
        if (!searchPerformed) {
            return null;
        }

        return <div className="alert alert-secondary mt-3">
            {searchResultsMessage}
        </div>
    };

    const handleAllPostsNavigationClick = () => {
        (document.activeElement as HTMLElement).blur();
        setNavigationPerformed(false);
        setSearchPeformed(false);
        BlogPostsClient.getAll().then((data: Page<BlogPost>) => setBlogPosts(data.content));
    };

    const renderBlogPosts = () => {
        return blogPosts.map(blogPost => {
            return <div className="row mt-3" key={blogPost.name}>
                <div className="col-12">
                    <Card title={blogPost.heading} text={renderBlogPost(blogPost)}/>
                </div>
            </div>
        });
    };

    const renderBlogPost = (blogPost: BlogPost) => {
        return <span>
            <p className="font-italic">
                Created on: {blogPost.createdAt}
                {renderBlogTagsForBlogPost(blogPost)}
            </p>
            <p>
                {blogPost.description}
            </p>
            <a className="btn btn-secondary" href={AppRoutes.BLOG + `/${blogPost.name}`}>Read more</a>
        </span>
    };

    const renderBlogTagsForBlogPost = (blogPost: BlogPost) => {
        return blogPost.blogTags.map(blogTag => {
            return <button key={blogTag.name} onClick={() => handleBlogTagClick(blogTag.name)}
                           className="btn btn-sm btn-secondary pull-right mx-1">{blogTag.name}</button>
        })
    };

    const renderSearchArea = () => {
        return <div className="col-12">
            <div className="row">
                <div className="col-8">
                    <input name="search" className="form-control"
                           onChange={(event) => setSearchText(event.target.value)} value={searchText} type="text"/>
                </div>
                <div className="col-4">
                    <button onClick={() => handleSearchClick()} className="btn btn-secondary">
                        Search
                    </button>
                </div>
            </div>
        </div>;
    };

    const handleSearchClick = () => {
        (document.activeElement as HTMLElement).blur();
        BlogPostsClient.search(searchText).then((data: Page<BlogPost>) => {
            setBlogPosts(data.content);
            setNavigationPerformed(true);
            setSearchPeformed(true);
            setSearchResultsMessage(generateSearchResultsMessage(data.content.length));
            setSearchText("");
        });
    };

    const generateSearchResultsMessage = (searchResultCount: number) => {
        switch (searchResultCount) {
            case 0:
                return "No results found";
            case 1:
                return "1 result found";
            default:
                return `${searchResultCount} results found`;
        }
    };

    const renderBlogTags = () => {
        return <div className="col-12 mt-3">
            <h2>Tags</h2>
            {blogTags.map(blogTag => renderBlogTag(blogTag))}
        </div>
    };

    const renderBlogTag = (blogTag: BlogTag) => {
        return <button key={blogTag.name} className="btn btn-sm btn-secondary mx-1"
                       onClick={() => handleBlogTagClick(blogTag.name)}>{blogTag.name}</button>
    };

    const handleBlogTagClick = (blogTagName: string) => {
        (document.activeElement as HTMLElement).blur();
        setNavigationPerformed(true);
        BlogPostsClient.getByTagName(blogTagName).then((data: Page<BlogPost>) => {
            setBlogPosts(data.content);
        });
    };

    const renderArchiveList = () => {
        return <div className="col-12 mt-3">
            <h2>Archives</h2>
            <ul>
                {getArchiveListItems().map(listItem => {
                    return listItem
                })}
            </ul>
        </div>
    };

    const getArchiveListItems = () => {
        const currDate = new Date();
        const currYear = currDate.getFullYear();
        const prevYear = currYear - 1;

        let archiveListItems = [];
        archiveListItems.push(<li key={prevYear}>
            <button type="button" onClick={() => handleYearArchiveListItemClick(prevYear)}
                    className="text-secondary btn btn-link p-0">{prevYear}</button>
        </li>);

        for (let i = 0; i <= currDate.getMonth(); i++) {
            let val = MONTH_NAMES[i] + " " + currYear;
            archiveListItems.push(
                <li key={val}>
                    <button type="button" onClick={() => {
                        handleMonthYearArchiveListItemClick(currYear, i)
                    }} className="text-secondary btn btn-link p-0">{val}</button>
                </li>
            );
        }

        return archiveListItems;
    };

    const handleYearArchiveListItemClick = (year: number) => {
        (document.activeElement as HTMLElement).blur();
        setNavigationPerformed(true);
        BlogPostsClient.getByYear(year.toString()).then((data: Page<BlogPost>) => setBlogPosts(data.content));
    };

    const handleMonthYearArchiveListItemClick = (year: number, month: number) => {
        (document.activeElement as HTMLElement).blur();
        setNavigationPerformed(true);
        BlogPostsClient.getByMonthYear(year.toString(), MONTH_THREE_LETTER_NAMES[month]).then(
            (data: Page<BlogPost>) => setBlogPosts(data.content)
        );
    };

    return <div className="container my-3">
        {renderHead()}
        <div className="row">
            <div className="col-sm-8 col-12">
                {renderAllPostsNavigation()}
                {renderBlogPosts()}
            </div>
            <div className="col-sm-4 col-12">
                <div className="row mt-3">
                    {renderSearchArea()}
                    {renderBlogTags()}
                    {renderArchiveList()}
                </div>
            </div>
        </div>
    </div>;
}

export default BlogPage;