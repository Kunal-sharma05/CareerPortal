import React, { useEffect, useState } from "react";
import { Card } from "./Card";
import { SideNav } from "./templates/SideNav";
import JobListingService from "../services/JobListingService";
import { Footer } from "./Footer";
import { Header } from "./Header";

export const BrowseJobs = () => {
  document.title = "CareerCrafter | BrowseJobs";
  const [jobListingArray, setJobListingArray] = useState([]);
  const fetchAllJobListing = () => {
    console.log("Feth all JobListings in homepage is fired");
    JobListingService.getAllJobListings()
      .then((response) => {
        console.log(
          "respnse recieved from the APU in the home page for JobListing...",
          JSON.stringify(response.data)
        );
        setJobListingArray(response.data);
      })
      .catch((error) => {
        console.log(
          "Error recieved in the home page in fetch all jobListings",
          error
        );
      });
  };
  useEffect(() => {
    console.log("use effect of home page....");
    fetchAllJobListing();
  }, []);
  const handleApplyButton = (cardIndex) => {
    console.log("index passed", cardIndex);
    setJobListingArray((prev) => {
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
      <div className="bg-[#1F1E24] w-full h-full flex gap-5 ">
        <SideNav />
        <div id="scrollbar" className={`w-[80%] h-[98%] flex gap-5 flex-wrap mt-2 overflow-auto scroll-m-0 `} style={{ scrollbarWidth: 'none'}}>
          {jobListingArray.map((item, key) => (
            <Card
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
};