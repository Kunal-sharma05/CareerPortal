import React, { useContext, useEffect, useState } from "react";
import { Header } from "./Header";
import { SideNav } from "./templates/SideNav";
import { Footer } from "./Footer";
import { useNavigate, useParams } from "react-router-dom";
import JobListingService from "../services/JobListingService";
// import JobApplicationService from "../services/JobApplicationService";
import JobSeekerService from "../services/JobSeekerService";
import { AuthContext } from "./context/AuthProvider";

export const JobProfile = () => {
  document.title = "CareerCrafter | Job profile";
  const [requirements, setRequirements] = useState("");
  const [description, setDescription] = useState("");
  const [title, setTitle] = useState("");
  const [image, setImage] = useState("");
  const [status, setStatus] = useState("PENDING");
  const navigate = useNavigate();
  const { id } = useParams();
  const {auth} = useContext(AuthContext)
  // const text = "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Nesciunt laudantium perferendis dolorem, animi voluptatem dolores nemo rerum ullam hic porro quisquam odio incidunt saepe, distinctio minima accusamus nisi numquam aliquid."
  useEffect(() => {
    console.log("useEffect triggered.... ");
    console.log("id value obtained from url using useParams()", id);
    if (id) {
      JobListingService.getJobListingById(id)
        .then((response) => {
          console.log(
            "Response recieved from getbyid API",
            response.data
          );
          setTitle(response.data.title);
          setDescription(response.data.description);
          setRequirements(response.data.requirements);
          setImage(response.data.image)
          console.log("state variable changed. ");
        })
        .catch((error) => {
          console.log("Error recieved from save api...", error);
        });
    }
  }, []);
  const handleApply = () =>
  {
    const Id = auth?.dto?.jobSeeker?.jobSeekerId
    console.log("jobSeekerId",Id )
    setStatus("PENDING")
    const jobApplication ={ "status":status, "id":id };
    JobSeekerService.addJobApplication(Id,jobApplication,id)
    .then((response) => {
      console.log(

        "response recieved from the API in the List JobApplication component...",
        JSON.stringify(response.data)
      );
      
      navigate(`/PersonProfileJobSeeker/${Id}`);
    })
    .catch((error) => {
      console.log(
        "Error recieved in the list JobApplication component in delete JobApplication ",
        error
      );
    });
  }
  return (
    <div className="w-[100%] h-full flex flex-col overflow-x-hidden">
      <Header />
      <div className="bg-gradient-to-r from-slate-900 via-purple-950 to-slate-900 w-full h-full flex ">
        <SideNav className="w-[16%]" />
        <div className="w-[84%] h-[100%] p-2">
          <div
            className={`w-full h-full flex flex-col items-center gap-4 overflow-y-auto `}
            style={{ scrollbarWidth: "none" }}
          >
            <img src={`${image}`} alt=""  className=" w-40 h-40 object-cover rounded-full mt-4 border-2 border-zinc-100"/>
            <div className=" text-zinc-800  p-2 bg-gradient-to-r from-rose-100 to-teal-100  -translate-y-5 text-l font-bold rounded-md mt-2 ">{title}</div>
            <div className="text-zinc-100 h-30 text-center  rounded-full">𝘿𝙚𝙨𝙘𝙧𝙞𝙥𝙩𝙞𝙤𝙣:- {description} <br></br> Lorem ipsum dolor sit, amet consectetur adipisicing elit. Nesciunt odit repudiandae asperiores quia, illum quo, maiores veritatis vitae ea delectus qui cum placeat vero laudantium aut hic amet consectetur consequuntur? Repudiandae officia porro iste esse eveniet ex dignissimos perspiciatis corporis provident itaque nam eaque nisi placeat, quidem voluptas nostrum nihil!</div>
            <div className="text-zinc-100 h-30 text-center">𝙍𝙚𝙦𝙪𝙞𝙧𝙚𝙢𝙚𝙣𝙩𝙨:- {requirements} <br></br> Lorem ipsum dolor sit amet consectetur adipisicing elit. Dignissimos harum sit pariatur ipsum ut at officiis voluptatibus quaerat accusantium architecto labore possimus a debitis voluptate molestiae placeat delectus, explicabo hic repudiandae consequatur nemo! Mollitia architecto voluptates obcaecati, animi vitae labore.</div>
            <button onClick={handleApply} className=" bg-black rounded-md text-base font-semibold text-zinc-100 p-2">Apply</button>
          </div>
        </div>
      </div>
      <Footer />
    </div>
  );
};
