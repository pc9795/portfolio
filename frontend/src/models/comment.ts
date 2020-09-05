export default class Comment {
    constructor(public id: number,
                public upVotes: number,
                public downVotes: number,
                public message: string,
                public commenterName: string,
                public createdAt: string,
                public commenterImageUrl?: string) {
    }
}