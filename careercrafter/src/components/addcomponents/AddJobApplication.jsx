import React, { useState, useEffect } from 'react'
import JobApplicationService from '../../services/JobApplicationService';
import { Link, useNavigate, useParams } from 'react-router-dom';


export const AddJobApplications = () => {
    const [status, setStatus] = useState('');
    const navigate = useNavigate()
    const {jobApplicationId} = useParams()
    const changeTitle=()=>{
        if(jobApplicationId){
            console.log("returned title  update jobApplication .id",{jobApplicationId});
            return <h2 className="text-center">Update job Application</h2>
        }
        else{
            console.log("returned title  add jobApplication");
            return <h2 className="text-center">Add job Application</h2>
        }
    }
    const updateButton=()=>{
        if(jobApplicationId){
            console.log("returned title  update jobApplication .id",{jobApplicationId});
            return <h2 className="text-center">Update </h2>
        }
        else{
            console.log("returned title  add jobApplication");
            return <h2 className="text-center">Add job Application</h2>
        }
    }

    useEffect(() => {
        console.log("useEffect triggered.... ")
        console.log("id value obtained from url using useParams()", jobApplicationId)
        if (jobApplicationId) {
            JobApplicationService.getJobApplicationById(jobApplicationId).then((response) => {
                console.log("Response recieved from getbyid API", JSON.stringify(response.data));
                setStatus(response.data.status);
                console.log("state variable changed. ")
                
            }).catch(error=>{console.log("Error recieved from save api...",error)})
        }
    }, [])
    const saveOrUpdateJobApplication = (e) => {
        e.preventDefault();
        //let emailId=email;
        const jobApplication = { status}
        console.log("JobApplication feed from home:", jobApplication);
        if(jobApplicationId){
            JobApplicationService.updateJobApplicationById(jobApplicationId,jobApplication)
            .then((response) => {
                console.log("response recieved from saved API..." + JSON.stringify(response))
                navigate('/jobApplication')
            }).catch(error => { console.log("error recieved from saved API...", error) });
        }
        else{
        JobApplicationService.addJobApplication(jobApplication).
            then((response) => {
                console.log("response recieved from saved API..." + JSON.stringify(response))
                navigate('/jobApplication')
            }).catch(error => { console.log("error recieved from saved API...", error) });
        }
    }
    
    return ( 
        <div>
            {console.log("Application Rendered.. ")}
            <div className="container">
                <div className="card col-md-6 offset-md-3">
                    {changeTitle()}
                    <div className="card-body">
                        <form>
                            {/* Status of the  text box */}
                            <div className="form-group mb-2">
                                <label className="form-label">Status</label>
                                <input
                                    type="text"
                                    placeholder='Enter the Status of the application'
                                    name="titleJobApplication"
                                    value={status}
                                    className='form-control'
                                    onChange={(e) => { setStatus(e.target.value) }} />
                            </div>
                            {/* submit-button  */}
                            <button onClick={(e) => saveOrUpdateJobApplication(e)} className='btn btn-success'>Save Job Application</button>&nbsp;&nbsp;
                            <Link to="/jobApplication" className='btn btn-danger'>Cancel</Link>
                        </form>
                    </div>
                </div>

            </div>
        </div>
    );
};
