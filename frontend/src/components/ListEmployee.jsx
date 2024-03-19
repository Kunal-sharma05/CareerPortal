import React, { useContext, useEffect, useState } from "react";
// import UserService from '../services/UserService';
import { Link } from "react-router-dom";
import EmployerService from "../services/EmployerService";
import { AuthContext } from "./context/AuthProvider";
export const ListEmployee = () => {
  //const [state variable, function that acn change the state varible]
  const {auth,setAuth} = useContext(AuthContext)
  console.log("auth in list employee", auth)
  const [employeeArray, setEmployeeArray] = useState([]);
  const deleteEmployerById = (id) => {
    console.log("Delete employer is fired.....");
    EmployerService.deleteEmployerById(id)
      .then((response) => {
        console.log(
          "response recieved from the API in the List Employer component...",
          JSON.stringify(response.data),
          "id",
          id
        );
        fetchAllEmployer();
      })
      .catch((error) => {
        console.log(
          "Error recieved in the list employer component in delete employer ",
          error,
          "  id ",
          id
        );
      });
  };
  const fetchAllEmployer = () => {
    console.log("Feth all employers is fired");
    console.log("auth in feth all employee", auth)
    EmployerService.getAllEmployers(auth)
      .then((response) => {
        console.log(
          "respnse recieved from the APU in the List Employer...",
          JSON.stringify(response.data)
        );
        setEmployeeArray(response.data);
      })
      .catch((error) => {
        console.log(
          "Error recieved in the list employer component in fetch all employeer",
          error
        );
      });
  };
  useEffect(() => {
    console.log("use effect of user listing....");
    fetchAllEmployer();
  }, []);
  return (
    <div className="container overflow-auto">
      {console.log("Employer Part Rendered ")}
      <h1 className="text-center">Employers</h1>
      <Link to="/addEmployer" className="btn btn-primary mb-3">
        Add Employer
      </Link>
      <table className="table table-bordered table-info table-striped">
        <thead>
          <tr className="table-dark">
            <th>Full Name</th>
            <th>Company Name</th>
            <th>mobile Number</th>
            <th>Email</th>
            <th>Image URL</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {employeeArray.map((employee, key) => (
            <tr key={key}>
              <td>{employee.fullName}</td>
              <td>{employee.companyName}</td>
              <td>{employee.mobileNo}</td>
              <td>{employee.email}</td>
              <td>{employee.image}</td>
              <td>
                <Link
                  to={`/employee/update/${employee.employerId}`}
                  className="btn btn-success"
                >
                  update
                </Link>
                <br />{" "}
                <button
                  className="btn btn-danger"
                  onClick={() => deleteEmployerById(employee.employerId)}
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
