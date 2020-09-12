export default class Logger {
    static log(...messages: any) {
        if (process.env.NODE_ENV !== 'production') {
            console.log(messages)
        }
    }
}