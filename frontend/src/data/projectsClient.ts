import {API_URL} from "../utils/constants";
import axios from 'axios';
import ApiClientUtils from "../utils/apiClientUtils";
import Project from "../models/project";

const RESOURCE_URL = API_URL + "/projects";

export default class ProjectsClient {
    static async getAll(page: number, size: number): Promise<Page<Project>> {
        const url = ApiClientUtils.getPageableURL(new URL(RESOURCE_URL), page, size);
        const res = await axios.get(url.href);

        return res.data;
    }
}