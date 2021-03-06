import BlogTag from './blogTag'

export default class BlogPost {
    constructor(public id: number,
                public name: string,
                public heading: string,
                public description: string,
                public createdAt: string,
                public blogTags: BlogTag[],
                public content?: string
    ) {
    }
}