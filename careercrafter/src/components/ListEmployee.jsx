import React, { useEffect, useState } from 'react'
import UserService from '../services/UserService';
import { Link } from 'react-router-dom';
import EmployerService from '../services/EmployerService';

export const ListEmployee = () => {
    //const [state variable, function that acn change the state varible]
    const [employeeArray,setEmployeeArray]=useState([]);
    useEffect(()=>{
        console.log("use effect of user listing....");
        EmployerService.getAllEmployers().then((response)=>{
            console.log("responsive recieved from the API of user controller ", response.data)
            setEmployeeArray(response.data);
            console.log('Response recieved from api after setting setUserArray',response.data);
        })

    },[])
    return (
    <div className="container">
        {console.log("Employer Part Rendered ")}
        <h1 className='text-center'>Employers</h1>
        <Link to="/addEmployers" className = "btn btn-primary mb-3">Add Employer</Link>
        <table className='table table-bordered table-info table-striped'>
            <thead>
                <tr className='table-dark'>
                    <th>Full Name</th>
                    <th>Company Name</th>
                    <th>mobile Number</th>
                    <th>Email</th>                
                </tr>
            </thead>
            <tbody>
                {
                    employeeArray.map((employee,key)=><tr key={key}>
                        <td>{employee.fullName}</td>
                        <td>{employee.companyName}</td>
                        <td>{employee.mobileNo}</td>
                        <td>{employee.email}</td>
                    </tr>
                    )
                }
            </tbody>
        </table>
    </div>
  );
};
