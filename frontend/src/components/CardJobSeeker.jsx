import React from "react";
import { useNavigate } from "react-router-dom";

export const CardJobSeeker = ({ index, values, handleClick }) => {
  const navigate = useNavigate();
  const { jobSeekerId,fullName, educationDetail, image, applied } = values;
  const onClickHandler = () => {
    handleClick(index);
    console.log("value of id", jobSeekerId);
    navigate(`/jobSeekerProfile/${jobSeekerId}`);
  };
  return (
    <div className="w-[20vw] h-[27vw] bg-gradient-to-r from-rose-100 to-teal-100 p-2 rounded-md relative hover:scale-[105%] transition-all duration-300 ease-in-out hover:p-[1vw]">
      <div className="w-full h-40 bg-sky-200 ">
        <img
          className="h-full w-full object-top object-cover"
          src={image}
          alt=""
        />
      </div>
      <div className="w-full p-3">
        <h3 className="text-pretty text-xl font-semibold">{fullName}</h3>
        <h5 className=" text-sm">{educationDetail}</h5>
        <button
          onClick={onClickHandler}
          className={` px-2 py-1 bottom-4 text-xs text-white ${
            applied ? "bg-green-800" : "bg-black"
          } font-semibold rounded-md absolute`}
        >
          {" "}
          {applied ? "Applied" : "Visit My Profile"}{" "}
        </button>
      </div>
    </div>
  );
};
