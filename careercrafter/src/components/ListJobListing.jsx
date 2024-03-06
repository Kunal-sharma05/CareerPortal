import React, { useEffect, useState } from "react";
// import UserService from '../services/UserService';
import { Link } from "react-router-dom";
import JobListingService from "../services/JobListingService";

export const ListJobListing = () => {
  //const [state variable, function that acn change the state varible]
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
  };
  useEffect(() => {
    console.log("use effect of user listing....");
    fetchAllJobListing();
  }, []);
  return (
    <div className="container">
      {console.log("JobListing Part Rendered ")}
      <h1 className="text-center">JobListings</h1>
      <Link to="/addJobListing" className="btn btn-primary mb-3">
        Add JobListing
      </Link>
      <table className="table table-bordered table-info table-striped">
        <thead>
          <tr className="table-dark">
            <th>Requirements</th>
            <th>Descriptions</th>
            <th>Title</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {jobListingArray.map((jobListing, key) => (
            <tr key={key}>
              <td>{jobListing.requirements}</td>
              <td>{jobListing.description}</td>
              <td>{jobListing.title}</td>
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
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};
