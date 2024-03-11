import React, { useEffect, useState } from 'react'
import { SideNav } from './templates/SideNav';
import { Header } from './Header';
import { Footer } from './Footer';
import JobSeekerService from '../services/JobSeekerService';
import { useNavigate } from 'react-router-dom';
import { CardJobSeeker } from './CardJobSeeker';

export const JobSeekers = () => {
  const[jobSeekerArray,setJobSeekerArray]=useState([]);
  const navigate = useNavigate();
  const fetchAllJobSeekers = () => {
    console.log("fetch all job seeker method fired......");
    JobSeekerService.getAllJobSeekers()
      .then((response) => {
        console.log("response recieved from the api", response.data);
        setJobSeekerArray(response.data);
      })
      .catch((error) => {
        console.log("Error recieved from saved API...", error);
      });
  };
  useEffect(() => {
    console.log("use effect of home page....");
    fetchAllJobSeekers();
  }, []);
  const handleApplyButton = (cardIndex) => {
    console.log("index passed", cardIndex);
    setJobSeekerArray((prev) => {
      return prev.map((item, index) => {
        if (index === cardIndex) {
          return { ...item, applied: !item.applied };
        }
        return item;
      });
    });
  };
  return (
    <div className="w-full h-full flex flex-col" >
    <Header/>
    <div className="bg-gradient-to-r from-slate-900 via-red-900 to-slate-900 w-full h-full flex gap-5">
      <SideNav />
      <div id="scrollbar" className={`w-[80%] h-[98%] flex gap-5 flex-wrap mt-2 overflow-auto scroll-m-0 `} style={{ scrollbarWidth: 'none'}}>
        {jobSeekerArray.map((item, key) => (
          <CardJobSeeker
            key={key}
            index={key}
            values={item}
            handleClick={handleApplyButton}
          />
        ))}
      </div>
    </div>
    <Footer />
  </div>
  );
}
