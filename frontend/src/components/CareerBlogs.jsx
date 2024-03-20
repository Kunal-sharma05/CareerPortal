import Slider from "react-slick";
import "slick-carousel/slick/slick.css"; 
import "slick-carousel/slick/slick-theme.css";
import { Header } from "./Header";
import { Footer } from "./Footer";
import { SideNav } from "./templates/SideNav";
import { useNavigate, Link } from "react-router-dom";
export function  CareerBlogs() {
  document.title = "CareerCrafter | Career Blogs";
  const navigate = useNavigate();

  const settings = {
    dots: true,
    infinite: true,
    speed: 500,
    slidesToShow: 2,
    slidesToScroll: 1
  };
  const onReadMoreHandler = () => {
 
  };
  return (
    <div className="w-full h-full flex flex-col overflow-x-hidden">
      <Header />
      <div className="bg-gradient-to-r from-slate-900 via-purple-950  w-[73%] h-full flex gap-4">
        <SideNav />  
        
    <div className='w-3/4 m-auto pl-40'>
        
      <div className="mt-15 w-[130%] ">
        
      <Slider {...settings}>
        {data.map((d) => (
          <div key={d.name} className="bg-white h-[450px] text-black rounded-xl">
            <div className='h-56 bg-[radial-gradient(ellipse_at_center,_var(--tw-gradient-stops))] from-gray-700 via-gray-900 to-black flex justify-center items-center rounded-t-xl'>
              <img src={d.imgUrl} alt="" className="h-44 w-44 rounded-full object-cover"/>
            </div>
            <div className="flex flex-col items-center justify-center gap-6 p-1">
              <p className="text-xl font-semibold">{d.name}</p>
              <p className="text-center">{d.review}</p>
              <button onClick={onReadMoreHandler} className='bg-[radial-gradient(ellipse_at_center,_var(--tw-gradient-stops))] from-gray-700 via-gray-900 to-black text-white text-lg px-8 py-1 rounded-xl'><a href={d.blog} className="text-zinc-100" style={{textDecoration:"none"}} >Read More </a></button>
            </div>
          </div>
        ))}
      </Slider>
      </div>
      </div>
      </div>
     
      <Footer />
    </div>
  );
}

const data = [
  {
    name: `Mckinsey`,
    imgUrl: `https://www.mckinsey.com/~/media/images/global/seoimageplaceholder.jpg?mw=677&car=42:25`,
    review: `Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.`,
    blog: `https://www.mckinsey.com/careers/meet-our-people/careers-blog`
  },
  {
    name: `MentorCruise on Tesla`,
    imgUrl: `https://media.designrush.com/inspiration_images/269905/conversions/1_Tesla_Logo_Design_31692375c0d0-desktop.jpg`,
    review: `Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.`,
    blog: `https://mentorcruise.com/blog/tesla-recruitment-and-selection-process-how-to-get-hired-at-tesla/`
  },
  {
    name: `Microsoft `,
    imgUrl: `https://www.logodesignlove.com/wp-content/uploads/2012/08/microsoft-logo-02.jpeg`,
    review:` Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.`,
    blog : `https://news.microsoft.com/life/spending-time-behind-bars-employee-set-no-bars-success/`
  },
  {
    name:`Accenture`,
    imgUrl: `https://logos-world.net/wp-content/uploads/2020/06/Accenture-Emblem.png`,
    review:`Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.`,
    blog: `https://www.accenture.com/us-en/blogs/blogs-careers`
  },
  {
    name: `Hexaware Technologies`,
    imgUrl: `https://cdn.worldvectorlogo.com/logos/hexaware-technologies-1.svg`,
    review: `Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.`,
    blog: `https://hexaware.com/blogs/recruitment-the-millennials-way/`
  },
  
];

export default CareerBlogs;


























/*
import { Swiper, SwiperSlide } from "swiper/react";

import "swiper/css";
import "swiper/css/pagination";
import "swiper/css/free-mode";

import { FreeMode, Pagination } from "swiper/modules";

import { RxArrowTopRight } from "react-icons/rx";
import { ServiceData } from "../constants";

export const CareerBlogs = () => {
  return (
    <div className="flex items-center justify-center flex-col h-[900px] bg-[#6c34af]">
      <Swiper
        breakpoints={{
          340: {
            slidesPerView: 2,
            spaceBetween: 15,
          },
          700: {
            slidesPerView: 3,
            spaceBetween: 15,
          },
        }}
        freeMode={true}
        pagination={{
          clickable: true,
        }}
        modules={[FreeMode, Pagination]}
        className="max-w-[90%] lg:max-w-[80%]"
      >
        {ServiceData.map((item) => (
          <SwiperSlide key={item.title}>
            <div className="flex flex-col gap-6 mb-20 group relative shadow-lg text-white rounded-xl px-6 py-8 h-[250px] w-[215px] lg:h-[400px] lg:w-[350px] overflow-hidden cursor-pointer">
              <div
                className="absolute inset-0 bg-cover bg-center"
                style={{ backgroundImage: `url(${item.backgroundImage})` }}
              />
              <div className="absolute inset-0 bg-black opacity-10 group-hover:opacity-50" />
              <div className="relative flex flex-col gap-3">
                <item.icon className="text-blue-600 group-hover:text-blue-400 w-[32px] h-[32px]" />
                <h1 className="text-xl lg:text-2xl">{item.title} </h1>
                <p className="lg:text-[18px]">{item.content} </p>
              </div>
              <RxArrowTopRight className="absolute bottom-5 left-5 w-[35px] h-[35px] text-white group-hover:text-blue-500 group-hover:rotate-45 duration-100" />
            </div>
          </SwiperSlide>
        ))}
      </Swiper>
    </div>
  );
};

export default CareerBlogs 
*/