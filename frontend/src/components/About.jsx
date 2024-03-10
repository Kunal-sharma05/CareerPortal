import React from 'react'
import { Footer } from './Footer'
import { Header } from './Header'

export const About = ()=> {
    document.title = "CareerCrafter | About";
  return (
    
    <div className="w-full h-full flex flex-col">
     <Header/>
     <div className=" text-zinc-100 p-8 text-center">
      <h1 className="text-4xl mb-4 font-bold">About Us</h1>
      <p className="text-lg leading-7">
        Welcome to our website! We are dedicated to providing valuable information and services.
        Our mission is to empower individuals on their journey to a successful and fulfilling career.
      </p>
      <div className="mt-6">
        <p className="text-sm text-gray-400">Join us and shape your future today!</p>
        <div className="flex justify-center mt-4">
          

          <i className="text-zinc-100 ri-facebook-box-line"></i>
        
        </div>
      </div>
    </div>
    <Footer />
    </div>
  )
}

export default About
