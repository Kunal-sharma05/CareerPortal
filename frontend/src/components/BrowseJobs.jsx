import React, { useEffect, useState } from "react";
import { Card } from "./Card1";
import { SideNav } from "./templates/SideNav";
import JobListingService from "../services/JobListingService";
import { Footer } from "./Footer";
import { Header } from "./Header";
import { Search } from "./Search";

export const BrowseJobs = () => {
  document.title = "CareerCrafter | BrowseJobs";
  const [jobListingArray, setJobListingArray] = useState([]);
  const [searchResults, setSearchResults] = useState([]);
  const fetchAllJobListing = () => {
    console.log("Feth all JobListings in homepage is fired");
    JobListingService.getAllJobListings()
      .then((response) => {
        console.log(
          "respnse recieved from the APU in the home page for JobListing...",
          response.data
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
    console.log("use effect of Browse Job page....");
    if (searchResults?.length === 0) {
      fetchAllJobListing();
    }
  }, [searchResults]);

  const handleSearchButton = (results) => {
    console.log("result object recieved in Browse jobs ", results);
    setSearchResults(results); // Set searchResults to search query results
  };
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
    <div className="w-[100%] h-full flex flex-col overflow-x-hidden">
      <Header />
      <div className="bg-gradient-to-r from-slate-900 via-purple-950 to-slate-900 w-full h-full flex gap-5 ">
        <SideNav />
        <div className="w-[80%] h-[88%]">
          <Search handleClick={handleSearchButton} />
          <div
            id="scrollbar"
            className={`w-full h-[98%] flex gap-5 flex-wrap mt-2 overflow-auto scroll-m-0 p-2 `}
            style={{ scrollbarWidth: "none" }}
          >
            {searchResults?.length > 0
              ? searchResults.map((item, key) => (
                  <Card
                    key={key}
                    index={key}
                    values={item}
                    handleClick={handleApplyButton}
                  />
                ))
              : jobListingArray.map((item, key) => (
                  <Card
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
