import React, { useEffect, useState } from "react";
import JobListingService from "../services/JobListingService";
import { Link } from "react-router-dom";

export const SearchHomePage = ({ handleButton }) => {
  const [title, setTitle] = useState("");
  const [requirements, setRequirements] = useState("");
  const [searches, setSearches] = useState(null);
  const GetSearches = async () => {
    try {
      const { data } = await JobListingService.SearchByTitleAndRequirements(
        title,
        requirements
      );
      console.log(" result of Search of jobs by title and location ", data);
      setSearches(data);
    } catch (error) {
      console.log("Error: ", error);
    }
  };
  useEffect(() => {
    if (title.length > 0 && requirements.length > 0) {
      GetSearches();
    } else {
      setSearches(null); // Clear search results if query is empty
    }
  }, [title,requirements]);
  const handleInputTitle = (e) => {
    const value = e.target.value;
    setTitle(value);
  };
  const handleInputRequirements = (e) => {
    const value = e.target.value;
    setRequirements(value);
  };
//   useEffect(() => {
//     handleButton(searches);
//   }, [searches, handleButton]);

  return (
    <div>
      <form className="flex space-x-4">
        <input
          type="text"
          onChange={handleInputTitle}
          value={title}
          placeholder="Job title or keywords"
          className=" text-red w-1/2 px-4 py-2 rounded-lg border-2 border-gray-700 focus:outline-none focus:border-gray-900 placeholder-amber-950"
        />
        <input
          type="text"
          onChange={handleInputRequirements}
          value={requirements}
          placeholder="Location"
          className="w-1/2 px-4 py-2 rounded-lg border-2 border-gray-700 focus:outline-none focus:border-gray-900 placeholder-amber-950"
        />
        <button
          type="submit"
          className="font-bold px-6 py-2 bg-slate-900 text-zinc-100 rounded-lg hover:bg-slate-700 transition-colors duration-300"
        >
          Search
        </button>
        </form>
        <div className="w-[90%] max-h-[17vh] absolute bg-gradient-to-r from-slate-900 via-zinc-900 to-slate-900 top-[58%]  overflow-auto rounded-full">
        {searches?.map((item, index) => (
          <Link to={`/jobProfile/${item.jobListingId}`} key={index} className=" h-10 hover:text-black font-semibold text-zinc-100 w-[100%] py-5 px-10 no-underline flex justify-center items-center border-b- rounded-md ">
            <img src={item.image} alt="" className="w-[10vh] h-[5vh] mr-2 object-cover rounded-full" />
            <span>{item.title}</span>
          </Link>
        ))}
      </div>
    </div>
  );
};
