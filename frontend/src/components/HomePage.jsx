import React from 'react'
import { Footer } from './Footer'
import { Header } from './Header'

export const HomePage = () => {
  return (
    <div className="flex flex-col min-h-screen">
      {/* Header */}
      <Header/>
      {/* Main content */}
      <main className="flex-grow">
        <div className="max-w-7xl mx-auto py-6 sm:px-6 lg:px-8">
          <div className="px-4 py-6 sm:px-0">
            <h2 className="text-2xl font-semibold text-zinc-100 mb-4">Find Your Next Opportunity</h2>
            {/* Job Search Form */}
            <form className="flex space-x-4">
              <input type="text" placeholder="Job title or keywords" className="w-1/2 px-4 py-2 rounded-lg border border-gray-300 focus:outline-none focus:border-blue-500" />
              <input type="text" placeholder="Location" className="w-1/2 px-4 py-2 rounded-lg border border-gray-300 focus:outline-none focus:border-blue-500" />
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
