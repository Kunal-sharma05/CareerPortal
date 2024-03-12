import axios from "../components/utils/axios";

const BASE_REST_API_URL = "api/users";
class UserService {
  getAllUsers() {
    return axios.get(BASE_REST_API_URL);
  }
  addUser(user) {
    return axios.post(BASE_REST_API_URL, user);
  }
  deleteUserById(id) {
    return axios.delete(BASE_REST_API_URL + "/" + id);
  }
  getUserById(id) {
    return axios.get(BASE_REST_API_URL + "/" + id);
  }
  updateUserById(id, user) {
    return axios.put(BASE_REST_API_URL + "/" + id, user);
  }
}
export default new UserService();
