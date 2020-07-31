import React from 'react'
import Card from "./components/gui/Card";

export default class DummyData {
    static getArticleCardsForHomePage() {
        const cardNos = [1, 2, 3];
        const footer = <a href="#" className="text-secondary">Read More</a>;

        return cardNos.map(cardNo => {
            return <div className="col-md-4 col-sm-12">
                <Card title={"Heading " + cardNo} text={"Description " + cardNo} footer={footer}/>
            </div>
        });
    }

    static getProjectCardsForHomePage() {
        const cardNos = [1, 2];
        const footer = <a href="#" className="text-secondary">Read More</a>;

        return cardNos.map(cardNo => {
            return <div className="col-md-4 col-sm-12">
                <Card title={"Heading " + cardNo} text={"Description " + cardNo} footer={footer}/>
            </div>
        });
    }
}