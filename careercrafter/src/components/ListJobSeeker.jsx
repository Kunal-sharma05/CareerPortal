import React, { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import JobSeekerService from "../services/JobSeekerService";

export const ListJobSeeker = () => {
  const [jobSeekerArray, setJobSeekerArray] = useState([]);
  const navigate = useNavigate();
  const fetchAllJobSeekers = () => {
    console.log("fetch all job seeker method fired......");
    JobSeekerService.getAllJobSeekers()
      .then((response) => {
        console.log("response recieved from the api", response.data);
        setJobSeekerArray(response.data);
      })
      .catch((error) => {
        console.log("Error recieved from saved API...", error);
      });
  };
  const deleteJobSeekerById = (id) => {
    console.log("Delete jobSeeker handler fired. Id value recieved = ", id);
    JobSeekerService.deleteJobSeekerById(id)
      .then((response) => {
        console.log(
          "response recieved from saved API..." + JSON.stringify(response.data)
        );
        fetchAllJobSeekers();
      })
      .catch((error) => {
        console.log("error recieved from saved API...", error);
      });
  };
  useEffect(() => {
    console.log("use effect of user listing....");
    fetchAllJobSeekers();
  }, []);

  return (
    <div className="container">
      {console.log("Application rendered in Job seeker")}
      <h2 className="text-center">JobSeekerData</h2>
      <Link to={`/addJobSeeker`} className="btn btn-primary mb-3">
        Add Job Seeker
      </Link>
      <table className="table table-boredered table-info table-stripped">
        <thead>
          <tr className="table-dark bg bg-dark text-white">
            <th>Full Name</th>
            <th>professional Details</th>
            <th>educational Details</th>
            <th>Mobile Number</th>
            <th>date of Birth</th>
            <th>Email</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {jobSeekerArray.map((jobSeeker, key) => (
            <tr key={key}>
              <td>{jobSeeker.fullName}</td>
              <td>{jobSeeker.professionalDetails}</td>
              <td>{jobSeeker.educationalDetail}</td>
              <td>{jobSeeker.mobileNumber}</td>
              <td>{jobSeeker.dateOfBirth}</td>
              <td>{jobSeeker.email}</td>
              <td>
                <Link
                  to={`/jobSeeker/update/${jobSeeker.jobSeekerId}`}
                  className="btn btn-success"
                >
                  Update
                </Link>
                <br />
                <button
                  className="btn btn-danger"
                  onClick={() => deleteJobSeekerById(jobSeeker.jobSeekerId)}
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      <h2></h2>
    </div>
  );
};
