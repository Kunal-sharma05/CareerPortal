import React, { useState, useEffect, useContext } from "react";
import JobApplicationService from "../../services/JobApplicationService";
import { Link, useNavigate, useParams } from "react-router-dom";
import { AuthContext } from "../context/AuthProvider";

export const AddJobApplications = () => {
  const [status, setStatus] = useState("");
  const navigate = useNavigate();
  const {auth} = useContext(AuthContext)
  const { id } = useParams();
  const changeTitle = () => {
    if (id) {
      console.log("returned title  update jobApplication .id", {
        id,
      });
      return <h2 className="text-center">Update job Application</h2>;
    } else {
      console.log("returned title  add jobApplication");
      return <h2 className="text-center">Add job Application</h2>;
    }
  };
  const updateButton = () => {
    if (id) {
      console.log("returned title  update jobApplication .id", {
        id,
      });
      return <h2 className="text-center">Update </h2>;
    } else {
      console.log("returned title  add jobApplication");
      return <h2 className="text-center">Add job Application</h2>;
    }
  };

  useEffect(() => {
    console.log("useEffect triggered.... ");
    console.log(
      "id value obtained from url using useParams()",id);
    if (id) {
      JobApplicationService.getJobApplicationById(id)
        .then((response) => {
          console.log(
            "Response recieved from getbyid API",
            JSON.stringify(response.data)
          );
          setStatus(response.data.status);
          console.log("state variable changed. ");
        })
        .catch((error) => {
          console.log("Error recieved from save api...", error);
        });
    }
  }, []);
  const saveOrUpdateJobApplication = (e) => {
    e.preventDefault();
    //let emailId=email;
    const jobApplication = { status };
    console.log("JobApplication feed from home:", jobApplication);
    if (id) {
      JobApplicationService.updateJobApplicationById(
        id,
        jobApplication
      )
        .then((response) => {
          console.log(
            "response recieved from saved API..." + JSON.stringify(response)
          );
          if(auth?.role==="JOB_SEEKER" && auth?.role==="ADMIN" )
          navigate(`/jobApplication`);
        else{
          navigate(`/PersonProfile/${auth?.dto?.employer?.employerId}`);
        }
        })
        .catch((error) => {
          console.log("error recieved from saved API...", error);
        });
    } else {
      JobApplicationService.addJobApplication(jobApplication)
        .then((response) => {
          console.log(
            "response recieved from saved API..." + JSON.stringify(response)
          );
          navigate("/jobApplication");
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
                <label className="form-label">Status</label>
                <input
                  type="text"
                  placeholder="Enter the Status of the application"
                  name="titleJobApplication"
                  value={status}
                  className="form-control"
                  onChange={(e) => {
                    setStatus(e.target.value);
                  }}
                />
              </div>
              {/* submit-button  */}
              <button
                onClick={(e) => saveOrUpdateJobApplication(e)}
                className="btn btn-success"
              >
                Save Job Application
              </button>
              &nbsp;&nbsp;
              <Link to="/jobApplication" className="btn btn-danger">
                Cancel
              </Link>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};
