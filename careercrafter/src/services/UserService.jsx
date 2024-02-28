import axios from "axios";

const BASE_REST_API_URL ="http://localhost:8080/api/users"
class UserService{
    getAllUsers(){
        return axios.get(BASE_REST_API_URL)
    }
    addUser(user){
        return axios.post(BASE_REST_API_URL,user);
    }
    deleteUser(id)
    {
        return axios.delete(BASE_REST_API_URL +"/"+id);
    }
    getUser(id){
        return axios.get(BASE_REST_API_URL+"/"+id);
    }
    updateUser(id,user)
    {
        return axios.put(BASE_REST_API_URL+"/"+id,user);
    }
}
export default new UserService();