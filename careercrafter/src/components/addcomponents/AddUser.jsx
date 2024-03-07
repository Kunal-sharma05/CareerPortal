import React, { useState, useEffect } from "react";
import UserService from "../../services/UserService";
import { Link, useNavigate, useParams } from "react-router-dom";
import { Button } from "../Button";

export const AddUser = () => {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [role, setRole] = useState("");
  const navigate = useNavigate();
  const { id } = useParams();
  const changeTitle = () => {
    if (id) {
      console.log("returned name  update user .id", { id });
      return <h2 className="text-center">Update user</h2>;
    } else {
      console.log("returned name  add user");
      return <h2 className="text-center">Add user</h2>;
    }
  };
  const updateButton = () => {
    if (id) {
      console.log("returned name  update user .id", { id });
      return <h2 className="text-center">Update </h2>;
    } else {
      console.log("returned name  add user");
      return <h2 className="text-center">Add user</h2>;
    }
  };

  useEffect(() => {
    console.log("useEffect triggered.... ");
    console.log("id value obtained from url using useParams()", id);
    if (id) {
      UserService.getUserById(id)
        .then((response) => {
          console.log(
            "Response recieved from getbyid API",
            JSON.stringify(response.data)
          );
          setName(response.data.name);
          setEmail(response.data.email);
          setPassword(response.data.password);
          setRole(response.data.role);
          console.log("state variable changed. ");
        })
        .catch((error) => {
          console.log("Error recieved from save api...", error);
        });
    }
  }, []);
  const saveOrUpdateUser = (e) => {
    e.preventDefault();
    //let emailId=email;
    const user = { name, email, password, role };
    console.log("User feed from home:", user);
    if (id) {
      UserService.updateUserById(id, user)
        .then((response) => {
          console.log(
            "response recieved from saved API in add user..." +
              JSON.stringify(response.data)
          );
          navigate("/users");
        })
        .catch((error) => {
          console.log("error recieved from saved API...", error);
        });
    } else {
      UserService.addUser(user)
        .then((response) => {
          console.log(
            "response recieved from saved API..." + JSON.stringify(response)
          );
          navigate("/users");
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
              {/* Title of the user text box */}
              <div className="form-group mb-2">
                <label className="form-label">Name of the user</label>
                <input
                  type="text"
                  placeholder="Enter the name of the user"
                  name="titleUser"
                  value={name}
                  className="form-control"
                  onChange={(e) => {
                    setName(e.target.value);
                  }}
                />
              </div>
              {/* Email of the user text box */}
              <div className="form-group mb-2">
                <label className="form-label">Email of the user</label>
                <input
                  type="text"
                  placeholder="Enter the email of the user"
                  name="email"
                  value={email}
                  className="form-control"
                  onChange={(e) => {
                    setEmail(e.target.value);
                  }}
                />
              </div>
              {/* Password of the user text box */}
              <div className="form-group mb-2">
                <label className="form-label">Password of the user</label>
                <input
                  type="password"
                  placeholder="Enter the password of the user"
                  name="Password"
                  value={password}
                  className="form-control"
                  onChange={(e) => {
                    setPassword(e.target.value);
                  }}
                />
              </div>
              {/* max attendees of the user text box */}
              <div className="form-group mb-2">
                <label className="form-label">Role of the user</label>
                <input
                  type="text"
                  placeholder="Enter the role of the user"
                  name="role"
                  value={role}
                  className="form-control"
                  onChange={(e) => {
                    setRole(e.target.value);
                  }}
                />
              </div>
              {/* submit-button  */}
              <button
                onClick={(e) => saveOrUpdateUser(e)}
                className="btn btn-success"
              >
                Save User
              </button>
              &nbsp;&nbsp;
              <Button text="Cancel" color="bg-red-600"></Button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};
