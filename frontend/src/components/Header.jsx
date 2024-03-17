import React from 'react';
import { useNavigate } from 'react-router-dom';

export const Header = () => {
  const navigate = useNavigate()
  const onClickHome = () =>{
    navigate("/Home")
  };
  const onClickDashBoard = () =>{
    navigate("/BrowseJobs")
  }
  const onClickAbout = () =>{
    navigate("/About")
  }
  const onClickLogin = () =>{
    navigate("/Profile")
  }
  const onClickSingin = () =>{
    navigate("/register")
  }
  return (
    <header className="">
        <div className="py-2 px-6 border-b-2 border-zinc-100 flex justify-between align-middle">
          <h1 className=" px-3 text-2xl font-bold text-zinc-100">CareerCrafter©️</h1>
          <div className='flex gap-5 -translate-x-56 py-2 px-5'>
          <div onClick={onClickHome} className="text-base  text-zinc-100 hover:bg-zinc-100 hover:text-black duration-200 rounded-md px-2">Home</div>
          <div onClick={onClickDashBoard} className="text-base  text-zinc-100 hover:bg-zinc-100 hover:text-black duration-200 rounded-md px-2">Dash Board</div>
          <div onClick={onClickAbout} className="text-base  text-zinc-100 hover:bg-zinc-100 hover:text-black duration-200 rounded-md px-2">About</div>
          </div>
          <div className='flex gap-5 py-2 px-4'>
          <div onClick={onClickLogin} className="text-base  text-zinc-100 hover:bg-zinc-100 hover:text-black duration-200 rounded-md px-2">Log In</div>
          <div onClick={onClickSingin} className="text-base  text-zinc-100 hover:bg-zinc-100 hover:text-black duration-200 rounded-md px-2">Sign Up </div>
          </div>
        </div>
      </header>
  );
};
