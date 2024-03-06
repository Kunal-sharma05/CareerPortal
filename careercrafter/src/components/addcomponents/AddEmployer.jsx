import React, { useState, useEffect } from "react";
import EmployerService from "../../services/EmployerService";
import { Link, useNavigate, useParams } from "react-router-dom";

export const AddEmployer = () => {
  const [fullName, setFullName] = useState("");
  const [companyName, setCompanyName] = useState("");
  const [mobileNo, setMobileNo] = useState("");
  const [email, setEmail] = useState("");
  const navigate = useNavigate();
  const { id } = useParams();
  const changeTitle = () => {
    if (id) {
      console.log("returned fullname  update event .id", { id });
      return <h2 className="text-center">Update event</h2>;
    } else {
      console.log("returned fullname  add event");
      return <h2 className="text-center">Add event</h2>;
    }
  };
  const updateButton = () => {
    if (id) {
      console.log("returned fullname  update event .id", { id });
      return <h2 className="text-center">Update </h2>;
    } else {
      console.log("returned fullname  add event");
      return <h2 className="text-center">Add event</h2>;
    }
  };

  useEffect(() => {
    console.log("useEffect triggered.... ");
    console.log("id value obtained from url using useParams()", id);
    if (id) {
      EmployerService.getEmployerById(id)
        .then((response) => {
          console.log(
            "Response recieved from getEmployerbyid API",
            JSON.stringify(response.data)
          );
          setFullName(response.data.fullName);
          setCompanyName(response.data.companyName);
          setMobileNo(response.data.mobileNo);
          setEmail(response.data.email);
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
    const employer = { fullName, companyName, mobileNo, email };
    console.log("Employer feed from home:", employer);
    if (id) {
      EmployerService.updateEmployerById(id, employer)
        .then((response) => {
          console.log(
            "response recieved from saved API..." + JSON.stringify(response)
          );
          navigate("/employer");
        })
        .catch((error) => {
          console.log("error recieved from saved API...", error);
        });
    } else {
      EmployerService.addEmployer(employer)
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
      {console.log("Application Rendered.. ")}
      <div className="container">
        <div className="card col-md-6 offset-md-3">
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
              {/* submit-button  */}
              <button
                onClick={(e) => saveOrUpdateEmployer(e)}
                className="btn btn-success"
              >
                Save Employer
              </button>
              &nbsp;&nbsp;
              <Link to="/employer" className="btn btn-danger">
                Cancel
              </Link>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};
