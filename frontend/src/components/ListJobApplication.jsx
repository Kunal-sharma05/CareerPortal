import React, { useContext, useEffect, useState } from "react";
// import UserService from '../services/UserService';
import { Link, useParams } from "react-router-dom";
import JobApplicationService from "../services/JobApplicationService";
import { AuthContext } from "./context/AuthProvider";
import JobListingService from "../services/JobListingService";
import JobSeekerService from "../services/JobSeekerService";

export const ListJobApplication = () => {
  //const [state variable, function that acn change the state varible]
  const [jobApplicationArray, setJobApplicationArray] = useState([]);
  const {auth} = useContext(AuthContext)
  const { id } = useParams()
  const deleteJobApplicationById = (Id) => {
    console.log("Delete JobApplication is fired.....", Id);
    JobApplicationService.deleteJobApplicationById(Id)
      .then((response) => {
        console.log(
          "response recieved from the API in the List JobApplication component...",
          JSON.stringify(response.data)
        );
        fetchAllJobApplication();
      })
      .catch((error) => {
        console.log(
          "Error recieved in the list JobApplication component in delete JobApplication ",
          error
        );
      });
  };
  const fetchAllJobApplication = () => {
    console.log("Feth all JobApplications is fired");
    if(auth?.userId && auth.role ==="EMPLOYER")
    {
      console.log("fetch all job application for particular job listing", id)
      JobListingService.jobApplications(id, auth)
      .then((response) => {
        console.log(
          "respnse recieved from the APU in the List JobListing...",
          JSON.stringify(response.data.jobApplication)
        );
        setJobApplicationArray(response.data.jobApplication);
      })
      .catch((error) => {
        console.log(
          "Error recieved in the list JobListing component in fetch all jobListingr",
          error
        );
      });
    }
    else if(auth?.userId && auth.role ==="JOB_SEEKER")
    {
      console.log("fetch all job application for particular job Seeker", id)
      JobSeekerService.getJobSeekerById(id)
      .then((response) => {
        console.log(
          "respnse recieved from the APU in the List JobListing...",
          JSON.stringify(response.data.jobApplication)
        );
        setJobApplicationArray(response.data.jobApplication);
      })
      .catch((error) => {
        console.log(
          "Error recieved in the list JobListing component in fetch all jobListingr",
          error
        );
      });
    }
    else {
    JobApplicationService.getAllJobApplications()
      .then((response) => {
        console.log(
          "respnse recieved from the APU in the List JobApplication...",
          JSON.stringify(response.data)
        );
        setJobApplicationArray(response.data);
      })
      .catch((error) => {
        console.log(
          "Error recieved in the list JobApplication component in fetch all jobApplicationr",
          error
        );
      });
    }
  };
  useEffect(() => {
    console.log("use effect of user listing....");
    fetchAllJobApplication();
  }, []);
  return (
    <div className="h-full w-full container">
      {console.log("JobApplication Part Rendered ")}
      <h1 className="text-center text-zinc-100">JobApplications</h1>
      {auth.role==="EMPLOYER"||auth.role==="JOB_SEEKER" ?null:<Link to="/addJobApplication" className="btn btn-primary ">
        Add JobApplication
      </Link>}
      <table className="table table-bordered table-info table-striped">
        <thead>
          <tr className="table-dark">
            <th>Status</th>
            <th>Actions</th>
            {auth?.role==="EMPLOYER"?<th>Application</th>:null}
            <th>jobId</th>
          </tr>
        </thead>
        <tbody>
          {jobApplicationArray.map((jobApplication, key) => (
            <tr key={key}>
              {console.log(
                "Job application return after mapping",
                key,
                jobApplication.status
              )}
              <td>{jobApplication.status}</td>
              <td>
              <Link
                  onClick={()=>deleteJobApplicationById(jobApplication.jobApplicationId)}
                  to={`/PersonProfileJobSeeker/${auth?.dto?.jobSeeker?.jobSeekerId}`}
                  className="btn btn-success"
                  
                >
                  delete
                </Link> &nbsp; &nbsp;
                {auth?.role==="EMPLOYER"?<button
                  className=" bg-black text-zinc-100 w-20 rounded-md p-2"
                  onClick={() =>
                    deleteJobApplicationById(jobApplication.jobApplicationId)
                  }
                >
                  Update
                </button>:null}
              </td>
              <td>{jobApplication.id}</td>
              {/* <td>{auth?.role=="EMPLOYER"?<Link
                  to={`/jobSeekerProfile/${jobApplication.jobApplicationId}`}
                  className="btn btn-success"
                >
                  JobSeeker
                </Link>:<Link
                  to={`/jobProfile/${jobApplication.jobApplicationId}`}
                  className="btn btn-success"
                >
                  Job
                </Link>}</td> */}
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};
