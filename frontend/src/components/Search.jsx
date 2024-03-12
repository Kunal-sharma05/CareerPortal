import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import JobListingService from "../services/JobListingService";

export const Search = ({handleClick}) => {
  const [query, setQuery] = useState("");
  const [searches, setSearches] = useState(null);
  const GetSearches = async () => {
    try {
      const { data } = await JobListingService.GetByTitleContainig(query);
      console.log("Search of job by title ", data);
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
    handleClick(searches);
  },[searches,handleClick])
  return (
    <div className="w-full h-[10vh] relative flex translate-x-44 items-center">
      <i className="ri-search-line text-base text-zinc-100"></i>
      <input
        type="text"
        onChange={handleInput}
        value={query}
        placeholder="search jobs on the basis of title"
        className="w-[40%] mx-3 p-1 text-base border-black rounded-md"
      />
      {query.length > 0 && (
       <div> <i
          onClick={() => setQuery("")}
          className="ri-close-line text-2xl text-zinc-100"
        ></i>
        </div>
      )}
      {/* <div className="w-[50%] max-h-[30vh] absolute bg-gradient-to-r from-rose-100 to-teal-100 top-[90%]  overflow-auto m-auto">
        {searches?.map((item, index) => (
          <Link key={index} className=" h-10 hover:text-black font-semibold text-slate-600 w-[100%] pl-10 no-underline flex justify-start items-center border-b- rounded-md ">
            <img src={item.image} alt="" className="w-[10vh] h-[5vh] mr-2 object-cover rounded-full" />
            <span>{item.title}</span>
          </Link>
        ))}
      </div> */}
    </div>
  );
};
