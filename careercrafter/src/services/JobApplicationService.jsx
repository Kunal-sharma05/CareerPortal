import axios from "axios";

const BASE_REST_API_URL ="http://localhost:8080/api/jobseekers"
class JobApplicationService{
    getAllJobApplications(){
        return axios.get(BASE_REST_API_URL)
    }
    addJobApplication(user){
        return axios.post(BASE_REST_API_URL,user);
    }
    deleteJobApplication(id)
    {
        return axios.delete(BASE_REST_API_URL +"/"+id);
    }
    getJobApplication(id){
        return axios.get(BASE_REST_API_URL+"/"+id);
    }
    updateJobApplication(id,user)
    {
        return axios.put(BASE_REST_API_URL+"/"+id,user);
    }
}
export default new JobApplicationService();