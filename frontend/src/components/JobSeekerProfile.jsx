import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import JobSeekerService from "../services/JobSeekerService";
import { Header } from "./Header";
import { SideNav } from "./templates/SideNav";
import { Footer } from "./Footer";

export const JobSeekerProfile = () => {
  document.title = "CareerCrafter | Job profile";
  const [fullName, setFullName] = useState("");
  const [professionalDetails, setProfessionalDetails] = useState("");
  const [educationDetail, setEducationDetail] = useState("");
  const [image, setImage] = useState("");
  const [dateOfBirth, setDateOfBirth] = useState("");
  const [email, setEmail] = useState("");
  const [mobileNumber, setMobileNumber] = useState("");
  const navigate = useNavigate();
  const { id } = useParams();
  useEffect(() => {
    console.log("useEffect triggered.... ");
    console.log("id value obtained from url using useParams()", id);
    if (id) {
      JobSeekerService.getJobSeekerById(id)
        .then((response) => {
          console.log("Response recieved from getbyid API", response.data);
          setFullName(response.data.fullName);
          setProfessionalDetails(response.data.professionalDetails);
          setEducationDetail(response.data.educationDetail);
          setImage(response.data.image);
          setDateOfBirth(response.data.dateOfBirth);
          setEmail(response.data.email);
          setMobileNumber(response.data.mobileNumber);
          console.log("state variable changed. ");
        })
        .catch((error) => {
          console.log("Error recieved from save api...", error);
        });
    }
  }, []);
  return (
    <div className="w-[100%] h-full flex flex-col overflow-x-hidden">
      <Header />
      <div className="bg-gradient-to-r from-slate-900 via-purple-950 to-slate-900 w-full h-full flex ">
        <SideNav className="w-[16%]" />
        <div className="w-[84%] h-[98%]">
          <div
            className={`w-full h-full flex flex-col items-center gap-4 overflow-y-auto `}
            style={{ scrollbarWidth: "none" }}
          >
            <img
              src={`${image}`}
              alt=""
              className=" w-40 h-40 object-cover rounded-full border-zinc-100 border-2 mt-4"
            />
            <div className=" text-zinc-800  p-2 bg-gradient-to-r from-rose-100 to-teal-100  -translate-y-5 text-l font-bold rounded-md mt-2 ">
              {fullName}
            </div>
            <div className="text-zinc-100 h-30 text-center">Mobile Number: {mobileNumber}</div>
            <div className="text-zinc-100 h-30 text-center">Email: {email}</div>
            <div className="text-zinc-100 h-30 text-center">DOB: {new Date(dateOfBirth).toLocaleDateString()}</div>
            
            <div className="text-zinc-100 h-30 text-center">Professional Details:- {professionalDetails} <br></br> Lorem ipsum dolor sit, amet consectetur adipisicing elit. Nesciunt odit repudiandae asperiores quia, illum quo, maiores veritatis vitae ea delectus qui cum placeat vero laudantium aut hic amet consectetur consequuntur? Repudiandae officia porro iste esse eveniet ex dignissimos perspiciatis corporis provident itaque nam eaque nisi placeat, quidem voluptas nostrum nihil!</div>
            
            <div className="text-zinc-100 h-30 text-center">
              Educational Details:- {educationDetail} <br></br> Lorem ipsum dolor sit amet
              consectetur adipisicing elit. Dignissimos harum sit pariatur ipsum
              ut at officiis voluptatibus quaerat accusantium architecto labore
              possimus a debitis voluptate molestiae placeat delectus, explicabo
              hic repudiandae consequatur nemo! Mollitia architecto voluptates
              obcaecati, animi vitae labore.
            </div>
            <button onClick={()=>navigate(-1)} className=" bg-black rounded-md p-2">
              <i className=" text-zinc-100 ri-arrow-left-circle-fill text-2xl"></i>
            </button>
          </div>
        </div>
      </div>
      <Footer />
    </div>
  );
};
