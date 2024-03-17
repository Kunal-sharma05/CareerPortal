import React from "react";
import { useRef, useState, useEffect, useContext } from "react";
import { AuthContext } from "./context/AuthProvider";
import { Link, useNavigate, useLocation } from "react-router-dom";
import AuthService from "../services/AuthService";
const LoginForm = () => {
  const userRef = useRef();
  const errorRef = useRef();
  const navigate = useNavigate();
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const location = useLocation();
  const from = location?.state?.from?.pathname || "/";

  const [errMsg, setErrMsg] = useState("");
  const [success, setSuccess] = useState(false);

  const { setAuth } = useContext(AuthContext);
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
        console.log("response from login API : " + accessToken);
        console.log("user id", response.data.userDto.userId);
        setAuth({ userId, email, password, accessToken });
        setEmail("");
        setPassword("");
        setSuccess(true);
        if (role === "EMPLOYER"){ navigate("/addEmployer");
        }
        else if(role === "JOB_SEEKER")
          {
           navigate("/addJobSeeker");
        }
        else if (role === "ADMIN") {
          navigate("/user");
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
    <div className="max-w-md mx-auto mt-8 p-6 bg-gradient-to-r from-rose-100 to-teal-100 rounded shadow-md">
      <h2 className="text-2xl mb-4 font-semibold">Login</h2>
      <form onSubmit={handleSubmit}>
        <div className="mb-4">
          <label
            htmlFor="email"
            className="block text-sm font-medium text-gray-700"
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
            className="block text-sm font-medium text-gray-700"
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
          className="w-full py-2 px-4 bg-indigo-600 text-white rounded-md hover:bg-indigo-700 focus:outline-none focus:bg-indigo-700"
        >
          Login
        </button>
      </form>
    </div>
  );
};

export default LoginForm;
