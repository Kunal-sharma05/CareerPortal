import React, { useState } from 'react'
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
            }).catch(err => { console.log("error recieved in the fetch all method of list resume component", err) })
    }
    const deleteResumeById = () => {
        console.log("delete resume method of list resume is fired");
        ResumeService.deleteResumeById(id)
            .then((response) => {
                console.log("response recieved in the delete resume method of list resume component", JSON.stringify(response.data))
                fetchAllResume();
            }).catch(err => { console.log("error recieved in the deleteResume method of list resume component ", err) })
    }
return (
    <div className='container'>
        {console.log("List resume application rendered")}
        <h2 className='text-center'>Resume Data</h2>
    </div>
)
}
