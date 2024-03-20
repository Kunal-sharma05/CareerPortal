import React, { useContext } from "react";
import { NavLink, useNavigate } from "react-router-dom";
import { AuthContext } from "../context/AuthProvider";
//ass
export const SideNav = () => {
  const {auth} = useContext(AuthContext)
  const navigate = useNavigate();
  return (
    <div className=" w-[20%]   flex-1 border-r-2 border-zinc-200 p-3 ">
      <h1 className="text-xl text-zinc-100 ">
        <i className="ri-profile-line "></i>
        <span className="ml-2">Dash Board</span>
      </h1>
      <nav className="text-zinc-100 flex flex-col gap-3 mt-4">
        <NavLink
          to="/BrowseJobs"
          className="text-zinc-100 hover:bg-zinc-100 hover:text-black duration-200 rounded-md p-2 "
          style={(e) => ({
            color: e.isActive ? "black" : "",
            textDecoration: "none" ,
            backgroundColor: e.isActive ? "rgb(244 244 245)" : ""
          })}
        >
          <i className="ri-building-4-fill mr-1"></i>Browse Jobs
        </NavLink>
        <NavLink
          to="/browseJobSeekers"
          className="text-zinc-100 hover:bg-zinc-100 hover:text-black duration-200 rounded-md p-2 "
          style={(e)=>({ 
            textDecoration: "none",
            color: e.isActive ? "black" : "",
            backgroundColor: e.isActive ? "rgb(244 244 245)" : ""
           })}
        >
          <i className="ri-id-card-line mr-1"></i>
          Job Seekers
        </NavLink>
        <NavLink
          to="/Profile"
          className="text-zinc-100 hover:bg-zinc-100 hover:text-black duration-200 rounded-md p-2 "
          style={(e)=>({ 
            textDecoration: "none",
            color: e.isActive ? "black" : "",
            backgroundColor:e.isActive ? "rgb(244 244 245)" : ""
           })}
        >
          <i className="ri-empathize-fill mr-1"></i>
          Profile
        </NavLink>
        {auth?.role==="EMPLOYER"?<NavLink
          to="/PostJob"
          className="text-zinc-100 hover:bg-zinc-100 hover:text-black duration-200 rounded-md p-2 "
          style={(e)=>({ 
            textDecoration: "none",
            color: e.isActive ? "black" : "",
            backgroundColor: e.isActive ? "rgb(244 244 245)" : ""
           })}
        >
          <i className="ri-signpost-fill mr-1"></i>
          Post Jobs
        </NavLink>:null}
        <NavLink
        to="/CareerBlogs"
          className="text-zinc-100 hover:bg-zinc-100 hover:text-black duration-200 rounded-md p-2 "
          style={(e)=>({ 
            textDecoration: "none",
            color: e.isActive ? "black" : "",
            backgroundColor: e.isActive ? "rgb(244 244 245)" : ""
           })}
        >
          <i className="ri-discuss-fill mr-1"></i>
          Career Blogs
        </NavLink>
        <NavLink
        to="/JobFairs"
          className="text-zinc-100 hover:bg-zinc-100 hover:text-black duration-200 rounded-md p-2 "
          style={(e)=>({ 
            textDecoration: "none",
            color: e.isActive ? "black" : "",
            backgroundColor: e.isActive ? "rgb(244 244 245)" : ""
           })}
        >
          <i className="ri-flag-2-fill mr-1"></i>
          Job Fairs
        </NavLink>
      </nav>
    </div>
  );
};
