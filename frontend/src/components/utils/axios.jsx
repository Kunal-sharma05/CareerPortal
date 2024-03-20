import axios from "axios"
//sss
export const instance = axios.create({
    baseURL: "http://localhost:8080/",
    headers: {
        Accept: "application/json",
        'Access-Control-Allow-Origin': '*',
        'Access-Control-Allow-Methods':'GET,PUT,POST,DELETE',
       // Authorization: "Bearer eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJjc2UuMTkwMzIwMDI3QHNpbGljb24uYWMuaW4iLCJyb2xlIjoiRU1QTE9ZRVIiLCJpYXQiOjE3MTA4MzI2MjAsImV4cCI6MTcxMTQzNzQyMH0.KnSxkkhJWclS7lIkrSl_FpKFAkLwM2oS3JCLf7rSh2xh2jkIP-VYaV7qd7XYCoEg"
        
    },
});
export default instance;
