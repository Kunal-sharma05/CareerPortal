import React from 'react'
import { useNavigate } from 'react-router-dom';

export const Card = ({index,values,handleClick}) => {
const navigate=useNavigate();
const {title,description,image,applied}=values
const onClickHandler =()=>{
   handleClick(index)
  
};
  return (
    <div className='w-[20vw] h-[27vw] bg-gradient-to-r from-rose-100 to-teal-100 p-3 rounded-md relative'>
        <div className="w-full h-40 bg-sky-200 ">
            <img className='h-full w-full object-cover' src={image} alt="" />
        </div>
        <div className="w-full p-3">
            <h3 className='text-pretty text-xl font-semibold'>{title}</h3>
            <h5 className=' text-sm'>{description}</h5>
            <button  onClick={onClickHandler} className={` px-2 py-1 bottom-2 text-xs text-white ${applied ? 'bg-green-700' : "bg-black"} font-semibold rounded-md absolute`}> {applied ?"Applied":"Apply"} </button>
        </div>
    </div>
  )
}