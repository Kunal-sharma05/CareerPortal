import React, { useState, useEffect, useContext } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import JobListingService from "../../services/JobListingService";
import { AuthContext } from "../context/AuthProvider";
import EmployerService from "../../services/EmployerService";


export const AddJobListing = () => {
  document.title = "CareerCrafter | Post Job";
  const [requirements, setRequirements] = useState("");
  const [description, setDescription] = useState("");
  const [title, setTitle] = useState("");
  const [image, setImage] = useState("");
  const navigate = useNavigate();
  const{auth}=useContext(AuthContext)
  const { id } = useParams();
  const changeTitle = () => {
    if (id) {
      console.log("returned title  update event .id", { id });
      return <h2 className="text-center">Update Job LIsting</h2>;
    } else {
      console.log("returned title  add event");
      return <h2 className="text-center">Post Job</h2>;
    }
  };
  const updateButton = () => {
    if (id) {
      console.log("returned title  update event .id", { id });
      return <h2 className="text-center">Update </h2>;
    } else {
      console.log("returned title  add event");
      return <h2 className="text-center">Post Jobs</h2>;
    }
  };

  useEffect(() => {
    console.log("useEffect triggered.... ");
    console.log("id value obtained from url using useParams()", id);
    if (auth?.role==="ADMIN"&&id) {
      JobListingService.getJobListingById(id)
        .then((response) => {
          console.log(
            "Response recieved from getbyid API",
            JSON.stringify(response.data)
          );
          setTitle(response.data.title);
          setDescription(response.data.description);
          setRequirements(response.data.requirements);
          setImage(response.data.image)
          console.log("state variable changed. ");
        })
        .catch((error) => {
          console.log("Error recieved from save api...", error);
        });
    }
  }, []);
  const saveOrUpdateJobListing = (e) => {
    e.preventDefault();
    //let emailId=email;
    const jobListing = { requirements, description, title, image};
    console.log("Event feed from home:", jobListing);
    if (id && auth?.userId) {
      EmployerService.addJob(id, jobListing,auth)
        .then((response) => {
          console.log(
            "response recieved from saved API..." + JSON.stringify(response)
          );
          navigate(`/PersonProfile/${id}`);
        })
        .catch((error) => {
          console.log("error recieved from saved API...", error);
        });
    }   
    else if(id) {
      JobListingService.updateJobListingById(id, jobListing)
        .then((response) => {
          console.log(
            "response recieved from saved API..." + JSON.stringify(response)
          );
          navigate("/jobListing");
        })
        .catch((error) => {
          console.log("error recieved from saved API...", error);
        });
    }
    else
    {
      JobListingService.addJobListing(jobListing)
        .then((response) => {
          console.log(
            "response recieved from saved API..." + JSON.stringify(response)
          );
          navigate("/jobListing");
        })
        .catch((error) => {
          console.log("error recieved from saved API...", error);
        });
    }
  };

  return (
    <div className="w-[84%]">
      {console.log("Application Rendered.. ")}
      <div className="container">
        <div className="card col-md-6 offset-md-3  bg-gradient-to-r from-rose-100 to-teal-100">
          {changeTitle()}
          <div className="card-body">
            <form>
              {/* Title of the event text box */}
              <div className="form-group mb-2">
                <label className="form-label">Title of the job</label>
                <input
                  type="text"
                  placeholder="Enter the title of the event"
                  name="titleEvent"
                  value={title}
                  className="form-control"
                  onChange={(e) => {
                    setTitle(e.target.value);
                  }}
                />
              </div>
              {/* Description of the event text box */}
              <div className="form-group mb-2">
                <label className="form-label">Description of the Job</label>
                <input
                  type="text"
                  placeholder="Enter the description of the event"
                  name="descriptionEvent"
                  value={description}
                  className="form-control"
                  onChange={(e) => {
                    setDescription(e.target.value);
                  }}
                />
              </div>
              {/* Requirements of the event text box */}
              <div className="form-group mb-2">
                <label className="form-label">Requirements of the job</label>
                <input
                  type="text"
                  placeholder="Enter the requirements of the job"
                  name="requirements"
                  value={requirements}
                  className="form-control"
                  onChange={(e) => {
                    setRequirements(e.target.value);
                  }}
                />
              </div>
              <div className="form-group mb-2">
                <label className="form-label">Image URL of the Company</label>
                <input
                  type="text"
                  placeholder="Enter the image URL of the company"
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
                onClick={(e) => saveOrUpdateJobListing(e)}
                className="btn btn-success"
              >
                Post Job
              </button>
              &nbsp;&nbsp;
              <Link to="/jobListing" className="btn btn-danger">
                Cancel
              </Link>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};
