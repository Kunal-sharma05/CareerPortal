import React, { useState, useEffect, useContext } from "react";
import ResumeService from "../../services/ResumeService";
import { Link, useNavigate, useParams } from "react-router-dom";
import { AuthContext } from "../context/AuthProvider";
import JobSeekerService from "../../services/JobSeekerService";

export const AddResume = () => {
  const [fileUrl, setFileUrl] = useState("");
  const navigate = useNavigate();
  const { id } = useParams();
  const {auth} = useContext(AuthContext)
  const changeTitle = () => {
    if (id) {
      console.log("returned title  update Resume .id", { id });
      return <h2 className="text-center">Update Resume</h2>;
    } else {
      console.log("returned title  add Resume");
      return <h2 className="text-center">Add Resume</h2>;
    }
  };
  const updateButton = () => {
    if (id) {
      console.log("returned title  update Resume .id", { id });
      return <h2 className="text-center">Update </h2>;
    } else {
      console.log("returned title  add Resume");
      return <h2 className="text-center">Add Resume</h2>;
    }
  };

  useEffect(() => {
    console.log("useEffect triggered.... ");
    
    if (auth?.role==="ADMIN"&&id) {
      console.log("id value obtained from url using useParams()", id);
      ResumeService.getResumeById(id)
        .then((response) => {
          console.log(
            "Response recieved from getbyid API",
            JSON.stringify(response.data)
          );
          setFileUrl(response.data.fileUrl);
          console.log("state variable changed. ");
        })
        .catch((error) => {
          console.log("Error recieved from save api...", error);
        });
    }
  }, []);
  const saveOrUpdateResume = (e) => {
    e.preventDefault();
    //let emailId=email;
    const Resume = { fileUrl };
    console.log("Resume feed from home:", Resume);
    if (id && auth?.userId) {
      console.log("Hi job seeker")
      JobSeekerService.addResume(id, Resume)
        .then((response) => {
          console.log(
            "response recieved from saved API..." + JSON.stringify(response)
          );
          const Id = auth?.dto?.jobSeeker?.jobSeekerId
          navigate(`/PersonProfileJobSeeker/${Id}`);
        })
        .catch((error) => {
          console.log("error recieved from saved API...", error);
        });
    }  
    else
    if (id) {
      ResumeService.updateResumeById(id, Resume)
        .then((response) => {
          console.log(
            "response recieved from saved API..." + JSON.stringify(response)
          );
          navigate("/Resume");
        })
        .catch((error) => {
          console.log("error recieved from saved API...", error);
        });
    } else {
      ResumeService.addResume(Resume)
        .then((response) => {
          console.log(
            "response recieved from saved API in add resume..." + JSON.stringify(response)
          );
          navigate("/Resume");
        })
        .catch((error) => {
          console.log("error recieved from saved API...", error);
        });
    }
  };

  return (
    <div>
      {console.log("Application Rendered.. ")}
      <div className="container">
        <div className="card col-md-6 offset-md-3">
          {changeTitle()}
          <div className="card-body">
            <form>
              {/* Status of the  text box */}
              <div className="form-group mb-2">
                <label className="form-label">File URl</label>
                <input
                  type="text"
                  placeholder="Enter the file URL of the event"
                  name="titleResume"
                  value={fileUrl}
                  className="form-control"
                  onChange={(e) => {
                    setFileUrl(e.target.value);
                  }}
                />
              </div>
              {/* submit-button  */}
              <button
                onClick={(e) => saveOrUpdateResume(e)}
                className="btn btn-success"
              >
                Save Resume
              </button>
              &nbsp;&nbsp;
              <Link to="/Resume" className="btn btn-danger">
                Cancel
              </Link>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};
