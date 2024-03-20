import React from "react";
import { useRef, useState, useEffect, useContext } from "react";
import { AuthContext } from "./context/AuthProvider";
import { Link, useNavigate, useLocation } from "react-router-dom";
import AuthService from "../services/AuthService";
const LoginForm = () => {
  // document.title = "CareerCrafter | Login";
  const userRef = useRef();
  const errorRef = useRef();
  const navigate = useNavigate();
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const [errMsg, setErrMsg] = useState("");
  const [success, setSuccess] = useState(false);

  const{auth,setAuth}=useContext(AuthContext)
  useEffect(() => {
    userRef?.current?.focus();
  }, []);
  

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(
      "username and password received from login form :" +
        email +
        " " +
        password
    );
    const userlogindata = { email: email, password: password };
    AuthService.postLogin(userlogindata)
      .then((response) => {
        console.log(
          "response from login API : " + JSON.stringify(response.data)
        );
        const accessToken = response.data.accessToken;
        const userId = response.data.userDto.userId;
        const role = response.data.userDto.role;
        const dto = response.data.userDto;
        console.log("response from login API : " + accessToken);
        console.log("user id", response.data.userDto.userId);
        setAuth({userId, email, password, accessToken, role, dto} );
       // console.log(auth)
        setEmail("");
        setPassword("");
        setSuccess(true);
        console.log("dto employer", dto.employer);
        if (role === "EMPLOYER" && dto.employer !== null) {
          console.log("no navigate 1") 
          navigate(`/PersonProfile/${dto.employer.employerId}`);
      } else if (role === "JOB_SEEKER" && dto.jobSeeker !== null) {
        console.log("no navigate 2")
        console.log("dto employer", dto.jobSeeker);
          navigate(`/PersonProfileJobSeeker/${dto.jobSeeker.jobSeekerId}`);
      } else if (role === "ADMIN") {
        console.log("no navigate 3")
          navigate("/user");
      } else if (role === "EMPLOYER") {
          console.log("no navigate 4")
          navigate("/addEmployer");
      } else if (role === "JOB_SEEKER") {
        console.log("no navigate 5")
          navigate("/addJobSeeker");
      }
      })
      .catch((error) => {
        console.log(error);
        if (!error?.response) {
          setErrMsg("No server response");
        } else if (error.response?.status === 400) {
          setErrMsg("username taken");
        } else {
          setErrMsg("Registration failed...");
        }
      });
    setEmail("");
    setPassword("");
    setSuccess(true);
  };

  return (
    <div className="w-[30%] max-w-md mx-auto mt-8 p-6 bg-gradient-to-r from-rose-100 to-teal-100 rounded shadow-md">
      <h2 className="text-2xl mb-4 font-semibold">Login</h2>
      <form onSubmit={handleSubmit}>
        <div className="mb-4">
          <label
            htmlFor="email"
            className="block text-base font-medium text-gray-700"
          >
            Email
          </label>
          <input
            type="email"
            id="email"
            name="email"
            value={email}
            onChange={(e) => {
              setEmail(e.target.value);
            }}
            className="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50"
          />
        </div>
        <div className="mb-4">
          <label
            htmlFor="password"
            className="block text-base font-medium text-gray-700"
          >
            Password
          </label>
          <input
            type="password"
            id="password"
            name="password"
            value={password}
            onChange={(e) => {
              setPassword(e.target.value);
            }}
            className="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50"
          />
        </div>
        <button
          type="submit"
          className="w-full py-2 px-4 bg-black text-white rounded-md hover:bg-indigo-700 focus:outline-none focus:bg-indigo-700"
        >
          Login
        </button>
      </form>
    </div>
  );
};

export default LoginForm;
