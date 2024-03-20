import axios from "../components/utils/axios";

const BASE_REST_API_URL = "api/jobseekers";
class JobSeekerService {
  getAllJobSeekers() {
    return axios.get(BASE_REST_API_URL + "/getAllJobSeekers");
  }
  addProfile(id, jobSeeker,auth) {
    return axios.put(BASE_REST_API_URL+"/addProfile/"+`${id}`, jobSeeker, 
      {
      headers:{
          'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods':'GET,PUT,POST,DELETE',
      'Access-Control-Allow-Credentials':true,
       Authorization: `Bearer ${auth?.accessToken}`
      }
      });
  }
  addJobSeeker(jobSeeker,auth) {
    return axios.post(BASE_REST_API_URL, jobSeeker,
      {
        headers:{
            'Access-Control-Allow-Origin': '*',
        'Access-Control-Allow-Methods':'GET,PUT,POST,DELETE',
        'Access-Control-Allow-Credentials':true,
         Authorization: `Bearer ${auth.accessToken}`
        }
    });
  }
  deleteJobSeekerById(id) {
    return axios.delete(BASE_REST_API_URL + "/" + id);
  }
  getJobSeekerById(id) {
    return axios.get(BASE_REST_API_URL + "/" + id);
  }
  updateJobSeekerById(id, jobSeeker) {
    return axios.put(BASE_REST_API_URL + "/" + id, jobSeeker,
    // {
    //   headers:{
    //       'Access-Control-Allow-Origin': '*',
    //   'Access-Control-Allow-Methods':'GET,PUT,POST,DELETE',
    //   'Access-Control-Allow-Credentials':true,
    //    Authorization: `Bearer ${auth.accessToken}`
    //   }
    // }
    );
  }
  searchByDetails(details){
    return axios.get(BASE_REST_API_URL+"/searchByDetails?details="+details);//ss
  }
  addResume(id,resume)
  {
    return axios.put(BASE_REST_API_URL+"/addResume/"+id,resume)
  }
  addJobApplication(Id,jobApplication,jobId)
  {
    return axios.put(BASE_REST_API_URL+"/addJobApplication/"+Id+"/"+jobId,jobApplication)
  }
}
export default new JobSeekerService();
