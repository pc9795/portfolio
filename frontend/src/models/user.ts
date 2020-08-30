export default class User {
    constructor(public name: string,
                public email: string,
                public imageUrl: string,
                public emailVerified: boolean,
                public authProvider: string,
                public providerId: string) {
    }
}