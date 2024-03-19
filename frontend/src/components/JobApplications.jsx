import React, { useContext, useEffect, useState } from "react";
// import UserService from '../services/UserService';
import { Link, useParams } from "react-router-dom";
import JobApplicationService from "../services/JobApplicationService";
import { AuthContext } from "./context/AuthProvider";
import JobListingService from "../services/JobListingService";
import { Header } from "./Header";
import { SideNav } from "./templates/SideNav";
import { Footer } from "./Footer";

export const JobApplications = () => {
  //const [state variable, function that acn change the state varible]
  const [jobApplicationArray, setJobApplicationArray] = useState([]);
  const {auth} = useContext(AuthContext)
  const { id } = useParams()
  const deleteJobApplicationById = (id) => {
    console.log("Delete JobApplication is fired.....");
    JobApplicationService.deleteJobApplicationById(id)
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
    if(auth?.userId)
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
    <div className="h-full w-full ">
      <Header/>
      <div className="bg-gradient-to-r from-slate-900 via-purple-950 to-slate-900 w-full h-full flex gap-5 ">
      <SideNav className="w-[16%]"/>
      <div className="w-[80%] container overflow-auto">
      {console.log("JobApplication Part Rendered ")}
      <h1 className=" text-center" style={{color:"wheat"}}>JobApplications</h1>
      {auth.role==="EMPLOYER"?null:<Link to="/addJobApplication" className="btn btn-primary mb-3">
        Add JobApplication
      </Link>}
      <table className="table table-bordered table-striped">
        <thead>
          <tr className="table-dark">
            <th>Status</th>
            <th>Actions</th>
            <th>Application</th>
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
                  to={`/jobApplication/update/${jobApplication.jobApplicationId}`}
                  className="btn btn-success"
                >
                  update
                </Link>
                <br />
                <button
                  className="btn btn-danger"
                  onClick={() =>
                    deleteJobApplicationById(jobApplication.jobApplicationId)
                  }
                >
                  Delete
                </button>
              </td>
              <td><Link
                  to={`/jobSeekerProfile/${jobApplication.jobApplicationId}`}
                  className="btn btn-success"
                >
                  JobSeeker
                </Link></td>
            </tr>
          ))}
        </tbody>
      </table>
      </div>
    </div>
    <Footer/>
    </div>
  );
};
