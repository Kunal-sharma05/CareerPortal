import React from "react";
import { Link } from "react-router-dom";

export const SideNav = () => {
  return (
    <div className=" w-[20%] h-[100%] border-r-2 border-zinc-200 p-3 ">
      <h1 className="text-xl text-zinc-100 ">
        <i className="ri-profile-line "></i>
        <span className="ml-2">CareerCrafter</span>
      </h1>
      <nav className="text-zinc-100 flex flex-col gap-3 mt-4">
        <Link
          className="text-zinc-100 hover:bg-zinc-100 hover:text-black duration-200 rounded-md p-2 "
          style={{ textDecoration: "none" }}
        >
          <i className="ri-user-search-fill mr-1"></i>Browse Jobs
        </Link>
        <Link
          className="text-zinc-100 hover:bg-zinc-100 hover:text-black duration-200 rounded-md p-2 "
          style={{ textDecoration: "none" }}
        >
          Profile
        </Link>
        <Link
          className="text-zinc-100 hover:bg-zinc-100 hover:text-black duration-200 rounded-md p-2 "
          style={{ textDecoration: "none" }}
        >
          Post Jobs
        </Link>
        <Link
          className="text-zinc-100 hover:bg-zinc-100 hover:text-black duration-200 rounded-md p-2 "
          style={{ textDecoration: "none" }}
        >
          Career Blogs
        </Link>
        <Link
          className="text-zinc-100 hover:bg-zinc-100 hover:text-black duration-200 rounded-md p-2 "
          style={{ textDecoration: "none" }}
        >
          Job Fairs
        </Link>
        <Link
          className="text-zinc-100 hover:bg-zinc-100 hover:text-black duration-200 rounded-md p-2 "
          style={{ textDecoration: "none" }}
        >
          About
        </Link>
      </nav>
    </div>
  );
};
