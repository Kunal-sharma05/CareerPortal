import React from "react";
import { Link } from "react-router-dom";

export const SideNav = () => {
  return (
    <div className=" w-[20%]  flex-1 border-r-2 border-zinc-200 p-3 ">
      <h1 className="text-xl text-zinc-100 ">
        <i className="ri-profile-line "></i>
        <span className="ml-2">Dash Board</span>
      </h1>
      <nav className="text-zinc-100 flex flex-col gap-3 mt-4">
        <Link
          to="/BrowseJobs"
          className="text-zinc-100 hover:bg-zinc-100 hover:text-black duration-200 rounded-md p-2 "
          style={{ textDecoration: "none" }}
        >
          <i className="ri-building-4-fill mr-1"></i>Browse Jobs
        </Link>
        <Link
          to="/browseJobSeekers"
          className="text-zinc-100 hover:bg-zinc-100 hover:text-black duration-200 rounded-md p-2 "
          style={{ textDecoration: "none" }}
        >
          <i className="ri-id-card-line mr-1"></i>
          Job Seekers 
        </Link>
        <Link
          className="text-zinc-100 hover:bg-zinc-100 hover:text-black duration-200 rounded-md p-2 "
          style={{ textDecoration: "none" }}
        >
          <i className="ri-empathize-fill mr-1"></i>
          Profile
        </Link>
        <Link
          className="text-zinc-100 hover:bg-zinc-100 hover:text-black duration-200 rounded-md p-2 "
          style={{ textDecoration: "none" }}
        >
          <i className="ri-signpost-fill mr-1"></i>
          Post Jobs
        </Link>
        <Link
          className="text-zinc-100 hover:bg-zinc-100 hover:text-black duration-200 rounded-md p-2 "
          style={{ textDecoration: "none" }}
        >
          <i className="ri-discuss-fill mr-1"></i>
          Career Blogs
        </Link>
        <Link
          className="text-zinc-100 hover:bg-zinc-100 hover:text-black duration-200 rounded-md p-2 "
          style={{ textDecoration: "none" }}
        >
          <i className="ri-flag-2-fill mr-1"></i>
          Job Fairs
        </Link>
      
        <Link
          to="/About"
          className="text-zinc-100 hover:bg-zinc-100 hover:text-black duration-200 rounded-md p-2 "
          style={{ textDecoration: "none" }}
        >
          <i className="ri-building-4-fill mr-1"></i>About
        </Link>
      </nav>
    </div>
  );
};
