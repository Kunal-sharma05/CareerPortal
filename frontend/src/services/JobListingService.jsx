import axios from "axios";

const BASE_REST_API_URL = "http://localhost:8080/api/jobListings";
class JobListingService {
  getAllJobListings() {
    return axios.get(BASE_REST_API_URL);
  }
  addJobListing(jobListing) {
    return axios.post(BASE_REST_API_URL, jobListing);
  }
  deleteJobListingById(id) {
    return axios.delete(BASE_REST_API_URL + "/" + id);
  }
  getJobListingById(id) {
    return axios.get(BASE_REST_API_URL + "/" + id);
  }
  updateJobListingById(id, joblisting) {
    return axios.put(BASE_REST_API_URL + "/" + id, joblisting);
  }
}
export default new JobListingService();
