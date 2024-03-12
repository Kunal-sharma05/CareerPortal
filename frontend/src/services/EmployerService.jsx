import axios from "../components/utils/axios";

const BASE_REST_API_URL = "api/employers";
class EmployerService {
  getAllEmployers() {
    return axios.get(BASE_REST_API_URL);
  }
  addEmployer(employer) {
    return axios.post(BASE_REST_API_URL, employer);
  }
  deleteEmployerById(id) {
    return axios.delete(BASE_REST_API_URL + "/" + id);
  }
  getEmployerById(id) {
    return axios.get(BASE_REST_API_URL + "/" + id);
  }
  updateEmployerById(id, employer) {
    return axios.put(BASE_REST_API_URL + "/" + id, employer);
  }
}
export default new EmployerService();
