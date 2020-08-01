import React from 'react'
import Card from "./components/gui/Card";
import {AppRoutes} from "./utils/constants";

export default class DummyData {
    static getArticleCardsForHomePage() {
        const cardNos = [1, 2, 3];
        const footer = <a href="#" className="text-secondary">Read More</a>;

        return cardNos.map(cardNo => {
            return <div className="col-md-4 col-sm-12">
                <Card title={"Blog heading " + cardNo} text={"Description " + cardNo} footer={footer}/>
            </div>
        });
    }

    static getProjectCardsForHomePage() {
        const cardNos = [1, 2];
        const footer = <a href="#" className="text-secondary">Read More</a>;

        return cardNos.map(cardNo => {
            return <div className="col-md-4 col-sm-12">
                <Card title={"Project heading " + cardNo} text={"Description " + cardNo} footer={footer}/>
            </div>
        });
    }

    static getBlogPostsForBlogPage() {
        const cardNos = [1, 2, 3, 4, 5];
        return cardNos.map(cardNo => {
            return <div className="row">
                <div className="col-12">
                    <Card title={"Blog heading " + cardNo} text={DummyData._getBlogPostText(cardNo)}/>
                </div>
            </div>
        });
    }

    static _getBlogPostText(index: number) {
        return <span>
            <p className="font-italic">
                Created on: 31-07-2020
                <a href="#" className="badge badge-secondary pull-right mx-1">Blog tag</a>
            </p>
            <p>
                {"Description " + index}
            </p>
            <a className="btn btn-secondary" href={AppRoutes.BLOG + "/sampleBlogPostName"}>Read more</a>
        </span>
    }

    static getBlogTagsForBlogPage() {
        const tags = [1, 2, 3, 4, 5];
        return tags.map(tag => {
            return <a href="#" className="badge badge-secondary mx-1">{"Tag " + tag}</a>
        });
    }

    static getBlogPostForBlogPostPage() {
        return <div className="row">
            <div className="col-12">
                <h1>Blog Post Heading</h1>
            </div>
            <div className="col-12 mt-3">
                <p className="font-italic">
                    Created on: Created on: 31-07-2020
                    <a href="#" className="badge badge-secondary pull-right mx-1">Blog tag</a>
                </p>
            </div>
            <div className="col-12 text-justify">
                Content
            </div>
        </div>;
    }

    static getProjectCardsForWorkPage() {
        const cardNos = [1, 2, 3];
        return cardNos.map(cardNo => {
            return <div className="col-md-4 col-sm-12">
                <Card title={"Work Heading " + cardNo} text="Description"
                      footer={<a href='#' className="text-secondary">Github Link</a>}/>
            </div>
        });
    }

    static getTechnicalBooksListForListsPage() {
        const listNos = [1, 2, 3, 4, 5];

        return listNos.map(listNo => {
            return <li>{"Technical Book " + listNo} <span className="text-secondary">completed on 01 Aug 2020</span>
            </li>
        });
    }

    static getVideogamesListForListsPage() {
        const listNos = [1, 2, 3, 4, 5];

        return listNos.map(listNo => {
            return <li>{"Video game " + listNo} <span className="text-secondary">completed on 01 Aug 2020</span>
            </li>
        });
    }
}