import React, {useState} from 'react';
import {FaviconConstants} from "../../utils/constants";
import {Helmet} from "react-helmet";
import BlogPost from "../../models/blogPost";
import BlogPostsClient from "../../data/blogPostsClient";
import {useMountEffect} from "../../utils/hooks";
import Comments from "../gui/Comments";

export const BlogPostPageContext = React.createContext({} as { blogPost: BlogPost });

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

    const renderBlogPost = (blogPost: BlogPost) => {
        return <div className="row">
            <div className="col-12">
                <h1>{blogPost.heading}</h1>
            </div>
            <div className="col-12 mt-3">
                <p className="font-italic">
                    Created on: {blogPost.createdAt}
                </p>
                <p className="font-italic">
                    {renderBlogTagsForBlogPost(blogPost)}
                </p>
            </div>
            <div className="col-12 text-justify" dangerouslySetInnerHTML={{__html: blogPost.content as string}}/>
        </div>;
    };

    const renderBlogTagsForBlogPost = (blogPost: BlogPost) => {
        return blogPost.blogTags.map(blogTag => {
            return <span key={blogTag.name} className="badge-secondary badge mx-1">{blogTag.name}</span>
        })
    };

    const renderComments = () => {
        return <div className="mt-3">
            <Comments/>
        </div>
    };

    return <div className="container my-3">
        {renderHead()}
        {
            blogPost != null && <BlogPostPageContext.Provider value={{blogPost}}>
                {renderBlogPost(blogPost)}
                {renderComments()}
            </BlogPostPageContext.Provider>
        }
    </div>

}

export default BlogPostPage;