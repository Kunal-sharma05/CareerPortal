import React, { useEffect, useState } from 'react'
import UserService from '../services/UserService';
import { Link } from 'react-router-dom';

export const ListUser = () => {
    //const [state variable, function that acn change the state varible]
    const [userArray,setUserArray]=useState([]);
    useEffect(()=>{
        console.log("use effect of user listing....");
        UserService.getAllUsers().then((response)=>{
            console.log("responsive recieved from the API of user controller ", response.data)
            setUserArray(response.data);
            console.log('Response recieved from api after setting setUserArray',response.data);
        })

    },[])
    return (
    <div className="container">
         {console.log("User Part Rendered ")}
        <h1 className='text-center'>Users</h1>
        <Link to="/addUser" className = "btn btn-primary mb-3">Add User</Link>
        <table className='table table-bordered table-info table-striped'>
            <thead>
                <tr className='table-dark'>
                    <th>Name</th>
                    <th>Email</th>
                    <th>password</th>
                    <th>role</th>                
                </tr>
            </thead>
            <tbody>
                {
                    userArray.map((user,key)=><tr key={key}>
                        <td>{user.name}</td>
                        <td>{user.email}</td>
                        <td>{user.password}</td>
                        <td>{user.role}</td>
                    </tr>
                    )
                }
            </tbody>
        </table>
    </div>
  );
};
