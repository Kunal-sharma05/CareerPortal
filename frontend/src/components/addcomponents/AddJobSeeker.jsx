import React, { useState, useEffect, useContext } from "react";
import JobSeekerService from "../../services/JobSeekerService";
import { Link, useNavigate, useParams } from "react-router-dom";
import { SideNav } from "../templates/SideNav";
import { AuthContext } from "../context/AuthProvider";

export const AddJobSeeker = () => {
  const [fullName, setFullName] = useState("");
  const [professionalDetails, setProfessionalDetails] = useState("");
  const [educationDetail, setEducationDetails] = useState("");
  const [mobileNumber, setMobileNumber] = useState("");
  const [dateOfBirth, setDateOfBirth] = useState("");
  const [email, setEmail] = useState("");
  const [image, setImage] = useState("");
  const navigate = useNavigate();
  const { id } = useParams();
  const {auth} = useContext(AuthContext)
  const changeTitle = () => {
    if (id) {
      console.log("returned title  update job seeker .id", { id },educationDetail);
      return <h2 className="text-center">Update Profile</h2>;
    } else {
      console.log("returned title  add Job Seeker");
      return <h2 className="text-center">Profile Details</h2>;
    }
  };
  const updateButton = () => {
    if (id) {
      console.log("returned title  uupdate JobSeeker.id", { id });
      return <h2 className="text-center">Update </h2>;
    } else {
      console.log("returned title  add JobSeeker");
      return <h2 className="text-center">Add Job Seeker</h2>;
    }
  };

  useEffect(() => {
    console.log("useEffect triggered.... ");
    console.log("id value obtained from url using useParams()", id);
    if (id) {
      JobSeekerService.getJobSeekerById(id)
        .then((response) => {
          console.log(
            "Response recieved from getbyid API",
            response.data
          );
          setFullName(response.data.fullName);
          setProfessionalDetails(response.data.professionalDetails);
          setEducationDetails(response.data.educationDetail);
          setMobileNumber(response.data.mobileNumber);
          setDateOfBirth(response.data.dateOfBirth);
          setEmail(response.data.email);
          setImage(response.data.image);
          console.log("state variable changed. ");
        })
        .catch((error) => {
          console.log("Error recieved from save api...", error);
        });
    }
  }, []);
  const saveOrUpdateJobSeeker = (e) => {
    console.log("save or update job seeker function fired");
    e.preventDefault();
    //let emailId=email;
    const jobSeeker = {
      fullName,
      professionalDetails,
      educationDetail,
      mobileNumber,
      dateOfBirth,
      email,
      image,
    };
    console.log("JobSeeker feed from home:", jobSeeker);
    if (id) {
      JobSeekerService.updateJobSeekerById(id, jobSeeker, auth)
        .then((response) => {
          console.log(
            "response recieved from saved API..." + JSON.stringify(response)
          );
        if(auth.role==="ADMIN")
          navigate("/jobSeeker");
        else
        navigate(`/PersonProfileJobSeeker/${id}`)
        })
        .catch((error) => {
          console.log("error recieved from saved API...", error);
        });
    } 
    else if(auth?.userId){
      console.log("auth inside add Job Seeker line 75", auth)
      JobSeekerService.addProfile(auth?.userId, jobSeeker, auth)
        .then((response) => {
          console.log(
            "response recieved from saved API..." + JSON.stringify(response)
          );
          const id = auth?.dto?.jobSeeker?.jobSeekerId
          console.log("Entered id",id)
          navigate(`/PersonProfileJobSeekerId/${id}`);
        })
        .catch((error) => {
          console.log("error recieved from saved API...", error);
        });
    }
    else {
      console.log("access token", auth)
      JobSeekerService.addJobSeeker(jobSeeker,auth)
        .then((response) => {
          console.log(
            "response recieved from saved API..." + JSON.stringify(response)
          );
          navigate("/jobSeeker");
        })
        .catch((error) => {
          console.log("error recieved from saved API...", error);
        });
    }
  };

  return (
    <div className="w-full h-full overflow-auto flex">
      {console.log("Application Rendered.. ")}
      <SideNav></SideNav>
      <div className="container w-full">
        <div className="card col-md-6 offset-md-3 bg-gradient-to-r from-rose-100 to-teal-100">
          {changeTitle()}
          <div className="card-body">
            <form>
              {/* Title of the event text box */}
              <div className="form-group mb-2">
                <label className="form-label">
                  Full Name of the Job seeker
                </label>
                <input
                  type="text"
                  placeholder="Enter the full name of the job seeker"
                  name="fullNameJobSeeker"
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
                  Professional details of the job seeker
                </label>
                <input
                  type="text"
                  placeholder="Enter the professional details of the job seeker"
                  name="professionaldetailsJobSeeker"
                  value={professionalDetails}
                  className="form-control"
                  onChange={(e) => {
                    setProfessionalDetails(e.target.value);
                  }}
                />
              </div>
              {/* Location of the event text box */}
              <div className="form-group mb-2">
                <label className="form-label">
                  educational details of the job seeker
                </label>
                <input
                  type="text"
                  placeholder="Enter the educational details of the job seeker"
                  name="educationDetails"
                  value={educationDetail}
                  className="form-control"
                  onChange={(e) => {
                    setEducationDetails(e.target.value);
                  }}
                />
              </div>
              {/* max attendees of the event text box */}
              <div className="form-group mb-2">
                <label className="form-label">
                  Moblile number of the job seeker
                </label>
                <input
                  type="text"
                  placeholder="Enter the Moblile number of the job seeker "
                  name="mobileNumber"
                  value={mobileNumber}
                  className="form-control"
                  onChange={(e) => {
                    setMobileNumber(e.target.value);
                  }}
                />
              </div>
              {/* Registration fees of the event text box */}
              <div className="form-group mb-2">
                <label className="form-label">
                  Date of Birth of the job Seeker
                </label>
                <input
                  type="date"
                  placeholder="Enter the Date of Birth of the job Seeker"
                  name="Date of Birth "
                  value={dateOfBirth}
                  className="form-control"
                  onChange={(e) => {
                    setDateOfBirth(e.target.value);
                  }}
                />
              </div>
              {/* Email of the job seeker text box */}
              <div className="form-group mb-2">
                <label className="form-label">email of the job Seeker</label>
                <input
                  type="email"
                  placeholder="Enter the email of the job Seeker"
                  name="email "
                  value={email}
                  className="form-control"
                  onChange={(e) => {
                    setEmail(e.target.value);
                  }}
                />
              </div>
              {/*Image of the job Seeker */}
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
                onClick={(e) => saveOrUpdateJobSeeker(e)}
                className="btn btn-success"
              >
                Save JobSeeker
              </button>
              &nbsp;&nbsp;
              <Link to="/jobSeeker" className="btn btn-danger">
                Cancel
              </Link>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};
