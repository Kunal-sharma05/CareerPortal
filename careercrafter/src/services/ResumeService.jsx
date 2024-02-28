import axios from "axios";

const BASE_REST_API_URL ="http://localhost:8080/api/resumes"
class ResumeService{
    getAllResumes(){
        return axios.get(BASE_REST_API_URL)
    }
    addResume(user){
        return axios.post(BASE_REST_API_URL,user);
    }
    deleteResume(id)
    {
        return axios.delete(BASE_REST_API_URL +"/"+id);
    }
    getResume(id){
        return axios.get(BASE_REST_API_URL+"/"+id);
    }
    updateResume(id,user)
    {
        return axios.put(BASE_REST_API_URL+"/"+id,user);
    }
}
export default new ResumeService();