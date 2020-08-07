import React from 'react'

export default class DummyData {
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