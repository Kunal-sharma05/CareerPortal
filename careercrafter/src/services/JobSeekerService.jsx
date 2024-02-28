import axios from "axios";

const BASE_REST_API_URL ="http://localhost:8080/api/jobseekers"
class JobSeekerService{
    getAllJobSeekers(){
        return axios.get(BASE_REST_API_URL)
    }
    addJobSeeker(user){
        return axios.post(BASE_REST_API_URL,user);
    }
    deleteJobSeeker(id)
    {
        return axios.delete(BASE_REST_API_URL +"/"+id);
    }
    getJobSeeker(id){
        return axios.get(BASE_REST_API_URL+"/"+id);
    }
    updateJobSeeker(id,user)
    {
        return axios.put(BASE_REST_API_URL+"/"+id,user);
    }
}
export default new JobSeekerService();