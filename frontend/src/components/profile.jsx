import React, { useContext, useEffect } from 'react'
import LoginForm from './LoginForm';
import { Header } from './Header';
import { SideNav } from './templates/SideNav';
import { Footer } from './Footer';
import { AuthContext } from './context/AuthProvider';
import { useNavigate } from 'react-router-dom';
//s
export const Profile = () => {
  const {auth} =useContext(AuthContext);
  const navigate = useNavigate();
  useEffect(() => {
    console.log("", auth)
    if (auth.role === "EMPLOYER" && auth.dto.employer !== null) {
      navigate(`/PersonProfile/${auth?.dto.employer.employerId}`);
    } else if (auth?.role === "JOB_SEEKER" && auth?.dto.jobSeeker !== null) {
      navigate(`/PersonProfileJobSeeker/${auth?.dto.jobSeeker.jobSeekerId}`);
    } else if (auth?.role === "ADMIN") {
      navigate("/user");
    } else if (auth?.role === "EMPLOYER") {
      navigate("/addEmployer");
    } else if (auth?.role === "JOB_SEEKER") {
      navigate("/addJobSeeker");
    }
  });
  return (
    <div className="w-[100%] h-full flex flex-col overflow-x-hidden">
      <Header />
      <div className="bg-gradient-to-r from-slate-900 via-purple-950 to-slate-900 w-full h-full flex ">
        <SideNav className="w-[16%]" />
        <div className="w-[84%] h-[100%] p-2 relative">
          <LoginForm />
        </div>
      </div>
      <Footer />
    </div>
  );
};

