import React from "react";
import { Navigate, useNavigate } from "react-router-dom";

export const Button = ({ text, color }) => {
  const navigate = useNavigate();
  return (
    <>
    {/* <button className='btn btn-danger'>Cancel</button> */}
      <button
         onClick={()=>navigate('/user')} className={`px-3 py-1 ${color} text-zinc-100 text-s rounded m-2`}
      >
        {text}
      </button>
    </>
  );
};
