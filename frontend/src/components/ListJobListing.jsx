import React, { useContext, useEffect, useState } from "react";
// import UserService from '../services/UserService';
import { Link, useNavigate } from "react-router-dom";
import JobListingService from "../services/JobListingService";
import { AuthContext } from "./context/AuthProvider";
import EmployerService from "../services/EmployerService";

export const ListJobListing = () => {
  //const [state variable, function that acn change the state varible]
  const navigate = useNavigate()
  const {auth} = useContext(AuthContext)
  const [jobListingArray, setJobListingArray] = useState([]);

  const deleteJobListingById = (id) => {
    console.log("Delete JobListing is fired.....");
    JobListingService.deleteJobListingById(id)
      .then((response) => {
        console.log(
          "response recieved from the API in the List JobListing component...",
          JSON.stringify(response.data)
        );
        fetchAllJobListing();
      })
      .catch((error) => {
        console.log(
          "Error recieved in the list JobListing component in delete JobListing ",
          error
        );
      });
  };
  const fetchAllJobListing = () => {
    console.log("Feth all JobListings is fired");
    if(auth?.userId)
    {
      console
      EmployerService.getEmployerById(auth?.dto?.employer?.employerId, auth)
      .then((response) => {
        console.log(
          "respnse recieved from the APU in the List JobListing...",
          JSON.stringify(response.data.jobListing)
        );
        setJobListingArray(response.data.jobListing);
      })
      .catch((error) => {
        console.log(
          "Error recieved in the list JobListing component in fetch all jobListingr",
          error
        );
      });
    }
    else{
    JobListingService.getAllJobListings()
      .then((response) => {
        console.log(
          "respnse recieved from the APU in the List JobListing...",
          JSON.stringify(response.data)
        );
        setJobListingArray(response.data);
      })
      .catch((error) => {
        console.log(
          "Error recieved in the list JobListing component in fetch all jobListingr",
          error
        );
      });
    }
  };
  useEffect(() => {
    console.log("use effect of job listing....");
    fetchAllJobListing();
  }, []);
  return (
    <div className="h-full w-full container">
      {console.log("JobListing Part Rendered ")}
      <h1 className="text-center bg-gradient-to-r from-rose-100 to-teal-100">Job Listings</h1>
      {auth?.userId?<Link to={`/jobListing/update/${auth?.dto?.employer?.employerId}`} className=" justify-center btn btn-primary w-full">
        PostJobs
      </Link>:<Link to="/addJobListing" className="btn btn-primary mb-3">
        Add JobListing
      </Link> }
      <table className="table table-striped ">
        <thead>
          <tr className="table-dark">
            <th>Requirements</th>
            <th>Descriptions</th>
            <th>Title</th>
            <th>Image URL</th>
            <th>Actions</th>
            <th>JobApplication</th>
          </tr>
        </thead>
        <tbody>
          {jobListingArray.map((jobListing, key) => (
            <tr key={key}>
              <td>{jobListing.requirements}</td>
              <td>{jobListing.description}</td>
              <td>{jobListing.title}</td>
              <td>{jobListing.image}</td>
              <td>
                <Link
                  to={`/jobListing/update/${jobListing.jobListingId}`}
                  className="btn btn-success"
                >
                  update
                </Link>
                <br />
                <button
                  className="btn btn-danger"
                  onClick={() => deleteJobListingById(jobListing.jobListingId)}
                >
                  Delete
                </button>
              </td>
              <td><button
                  className="btn btn-primary bg-black"
                  onClick={() => navigate(`/jobApplications/${jobListing.jobListingId}`)}
                >
                  JobApplication
                </button></td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};
