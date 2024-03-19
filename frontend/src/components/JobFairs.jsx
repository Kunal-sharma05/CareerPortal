import React, { useState } from 'react';
import { useMemo } from "react";
import {
  Accordion,
  AccordionBody,
  AccordionHeader,
  AccordionItem,
} from 'reactstrap';
import { SideNav } from "./templates/SideNav";
import { Footer } from "./Footer";
import { Header } from "./Header";


export function JobFairs() {
  document.title = "CareerCrafter | Job flair";
  /*  
  const [open, setOpen] = useState('1');
  const toggle = (id) => {
    if (open === id) {
      setOpen();
    } else {
      setOpen(id);
    }
  };*/

  return (

    <div className="w-[100%] h-full flex flex-col overflow-x-hidden">
    <Header />
    <div className="bg-gradient-to-r from-slate-900 via-purple-950 to-slate-900 w-full h-full flex gap-5 ">
      <SideNav />
      <div className="w-[80%] h-[88%]">
      <div className="container">
      <h1 className='text-zinc-100'>Explore Exciting Opportunities: Job Fairs Galore!</h1>
      
      <div className="job-fair text-zinc-100 ">
        <h3>Tech Connect Expo</h3>
        <p>Gear up for the ultimate tech rendezvous at the Tech Connect Expo! Hosted in the heart of downtown, this event brings together leading tech companies from Silicon Valley giants to innovative startups. Explore cutting-edge technologies, engage in insightful workshops, and network with industry pioneers. Whether you're passionate about coding, data science, or cybersecurity, the Tech Connect Expo is your gateway to a dynamic career in the tech sphere.</p>
      </div>
      <br></br>
      <div className="card pl-3 pr-3 bg-gradient-to-r from-rose-100 to-teal-100">
        <h2>Google Job Fair at KIIT University</h2>
        <p><strong>Date:</strong> April 10, 2024</p>
        <p><strong>Time:</strong> 9:00 AM - 5:00 PM</p>
        <p><strong>Location:</strong> KIIT University, Bhubaneswar, Odisha</p>
        <p><strong>About the Event:</strong> Don't miss out on the exclusive opportunity to meet representatives from Google at our upcoming job fair! Whether you're an aspiring software engineer, product manager, or marketing enthusiast, Google offers a plethora of exciting career paths to explore. Engage in one-on-one discussions, participate in interactive demos, and gain valuable insights into life at Google. Elevate your career journey and embark on a transformative adventure with one of the world's most innovative companies. Mark your calendars and join us for a day of inspiration and opportunity!</p>
      </div>
    </div>
    </div>
    </div>
    <Footer />
    </div>
  );
}

export default JobFairs;