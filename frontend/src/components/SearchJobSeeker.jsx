import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import JobSeekerService from "../services/JobSeekerService";

export const SearchJobSeeker = ({handleButton}) => {
  const [query, setQuery] = useState("");
  const [searches, setSearches] = useState(null);
  const GetSearches = async () => {
    try {
      const { data } = await JobSeekerService.searchByDetails(query);
      console.log("Search of jobSeeker by details ", data);
      setSearches(data);
    } catch (error) {
      console.log("Error: ", error);
    }
  };
  useEffect(() => {
    if (query.length>0) {
      GetSearches();
    } else {
      setSearches(null); // Clear search results if query is empty
    }
  }, [query]);
  const handleInput = (e)=> {
    const value = e.target.value;
    setQuery(value);
  }
  useEffect(()=>{
    handleButton(searches);
  },[searches,handleButton]);

  return (
    <div className="w-full h-[10vh] relative flex translate-x-44 items-center">
      <i className="ri-search-line text-base text-zinc-100"></i>
      <input
        type="text"
        onChange={handleInput}
        value={query}
        placeholder="search users on the basis of details"
        className="w-[40%] mx-3 p-1 text-base border-black rounded-md"
      />
      {query.length > 0 && (
        <i
          onClick={() => setQuery("")}
          className="ri-close-line text-2xl text-zinc-100"
        ></i>
      )}

      <div className="w-[50%] max-h-[30vh] absolute bg-red-100 top-[90%]  overflow-auto">
        {/* <Link className=" h-10 hover:text-black font-semibold text-slate-600 w-[100%] pl-10 no-underline flex justify-start items-center border-b-2 border-gray-800 rounded-md ">
          <img src="" alt="" />
          <span>Hello</span>
        </Link>
        <Link className=" h-10 hover:text-black font-semibold text-slate-600 w-[100%] pl-10 no-underline flex justify-start items-center border-b-2 border-gray-800  rounded-md">
          <img src="" alt="" />
          <span>Hello</span>
        </Link> */}
        
      </div>
    </div>
  );
};
