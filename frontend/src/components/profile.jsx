import React from 'react'
import LoginForm from './LoginForm';
import { Header } from './Header';
import { SideNav } from './templates/SideNav';
import { Footer } from './Footer';
//s
export const Profile = () => {
  return (
    <div className="w-[100%] h-full flex flex-col overflow-x-hidden">
      <Header />
      <div className="bg-gradient-to-r from-slate-900 via-purple-950 to-slate-900 w-full h-full flex ">
        <SideNav className="w-[16%]" />
        <div className="w-[84%] h-[100%] p-2 relative">
          <LoginForm />
        </div>
      </div>
      <Footer />
    </div>
  );
};

