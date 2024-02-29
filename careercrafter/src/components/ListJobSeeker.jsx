import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';
import JobSeekerService from '../services/JobSeekerService'

export const ListJobSeeker = () => {
    const [jobSeekerArray,setJobSeekerArray]=useState([]);
    const navigate= useNavigate();
    const fetchAllJobSeekers=()=>{
        console.log("fetch all job seeker method fired......");
        JobSeekerService.getAllJobSeekers()
        .then((response)=>{
            console.log("response recieved from the api",response.data)
            setJobSeekerArray(response.data);
        }).catch(error=>{console.log("Error recieved from saved API...", error)});
    }
    const deleteJobSeekerById=(id)=>{
        console.log("Delete jobSeeker handler fired. Id value recieved = ",id);
        JobSeekerService.deleteEventById(id)
        .then((response) => {
            console.log("response recieved from saved API..." + JSON.stringify(response))
           fetchAllJobSeekers();
        }).catch(error => { console.log("error recieved from saved API...", error) });
    }

  return (
    <div className='container'>
        {console.log("Application rendered in Job seeker")}
        <h2 className='text-center'>JobSeekerData</h2>
        <Link to={`/addJobSeeker`} className='btn btn-primary mb-3'>Add Job Seeker</Link>
        <table className='table table-boredered table-info table-stripped'>
            <thead> 
                <th className='table-dark bg bg-dark text-white'>
                    <tr>Full Name</tr>
                    <tr>professional Details</tr>
                    <tr>educational Details</tr>
                    <tr>Mobile Number</tr>
                    <tr>date of Birth</tr>
                    <tr>Email</tr>
                </th>
            </thead>
            <tbody>
                {
                    jobSeekerArray.map((jobSeeker,key)=><tr key={key}>
                       <td>{jobSeeker.fullName}</td> 
                       <td>{jobSeeker.professionalDetails}</td> 
                       <td>{jobSeeker.educationalDetail}</td> 
                       <td>{jobSeeker.mobileNumber}</td> 
                       <td>{jobSeeker.dateOfBirth}</td> 
                       <td>{jobSeeker.email}</td> 
                       <td><Link to={`/update/${jobSeeker.id}`}className='btn btn-success'>update</Link><br/>
                            <button className='btn btn-danger' onClick={()=>deleteJobSeekerById(jobSeeker.id)}>Delete</button>
                        </td>
                    </tr>
                    )
                }
            </tbody>
        </table>
        <h2></h2>
    </div>
  )
}
