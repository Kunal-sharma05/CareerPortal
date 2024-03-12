import axios from "../components/utils/axios";

const BASE_REST_API_URL = "api/resumes";
class ResumeService {
  getAllResumes() {
    return axios.get(BASE_REST_API_URL);
  }
  addResume(resume) {
    return axios.post(BASE_REST_API_URL, resume);
  }
  deleteResumeById(id) {
    return axios.delete(BASE_REST_API_URL + "/" + id);
  }
  getResumeById(id) {
    return axios.get(BASE_REST_API_URL + "/" + id);
  }
  updateResumeById(id, resume) {
    return axios.put(BASE_REST_API_URL + "/" + id, resume);
  }
}
export default new ResumeService();
