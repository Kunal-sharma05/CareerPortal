import React, { useEffect, useState } from 'react'
import ResumeService from '../services/ResumeService';
import { Link } from 'react-router-dom';

export const ListResume = () => {
    const [resumeArray, setResumeArray] = useState([]);
    const fetchAllResume = () => {
        console.log("fetch All resume method is fired....");
        ResumeService.getAllResumes()
            .then((response) => {
                console.log("response recieved in the fetchAllResume list resume component", JSON.stringify(response.data))
                setResumeArray(response.data);
            }).catch(err => { console.log("error recieved in the fetch all method of list resume component", err) 
        })
    }
    const deleteResumeById = (id) => {
        console.log("delete resume method of list resume is fired");
        ResumeService.deleteResumeById(id)
            .then((response) => {
                console.log("response recieved in the delete resume method of list resume component", JSON.stringify(response.data))
                fetchAllResume();
            }).catch(err => { console.log("error recieved in the deleteResume method of list resume component ", err) })
    }
    useEffect(()=>{
        console.log("use effect of user listing....");
        fetchAllResume();
    },[])
return (
    <div className='container'>
        {console.log("List resume application rendered")}
        <h2 className='text-center'>Resume Data</h2>
        <Link to={`/addResume`} className='btn btn-primary mb-3'>Add Resume</Link>   
        <table className='table table-bordered table-info table-striped'>
            <thead>
                <tr className='table-dark'>
                    <th>File URL</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                {
                    resumeArray.map((resume,key)=><tr key={key}>
                        <td>{resume.fileUrl}</td>
                        <td><Link to={`/resume/update/${resume.resumeId}`} className='btn btn-success'>Update</Link><br />
                        <button className='btn btn-danger' onClick={()=>deleteResumeById(resume.resumeId)}>Delete</button>
                        </td>
                    </tr>)
                }
            </tbody>
        </table>
    </div>
)
}
