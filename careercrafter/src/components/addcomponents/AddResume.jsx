import React, { useState, useEffect } from 'react'
import ResumeService from '../services/ResumeService';
import { Link, useNavigate, useParams } from 'react-router-dom';


export const AddResume = () => {
    const [fileUrl, setFileUrl] = useState('');
    const navigate = useNavigate()
    const {ResumeId} = useParams()
    const changeTitle=()=>{
        if(ResumeId){
            console.log("returned title  update Resume .id",{ResumeId});
            return <h2 className="text-center">Update Resume</h2>
        }
        else{
            console.log("returned title  add Resume");
            return <h2 className="text-center">Add Resume</h2>
        }
    }
    const updateButton=()=>{
        if(ResumeId){
            console.log("returned title  update Resume .id",{ResumeId});
            return <h2 className="text-center">Update </h2>
        }
        else{
            console.log("returned title  add Resume");
            return <h2 className="text-center">Add Resume</h2>
        }
    }

    useEffect(() => {
        console.log("useEffect triggered.... ")
        console.log("id value obtained from url using useParams()", ResumeId)
        if (ResumeId) {
            ResumeService.getResumeById(ResumeId).then((response) => {
                console.log("Response recieved from getbyid API", JSON.stringify(response.data));
                setFileUrl(response.data.fileUrl);
                console.log("state variable changed. ")
                
            }).catch(error=>{console.log("Error recieved from save api...",error)})
        }
    }, [])
    const saveOrUpdateResume = (e) => {
        e.preventDefault();
        //let emailId=email;
        const Resume = { fileUrl}
        console.log("Resume feed from home:", Resume);
        if(ResumeId){
            ResumeService.updateResumeById(ResumeId,Resume)
            .then((response) => {
                console.log("response recieved from saved API..." + JSON.stringify(response))
                navigate('/Resume')
            }).catch(error => { console.log("error recieved from saved API...", error) });
        }
        else{
        ResumeService.addResume(Resume).
            then((response) => {
                console.log("response recieved from saved API..." + JSON.stringify(response))
                navigate('/Resume')
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
                                    placeholder='Enter the title of the event'
                                    name="titleResume"
                                    value={fileUrl}
                                    className='form-control'
                                    onChange={(e) => { setFileUrl(e.target.value) }} />
                            </div>
                            {/* submit-button  */}
                            <button onClick={(e) => saveOrUpdateResume(e)} className='btn btn-success'>Save Resume</button>&nbsp;&nbsp;
                            <Link to="/Resume" className='btn btn-danger'>Cancel</Link>
                        </form>
                    </div>
                </div>

            </div>
        </div>
    );
};
