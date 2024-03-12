import axios from "axios"
//sss
export const instance = axios.create({
    baseURL: "http://localhost:8080/",
    headers: {
        Accept: "application/json"
    },
});
export default instance;
