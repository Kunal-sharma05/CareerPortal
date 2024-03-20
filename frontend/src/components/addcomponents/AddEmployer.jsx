import React, { useState, useEffect, useContext } from "react";
import EmployerService from "../../services/EmployerService";
import { Link, useNavigate, useParams } from "react-router-dom";
import {AuthContext} from "../context/AuthProvider";
import { Header } from "../Header";
import { Footer } from "../Footer";
import { SideNav } from "../templates/SideNav";

export const AddEmployer = () => {
  const {auth,setAuth} = useContext(AuthContext)
  const [fullName, setFullName] = useState("");
  const [companyName, setCompanyName] = useState("");
  const [mobileNo, setMobileNo] = useState("");
  const [email, setEmail] = useState("");
  const [image, setImage] = useState("");
  const navigate = useNavigate();
  const { id } = useParams();
  const changeTitle = () => {
    if (id) {
      console.log("returned fullname  update event .id", { id });
      return <h2 className="text-center">Update Profile</h2>;
    } else {
      console.log("returned fullname  add event");
      return <h2 className="text-center">Profile Details</h2>;
    }
  };
  const updateButton = () => {
    if (id) {
      console.log("returned fullname  update event .id", { id });
      return <h2 className="text-center">Update </h2>;
    } else {
      console.log("returned fullname  add event");
      return <h2 className="text-center">Add Employer</h2>;
    }
  };

  useEffect(() => {
    console.log("useEffect triggered.... ");
    console.log("id value obtained from url using useParams()", id);
    if (id) {
      EmployerService.getEmployerById(id, auth)
        .then((response) => {
          console.log(
            "Response recieved from getEmployerbyid API",
            JSON.stringify(response.data)
          );
          setFullName(response.data.fullName);
          setCompanyName(response.data.companyName);
          setMobileNo(response.data.mobileNo);
          setEmail(response.data.email);
          setImage(response.data.image);
          console.log("state variable changed. ");
        })
        .catch((error) => {
          console.log("Error recieved from save api...", error);
        });
    }
  }, []);
  const saveOrUpdateEmployer = (e) => {
    e.preventDefault();
    //let emailId=email;
    console.log("access token", auth)
    const employer = { fullName, companyName, mobileNo, email, image};
    console.log("Employer feed from home:", employer);
    if (id) {
      EmployerService.updateEmployerById(id, employer, auth)
        .then((response) => {
          console.log(
            "response recieved from saved API..." + JSON.stringify(response)
          );
          if(auth.role==="ADMIN")
          navigate("/employer");
        else
        navigate(`/PersonProfile/${id}`)
        })
        .catch((error) => {
          console.log("error recieved from saved API...", error);
        });
    } 
    else if(auth?.userId){
      console.log("auth inside add employefr line 75", auth)
      EmployerService.addProfile(auth?.userId, employer, auth)
        .then((response) => {
          console.log(
            "response recieved from saved API..." + JSON.stringify(response)
          );
          navigate(`/PersonProfile/${auth?.dto?.employer?.employerId}`);
        })
        .catch((error) => {
          alert(" email duplicate unsucessfull")
          console.log("error recieved from saved API...", error);
        });
    }
    else {
      console.log("access token", auth)
      EmployerService.addEmployer(employer,auth)
        .then((response) => {
          console.log(
            "response recieved from saved API..." + JSON.stringify(response)
          );
          navigate("/employer");
        })
        .catch((error) => {
          console.log("error recieved from saved API...", error);
        });
    }
  };

  return (
    <div>
      <Header/>
      {console.log("Application Rendered.. ")}
      <div className="bg-gradient-to-r from-slate-900 via-purple-950 to-slate-900 w-full h-full flex gap-5 ">
      <SideNav/>
      <div className="w-[80%] h-[88%]">
      <div className=" container ">
        <div className="card col-md-6 offset-md-3 bg-gradient-to-r from-rose-100 to-teal-100">
          {changeTitle()}
          <div className="card-body">
            <form>
              {/* Full Name of the event text box */}
              <div className="form-group mb-2">
                <label className="form-label">Full Name of the employer</label>
                <input
                  type="text"
                  placeholder="Enter the full Name of the Employer"
                  name="fullNameEmployer"
                  value={fullName}
                  className="form-control"
                  onChange={(e) => {
                    setFullName(e.target.value);
                  }}
                />
              </div>
              {/* Description of the event text box */}
              <div className="form-group mb-2">
                <label className="form-label">
                  Company name of the Employer
                </label>
                <input
                  type="text"
                  placeholder="Enter the company name of the Employer"
                  name="CompanyNameEmployer"
                  value={companyName}
                  className="form-control"
                  onChange={(e) => {
                    setCompanyName(e.target.value);
                  }}
                />
              </div>
              {/* mobileNo. of the event text box */}
              <div className="form-group mb-2">
                <label className="form-label">
                  Mobile Number of the Employer
                </label>
                <input
                  type="text"
                  placeholder="Enter the mobile number of the Employer"
                  name="Mobile number"
                  value={mobileNo}
                  className="form-control"
                  onChange={(e) => {
                    setMobileNo(e.target.value);
                  }}
                />
              </div>
              {/* Email of the event text box */}
              <div className="form-group mb-2">
                <label className="form-label">Email of the employer</label>
                <input
                  type="text"
                  placeholder="Enter the Email of employer"
                  name="email"
                  value={email}
                  className="form-control"
                  onChange={(e) => {
                    setEmail(e.target.value);
                  }}
                />
              </div>
              {/**Image of the Employer */}
              <div className="form-group mb-2">
                <label className="form-label">Profile Photo URL of the Job seeker</label>
                <input
                  type="text"
                  placeholder="Enter the image URL of the job Seeker"
                  name="image"
                  value={image}
                  className="form-control"
                  onChange={(e) => {
                    setImage(e.target.value);
                  }}
                />
              </div>
              {/* submit-button  */}
              <button
                // onClick={(e) =>saveOrUpdateEmployer(e)}
                onClick={saveOrUpdateEmployer}
                className="btn btn-success"
              >
                Save Employer
              </button>
              &nbsp;&nbsp;
              <Link to="/employer" className=" btn btn-danger ">
                Cancel
              </Link>
            </form>
          </div>
          </div>
        </div>
      </div>
      </div>
      <Footer/>
    </div>
  );
};
