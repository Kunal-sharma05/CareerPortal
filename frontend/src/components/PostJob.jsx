import React from "react";
import { Header } from "./Header";
import { SideNav } from "./templates/SideNav";
import { Footer } from "./Footer";
import { AddJobListing } from "./addcomponents/AddJobListing";

export const PostJob = () => {
  return (
    <div className="w-[100%] h-full flex flex-col overflow-x-hidden">
      <Header />
      <div className="bg-gradient-to-r from-slate-900 via-purple-950 to-slate-900 w-full h-full flex ">
        <SideNav className="w-[20%]" />
        <AddJobListing className="w-[84%]" />
      </div>
      <Footer />
    </div>
  );
};
