import React from 'react'
import { Routes,Route} from 'react-router-dom';
import { HomePage } from '../HomePage';
import { ListUser } from '../ListUser';
import { Error } from '../Error';
import { AddJobListing } from '../addcomponents/AddJobListing';
import { AddUser } from '../addcomponents/AddUser';
import { ListEmployee } from '../ListEmployee';
import { AddEmployer } from '../addcomponents/AddEmployer';
import { ListJobApplication } from '../ListJobApplication';
import { AddJobApplications } from '../addcomponents/AddJobApplication';
import { ListJobListing } from '../ListJobListing';
import { ListJobSeeker } from '../ListJobSeeker';
import { AddJobSeeker } from '../addcomponents/AddJobSeeker';
import { ListResume } from '../ListResume';
import { AddResume } from '../addcomponents/AddResume';
import { BrowseJobs } from '../BrowseJobs';
import { About } from '../About';
import { JobSeekers } from '../JobSeekers';
import { JobProfile } from '../JobProfile';
import { JobSeekerProfile } from '../JobSeekerProfile';
import { CareerBlogs } from '../CareerBlogs';
import { JobFairs } from '../JobFairs';
import { PostJob } from '../PostJob';
import RegisterForm from '../RegisterForm';
import LoginForm from '../LoginForm';
import { Profile } from '../Profile';
import { RequireAuth } from '../RequireAuth';
import { PersonProfile } from '../PersonProfile';
import { JobApplications } from '../JobApplications';
import { PersonProfileJobSeeker } from '../PersonProfileJobSeeker';
export const Router = () => {
  return (
    <Routes>
            <Route path='/' element={<HomePage/>}/>
            <Route path='/user' element={<ListUser/>}/>
            <Route path='*' element={<Error/>}/>
            <Route path='/addUser' element={<AddUser/>}/>
            <Route path="/update/:id" element={<AddUser/>}/>
            <Route path='/listJobApplication' element={<ListJobApplication/>}/>
            <Route path='/jobApplication' element={<ListJobApplication/>}/>
            <Route path='/addJobApplication' element={<AddJobApplications/>}/>
            <Route path='/jobApplication/update/:id' element={<AddJobApplications/>}/>
            <Route path='/listJobListing' element={<ListJobListing/>}/>
            <Route path='/jobListing' element={<ListJobListing/>}/>
            <Route path='/addJobListing' element={<AddJobListing/>}/>
            <Route path='/jobListing/update/:id' element={<AddJobListing/>}/>
            <Route path='/listJobSeeker' element={<ListJobSeeker/>}/>
            <Route path='/jobSeeker' element={<ListJobSeeker/>}/>
            <Route path='/addJobSeeker' element={<AddJobSeeker/>}/>
            <Route path='/jobSeeker/update/:id' element={<AddJobSeeker/>}/>
            <Route path='/listResume' element={<ListResume/>}/>
            <Route path='/Resume' element={<ListResume/>}/>
            <Route path='/addResume' element={<AddResume/>}/>
            <Route path='/resume/update/:id' element={<AddResume/>}/>
            <Route path='/BrowseJobs' element={<BrowseJobs/>}/>
            <Route path='/About' element={<About/>}/>
            <Route path='/Home' element={<HomePage/>}/>
            <Route path='/browseJobSeekers' element={<JobSeekers/>}/>
            <Route path='/jobProfile' element={<JobProfile/>}/>
            <Route path='/jobProfile/:id' element={<JobProfile/>}/>
            <Route path='/jobSeekerProfile/:id' element={<JobSeekerProfile/>}/>
            <Route path='/CareerBlogs' element={<CareerBlogs/>}/>
            <Route path='/JobFairs' element={<JobFairs/>}/>
            <Route path='/register' element={<RegisterForm/>}/>
            <Route path='/login' element={<Profile/>}/>
            <Route path='/profile' element={<Profile/>}/>
            <Route element={<RequireAuth/>}>
            <Route path='/listEmployee' element={<ListEmployee/>}/>
            <Route path='/employer' element={<ListEmployee/>}/>
            <Route path='/employee/update/:id' element={<AddEmployer/>}/> 
            <Route path='/addEmployer' element={<AddEmployer/>}/>
            <Route path='/jobApplication/:id' element={<ListJobApplication/>}/>
            <Route path='/jobApplications/:id' element={<JobApplications/>}/>
            <Route path='/PersonProfile/:id' element={<PersonProfile/>}/>
            <Route path='/PersonProfileJobSeeker/:id' element={<PersonProfileJobSeeker/>}/>
            <Route path='/PostJob' element={<PostJob/>}/>
            </Route>
          </Routes>
  )
}