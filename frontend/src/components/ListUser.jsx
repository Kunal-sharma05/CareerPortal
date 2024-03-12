import React, { useEffect, useState } from "react";
import UserService from "../services/UserService";
import { Link } from "react-router-dom";

export const ListUser = () => {
  //const [state variable, function that acn change the state varible]
  const [userArray, setUserArray] = useState([]);
  const fetchAllUsers = () => {
    console.log("fetch all users.....");
    UserService.getAllUsers().then((response) => {
      console.log(
        "response recieved from the api in list user component ",
        response.data
      );
      setUserArray(response.data);
    });
  };
  const deleteUserById = (id) => {
    console.log("Delete user handler fired. Id value recieved = ", id);
    UserService.deleteUserById(id)
      .then((response) => {
        console.log(
          "response recieved from saved API" + JSON.stringify(response)
        );
        fetchAllUsers();
      })
      .catch((error) => {
        console.log("error recieved from saved API...", error, id);
      });
  };
  useEffect(() => {
    console.log("use effect of user listing....");
    fetchAllUsers();
  }, []);

  return (
    <div className="container overflow-auto">
      {console.log("User Part Rendered ")}
      <h1 className="text-center">Users</h1>
      <Link to="/addUser" className="btn btn-success mb-3">
        Add User
      </Link>
      <table className="table table-bordered table-striped">
        <thead>
          <tr className="table-dark">
            <th>Name</th>
            <th>Email</th>
            <th>password</th>
            <th>role</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {userArray.map((user, key) => (
            <tr key={key}>
              <td>{user.name}</td>
              <td>{user.email}</td>
              <td>{user.password}</td>
              <td>{user.role}</td>
              <td>
                <Link to={`/update/${user.userId}`} className="btn btn-primary">
                  Update{" "}
                </Link>
                <br />
                <button
                  className="btn btn-danger"
                  onClick={() => deleteUserById(user.userId)}
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
