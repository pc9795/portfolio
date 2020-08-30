import React, {useState} from 'react';
import {FaviconConstants} from "../../utils/constants";
import {Helmet} from "react-helmet";
import BlogPost from "../../models/blogPost";
import BlogPostsClient from "../../data/blogPostsClient";
import {useMountEffect} from "../../utils/hooks";

function BlogPostPage(props: any) {
    const {blogPostName} = props.match.params.name;
    const [blogPost, setBlogPost] = useState(null as null | BlogPost);

    useMountEffect(() => {
        BlogPostsClient.getByName(props.match.params.name).then((data: BlogPost) => setBlogPost(data));
    });

    const renderHead = () => {
        return <Helmet>
            <title>{blogPostName}</title>
            <link rel="icon" type="image/png" href={FaviconConstants.URL} sizes="16x16"/>
        </Helmet>
    };

    const renderBlogPost = (blogPost: null | BlogPost) => {
        if (blogPost == null) {
            return null;
        }

        return <div className="row">
            <div className="col-12">
                <h1>{blogPost.heading}</h1>
            </div>
            <div className="col-12 mt-3">
                <p className="font-italic">
                    Created on: {blogPost.createdAt}
                    {renderBlogTagsForBlogPost(blogPost)}
                </p>
            </div>
            <div className="col-12 text-justify">
                {blogPost.content}
            </div>
        </div>;
    };

    const renderBlogTagsForBlogPost = (blogPost: BlogPost) => {
        return blogPost.blogTags.map(blogTag => {
            return <span key={blogTag.name} className="badge-secondary badge pull-right mx-1">{blogTag.name}</span>
        })
    };

    return <div className="container my-3">
        {renderHead()}
        {renderBlogPost(blogPost)}
    </div>;
}

export default BlogPostPage;