import React, { useState } from "react";
import { Card } from "./Card";

export const HomePage = () => {
  const data = [
    {
      title: "Data Analyst",
      description: "Required experience of minimum 1 year",
      image:
        "https://storage.googleapis.com/gd-prod/images/f4f4bc5f-904a-4b61-972f-c403bc060679.faa49ab5e1fff880.webp",
        applied:false,
    },
    {
      title: "SDE-2",
      description: "Required experience of minimum 2 year",
      image:
        "https://www.logodesignlove.com/wp-content/uploads/2012/08/microsoft-logo-02.jpeg",
        applied:false,
    },
    {
      title: "SDE-3",
      description: "Required experience of minimum 3 year",
      image:
        "https://chatgptaihub.com/wp-content/uploads/2023/06/ChatGPT-logo-with-color-Background.png",
        applied:false,
    },
    {
      title: "Associate SE",
      description: "Required experience of minimum 0-1 year",
      image:
        "https://ik.imagekit.io/tp/20220201-accenture-logo.png",
        applied:false,
    },
  ];
  const [realData,setRealData] = useState(data);
  // state is changeable at the position where it is made 
  console.log(realData);

  const handleApplyButton = (cardIndex) => {
    console.log("index passed",cardIndex);
    setRealData((prev)=>{
       return prev.map((item,index)=>{
            if(index===cardIndex)
            {
                return {...item, applied: !item.applied};
            }
            return item; 
        });
    });
  };
  return (
    <>
      <div className="w-full h-full grid gap-4 grid-cols-4   ">
        {realData.map((item, key) => (
          <Card
            key={key}
            index={key}
            values={item}
            handleClick={handleApplyButton}
          />
        ))}
      </div>
    </>
  );
};
