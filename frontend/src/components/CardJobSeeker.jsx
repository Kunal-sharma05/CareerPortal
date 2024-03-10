import React from 'react'
import { useNavigate } from 'react-router-dom';

export const CardJobSeeker = ({index,values,handleClick}) => {
    const navigate=useNavigate();
    const {fullName,educationDetail,image,applied}=values
    const onClickHandler =()=>{
       handleClick(index)
       //navigate("/user"); 
    };
      return (
        <div className='w-[20vw] h-[27vw] bg-zinc-200 p-3 rounded-md relative'>
            <div className="w-full h-40 bg-sky-200 ">
                <img className='h-full w-full object-top object-cover' src={image} alt="" />
            </div>
            <div className="w-full p-3">
                <h3 className='text-pretty text-xl font-semibold'>{fullName}</h3>
                <h5 className=' text-sm'>{educationDetail}</h5>
                <button  onClick={onClickHandler} className={` px-2 py-1 bottom-4 text-xs text-white ${applied ? 'bg-green-800' : "bg-blue-500"} font-semibold rounded-md absolute`}> {applied ?"Applied":"Apply"} </button>
            </div>
        </div>
      )
}
