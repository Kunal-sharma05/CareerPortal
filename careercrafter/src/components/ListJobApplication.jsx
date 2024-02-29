import React, { useEffect, useState } from 'react'
// import UserService from '../services/UserService';
import { Link } from 'react-router-dom';
import JobApplicationService from '../services/JobApplicationService';

export const ListJobApplication = () => {
    //const [state variable, function that acn change the state varible]
    const [jobApplicationArray,setJobApplicationArray]=useState([]);
    const deleteJobApplicationById=(id)=>{
        console.log("Delete JobApplication is fired.....");
        JobApplicationService.deleteJobApplicationById(id).then((response)=>{
            console.log("response recieved from the API in the List JobApplication component...",JSON.stringify(response.data))
            fetchAllJobApplication();
        }).catch(error=>{console.log("Error recieved in the list JobApplication component in delete JobApplication ",error)})
    }
    const fetchAllJobApplication=()=>{
        console.log("Feth all JobApplications is fired");
        JobApplicationService.getAllJobApplications().then((response)=>{
            console.log("respnse recieved from the APU in the List JobApplication...",JSON.stringify(response.data))
            setJobApplicationArray(response.data);
        }).catch(error=>{console.log("Error recieved in the list JobApplication component in fetch all jobApplicationr",error )})
    }
    useEffect(()=>{
        console.log("use effect of user listing....");
        JobApplicationService.getAllJobApplications().then((response)=>{
            console.log("responsive recieved from the API of user controller ", response.data)
            setJobApplicationArray(response.data);
            console.log('Response recieved from api after setting setUserArray',response.data);
        })

    },[])
    return (
    <div className="container">
        {console.log("JobApplication Part Rendered ")}
        <h1 className='text-center'>JobApplications</h1>
        <Link to="/addJobApplications" className = "btn btn-primary mb-3">Add JobApplication</Link>
        <table className='table table-bordered table-info table-striped'>
            <thead>
                <tr className='table-dark'>
                    <th>Status</th>                
                </tr>
            </thead>
            <tbody>
                {
                    jobApplicationArray.map((jobApplication,key)=><tr key={key}>
                        <td>{jobApplication.status}</td>
                        <td><Link to={`/update/${jobApplication.jobApplicationId}`} className='btn btn-success'/>update<br/>
                                <button className="btn btn-danger" onClick={()=>deleteJobApplicationById(jobApplication.jobApplicationId)}>Delete</button>
                       </td>
                    </tr>
                    )
                }
            </tbody>
        </table>
    </div>
  );
};
