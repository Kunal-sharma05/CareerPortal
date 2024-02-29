import axios from "axios";

const BASE_REST_API_URL ="http://localhost:8080/api/jobseekers"
class JobApplicationService{
    getAllJobApplications(){
        return axios.get(BASE_REST_API_URL)
    }
    addJobApplication(jobApplication){
        return axios.post(BASE_REST_API_URL,jobApplication);
    }
    deleteJobApplicationById(id)
    {
        return axios.delete(BASE_REST_API_URL +"/"+id);
    }
    getJobApplicationById(id){
        return axios.get(BASE_REST_API_URL+"/"+id);
    }
    updateJobApplicationById(id,jobApplication)
    {
        return axios.put(BASE_REST_API_URL+"/"+id,jobApplication);
    }
}
export default new JobApplicationService();