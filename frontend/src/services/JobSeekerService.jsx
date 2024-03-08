import axios from "axios";

const BASE_REST_API_URL = "http://localhost:8080/api/jobseekers";
class JobSeekerService {
  getAllJobSeekers() {
    return axios.get(BASE_REST_API_URL + "/getAllJobSeekers");
  }
  addJobSeeker(jobSeeker) {
    return axios.post(BASE_REST_API_URL, jobSeeker);
  }
  deleteJobSeekerById(id) {
    return axios.delete(BASE_REST_API_URL + "/" + id);
  }
  getJobSeekerById(id) {
    return axios.get(BASE_REST_API_URL + "/" + id);
  }
  updateJobSeekerById(id, jobSeeker) {
    return axios.put(BASE_REST_API_URL + "/" + id, jobSeeker);
  }
}
export default new JobSeekerService();
