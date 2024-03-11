import React from 'react'
import { Footer } from './Footer'
import { Header } from './Header'

export const HomePage = () => {
  return (
    <div className="flex flex-col min-h-screen">
      {/* Header */}
      <Header/>
      {/*Image*/}
      <div className='h-[20%] w-screen flex translate-y-16 mb-[10%] overflow-auto ' style={{ scrollbarWidth: 'none'}}>
        <img src="https://1000logos.net/wp-content/uploads/2021/11/Logo-Opera-768x432.png" alt="" className='' />
        <img src="https://1000logos.net/wp-content/uploads/2016/11/Google-Symbol.png" alt="" />
        <img src="https://1000logos.net/wp-content/uploads/2017/02/Apple-Logosu.png" alt="" />
        <img src="https://1000logos.net/wp-content/uploads/2021/11/Logo-Linkedin-768x432.png" alt="" />
        <img src="https://1000logos.net/wp-content/uploads/2021/11/Logo-Telegram-768x432.png" alt="" />
        <img src="https://1000logos.net/wp-content/uploads/2021/11/Logo-Pinterest.png" alt="" />
      </div>
      {/* Main content */}
      <main className="flex-grow translate-y-4 mb-3 bg-[conic-gradient(at_bottom_left,_var(--tw-gradient-stops))] from-fuchsia-300 via-green-400 to-rose-700 ">
        <div className="max-w-7xl mx-auto py-6 sm:px-6 lg:px-8">
          <div className="px-4 py-6 sm:px-0">
            <h2 className="text-2xl font-semibold text-black mb-4 font-arial">Find Your Next Opportunity</h2>
            {/* Job Search Form */}
            <form className="flex space-x-4">
              <input type="text" placeholder="Job title or keywords" className=" text-red w-1/2 px-4 py-2 rounded-lg border-2 border-gray-500 focus:outline-none focus:border-blue-500" />
              <input type="text" placeholder="Location" className="w-1/2 px-4 py-2 rounded-lg border-2 border-gray-500 focus:outline-none focus:border-blue-500" />
              <button type="submit" className="px-6 py-2 bg-blue-500 text-zinc-100 rounded-lg hover:bg-blue-600 transition-colors duration-300">Search</button>
            </form>
          </div>
        </div>
      </main>

      {/* Footer */}
      <Footer/>
    </div>
  )
}
