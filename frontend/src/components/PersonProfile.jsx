import React, { useContext, useEffect, useState } from "react";
import { Header } from "./Header";
import { SideNav } from "./templates/SideNav";
import { Footer } from "./Footer";
import { useNavigate, useParams } from "react-router-dom";
import { AuthContext } from "./context/AuthProvider";
import EmployerService from "../services/EmployerService";
import { ListJobListing } from "./ListJobListing";

export const PersonProfile = () => {
  document.title = "CareerCrafter | Job profile";
  
  const [fullName, setFullName] = useState("");
  const [companyName, setCompanyName] = useState("");
  const [mobileNo, setMobileNo] = useState("");
  const [email, setEmail] = useState("");
  const [image, setImage] = useState("");
  const navigate = useNavigate();
  const {auth}=useContext(AuthContext)
  const { id } = useParams();
  const text = "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Nesciunt laudantium perferendis dolorem, animi voluptatem dolores nemo rerum ullam hic porro quisquam odio incidunt saepe, distinctio minima accusamus nisi numquam aliquid."
  useEffect(() => {
    console.log("useEffect triggered.... ");
    console.log("id value obtained from url using useParams()", id);
    if (auth.role==="EMPLOYER" && id) {
      EmployerService.getEmployerById(id,auth)
        .then((response) => {
          console.log(
            "Response recieved from getbyid API",
            response.data
          );
          setFullName(response.data.fullName);
          setCompanyName(response.data.companyName);
          setMobileNo(response.data.mobileNo);
          setImage(response.data.image)
          setEmail(response.data.email)
          console.log("state variable changed. ");
        })
        .catch((error) => {
          console.log("Error recieved from save api...", error);
        });
    }
  }, []);
  const handleUpdate = () => {
    const employerId = auth.dto.employer.employerId;
    console.log("employerId", employerId)
    navigate(`/employee/update/${employerId}`)
  }
  return (
    <div className="w-[100%] h-full flex flex-col overflow-x-hidden">
      <Header />
      <div className="bg-gradient-to-r from-slate-900 via-purple-950 to-slate-900 w-full h-full flex ">
        <SideNav className="w-[16%]" />
        <div className="w-[84%] h-[100%] p-2">
          <div
            className={`w-full h-[100%] flex flex-col items-center gap-4 overflow-y-scroll `}
            style={{ scrollbarWidth: "none" }}
          >
            <img src={`${image}`} alt=""  className=" w-40 h-40 object-cover rounded-full mt-4 border-2 border-zinc-100 "/>
            <div className=" text-zinc-800  p-2 bg-gradient-to-r from-rose-100 to-teal-100  -translate-y-5 text-l font-bold rounded-md mt-2 ">{fullName}</div>
            <div className="text-zinc-100 h-30 text-center  rounded-full">About:- {companyName} <br></br> Lorem ipsum dolor sit, amet consectetur adipisicing elit. Nesciunt odit repudiandae asperiores quia, illum quo, maiores veritatis vitae ea delectus qui cum placeat vero laudantium aut hic amet consectetur consequuntur? Repudiandae officia porro iste esse eveniet ex dignissimos perspiciatis corporis provident itaque nam eaque nisi placeat, quidem voluptas nostrum nihil!</div>
            <div className="text-zinc-100 h-30 text-center">Mobile Number:- {mobileNo} </div>
            <div className="text-zinc-100 h-30 text-center">Email:- {email} </div>
            <button onClick={handleUpdate} className=" bg-black rounded-md text-base font-semibold text-zinc-100 p-2">Update</button>
            <ListJobListing ></ListJobListing>
          </div>
        </div>
      </div>
      <Footer />
    </div>
  );
};