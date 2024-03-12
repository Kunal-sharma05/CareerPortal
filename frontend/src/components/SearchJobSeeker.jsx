import React, { useState } from "react";
import { Link } from "react-router-dom";

export const SearchJobSeeker = () => {
  const [query, setQuery] = useState("");
  return (
    <div className="w-full h-[10vh] relative flex translate-x-44 items-center">
      <i className="ri-search-line text-base text-zinc-100"></i>
      <input
        type="text"
        onChange={(e) => setQuery(e.target.value)}
        value={query}
        placeholder="search users on the basis of name"
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
