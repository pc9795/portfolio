class BlogPost {
    constructor(public name: string,
                public heading: string,
                public description: string,
                public createdAt: string,
                public blogTags: BlogTag[],
                public content?: string
    ) {
    }
}