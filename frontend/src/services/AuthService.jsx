import axios from "../components/utils/axios";

const BASE_REST_API_URL = "api/authenticate";//gh
class AuthService {
    postRegister(formData) {
      return axios.post(BASE_REST_API_URL+"/register",formData);
    }
    postLogin(formData) {
        console.log("you are inside post login method")
        return axios.post(BASE_REST_API_URL+"/login",formData);
    }
}

export default new AuthService();