import React from 'react'
import { Footer } from './Footer'
import { Header } from './Header'
import { SideNav } from "./templates/SideNav";
import {
  Card,
  CardImg,
  CardImgOverlay,
  CardTitle,
  CardText,
} from 'reactstrap';

export const About = ()=> {
    document.title = "CareerCrafter | About";
  return (
    
    <div className="w-full h-full flex flex-col" >

      
      <Header/>
      <div className="bg-gradient-to-r from-slate-900 via-red-900 to-slate-900 w-full h-full flex gap-5 ">
        <SideNav />
        <div id="scrollbar" className={`w-[80%] h-[98%] flex gap-5 flex-wrap mt-2 overflow-auto scroll-m-0 `} style={{ scrollbarWidth: 'none'}}>   
        <div className=" text-zinc-100 p-8 text-center">
        <div>
  <Card inverse>
    <CardImg
      alt="Card image cap"
      src="https://images.adsttc.com/media/images/559c/83b5/e58e/ced8/0f00/006a/newsletter/Hong_Kong_Brian_H.Y.jpg?1436320679"
      style={{
        height: 270
      }}
      width="100%"
    />
    <CardImgOverlay>
      <CardTitle tag="h5">
        Card Title
      </CardTitle>
      <CardText>
        This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.
      </CardText>
      <CardText>
        <small className="text-muted">
          Last updated 3 mins ago
        </small>
      </CardText>
    </CardImgOverlay>
  </Card>
  
        <h1 className="text-4xl mb-4 font-bold gap-5">About Us</h1>
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
    </div>
    <Footer />
    </div>
  )
}

export default About
