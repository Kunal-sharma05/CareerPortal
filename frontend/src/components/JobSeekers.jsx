import React, { useEffect, useState } from "react";
import { SideNav } from "./templates/SideNav";
import { Header } from "./Header";
import { Footer } from "./Footer";
import JobSeekerService from "../services/JobSeekerService";
import { useNavigate } from "react-router-dom";
import { CardJobSeeker } from "./CardJobSeeker";
import { SearchJobSeeker } from "./SearchJobSeeker";

export const JobSeekers = () => {
  const [jobSeekerArray, setJobSeekerArray] = useState([]);
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
    <div className="w-[100%] h-full flex flex-col overflow-x-hidden">
      <Header />
      <div className="bg-gradient-to-r from-slate-900 via-red-900 to-slate-900 w-full h-full flex gap-5 ">
        <SideNav />
        <div className="w-[80%] h-[88%]">
          <SearchJobSeeker />
          <div
            id="scrollbar"
            className={`w-full h-[98%] flex gap-5 flex-wrap mt-2 overflow-auto `}
            style={{ scrollbarWidth: "none" }}
          >
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
      </div>
      <Footer />
    </div>
  );
};
