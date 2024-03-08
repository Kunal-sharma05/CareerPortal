import React from 'react'
import { useNavigate } from 'react-router-dom';

export const Card = ({index,values,handleClick}) => {
const navigate=useNavigate();
const {title,description,image,applied}=values
const onClickHandler =()=>{
   handleClick(index)
   //navigate("/user"); 
};
  return (
    <div className='w-[20vw] h-full bg-zinc-100 p-3 rounded-md overflow-hidden'>
        <div className="w-full h-40 bg-sky-200 ">
            <img className='h-full w-full object-cover' src={image} alt="" />
        </div>
        <div className="w-full p-3">
            <h3 className='text-pretty text-xl font-semibold'>{title}</h3>
            <h5 className='py-1 text-sm'>{description}</h5>
            <button  onClick={onClickHandler} className={`px-3 py-1 mt-[10px] text-xs text-white ${applied ? 'bg-green-500' : "bg-blue-500"} font-semibold rounded-md`}> {applied ?"Applied":"Apply"} </button>
        </div>
    </div>
  )
}
