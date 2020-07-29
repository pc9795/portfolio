export default class Utils {
    static formatLineBreaks(text) {
        return text.replace(/(?:\r\n|\r|\n)/g, '<br/>');
    }
}