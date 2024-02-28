import axios from "axios";

const BASE_REST_API_URL ="http://localhost:8080/api/jobListings"
class JobListingService{
    getAllJobListings(){
        return axios.get(BASE_REST_API_URL)
    }
    addJobListing(user){
        return axios.post(BASE_REST_API_URL,user);
    }
    deleteJobListing(id)
    {
        return axios.delete(BASE_REST_API_URL +"/"+id);
    }
    getJobListing(id){
        return axios.get(BASE_REST_API_URL+"/"+id);
    }
    updateJobListing(id,user)
    {
        return axios.put(BASE_REST_API_URL+"/"+id,user);
    }
}
export default new JobListingService();