import React from 'react'
import { Footer } from './Footer'
import { Header } from './Header'
import { SideNav } from "./templates/SideNav";
export const About = ()=> {
    document.title = "CareerCrafter | About";
  return (
    <div className="w-full h-full flex flex-col" >
      <Header/>
      <div className="bg-gradient-to-r from-slate-900 via-purple-950 to-slate-900 w-full h-full flex gap-5 ">
        <SideNav />
        <div id="scrollbar" className={`w-[80%] h-[98%] flex gap-5 flex-wrap mt-2 overflow-auto scroll-m-0 `} style={{ scrollbarWidth: 'none'}}>   
        <div className=" text-zinc-100 p-8 text-center">
        <h1 className="text-4xl mb-4 font-bold">About Us</h1>
        <p className="text-zinc-100 text-lg leading-7">
            Welcome to our website! We are dedicated to providing valuable information and services.
            Our mission is to empower individuals on their journey to a successful and fulfilling career.
        </p>
        <div className="mt-6">
            <p className="text-sm text-gray-400">Join us and shape your future today!</p>
            <div className="flex justify-center mt-4 gap-2">
        
             <i className="text-zinc-100 ri-facebook-box-line"></i>
             <i className="ri-instagram-line"></i>
             <i className="ri-linkedin-box-line"></i>
             <i className="ri-twitter-x-fill"></i>
               
              </div>
            </div>
        </div>
      </div>
    </div>
    <Footer />
    </div>
  )
}

export default About
