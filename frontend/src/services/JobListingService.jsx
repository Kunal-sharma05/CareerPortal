import axios from "../components/utils/axios";

const BASE_REST_API_URL = "api/jobListings";
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
  GetByTitleContainig(title) {
    return axios.get(BASE_REST_API_URL+"/findByTitleContaining"+"?title="+title);
  }
  SearchByTitleAndRequirements(title,requirements){
    return axios.get(BASE_REST_API_URL + "/searchByTitleAndRequirement?title="+title + "&requirements="+requirements);
  }
  jobApplications(id,auth)
  {
    return axios.get(BASE_REST_API_URL + "/" + id,
    {
      headers:{
          'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods':'GET,PUT,POST,DELETE',
      'Access-Control-Allow-Credentials':true,
       Authorization: `Bearer ${auth.accessToken}`
      }
    });
  }
  
}
export default new JobListingService();
