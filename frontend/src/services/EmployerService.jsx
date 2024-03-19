import axios from "../components/utils/axios";

// import { AuthContext } from "../components/context/AuthProvider";
// import { useContext } from "react";
// const {auth,setAuth} = useContext(AuthContext)
const BASE_REST_API_URL = "api/employers";
class EmployerService {
  getAllEmployers(auth) {
    return axios.get(BASE_REST_API_URL,
      {
      headers:{
          'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods':'GET,PUT,POST,DELETE',
      'Access-Control-Allow-Credentials':true,
       Authorization: `Bearer ${auth?.accessToken}`
      }
      });
  }
  addProfile(id, employer,auth) {
    return axios.put(BASE_REST_API_URL+"/addProfile/"+`${id}`, employer, 
      {
      headers:{
          'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods':'GET,PUT,POST,DELETE',
      'Access-Control-Allow-Credentials':true,
       Authorization: `Bearer ${auth?.accessToken}`
      }
      });
  }
  addEmployer(employer, auth) {
    console.log("access token ", auth.accessToken);
    return axios.post(BASE_REST_API_URL, employer,
      {
        headers:{
            'Access-Control-Allow-Origin': '*',
        'Access-Control-Allow-Methods':'GET,PUT,POST,DELETE',
        'Access-Control-Allow-Credentials':true,
         Authorization: `Bearer ${auth.accessToken}`
        }
    });
  }
  // async getIdByEmail(TokenObj)
  //   {
       
  //       return axios.get(BASE_REST_API_URL+'GetIdByEmail/'+TokenObj.userDto.email,
  //       {
  //           headers:{
  //               'Access-Control-Allow-Origin': '*',
  //           'Access-Control-Allow-Methods':'GET,PUT,POST,DELETE',
  //           'Access-Control-Allow-Credentials':true,
  //            Authorization: `Bearer ${TokenObj.accessToken}`
  //           }
  //       });
  //   }
  deleteEmployerById(id) {
    return axios.delete(BASE_REST_API_URL + "/" + id);
  }
  getEmployerById(id,auth) {
    return axios.get(BASE_REST_API_URL + "/" + id,{
      headers:{
          'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods':'GET,PUT,POST,DELETE',
      'Access-Control-Allow-Credentials':true,
       Authorization: `Bearer ${auth.accessToken}`
      }
  });
  }
  addJob(id,job,auth){
    return axios.put(BASE_REST_API_URL + "/" + id + "/addJob", job,
    {
      headers:{
          'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods':'GET,PUT,POST,DELETE',
      'Access-Control-Allow-Credentials':true,
       Authorization: `Bearer ${auth.accessToken}`
      }
    });

  }
  updateEmployerById(id, employer,auth) {
    return axios.put(BASE_REST_API_URL + "/" + id, employer,
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
export default new EmployerService();
