import React from 'react'

export const HomePage = () => {
  return (
    <div className="flex flex-col min-h-screen bg-gray-100">
      {/* Header */}
      <header className="bg-white shadow">
        <div className="max-w-7xl mx-auto py-6 px-4 sm:px-6 lg:px-8">
          <h1 className="text-3xl font-bold text-gray-900">CareerCrafter©️</h1>
        </div>
      </header>

      {/* Main content */}
      <main className="flex-grow">
        <div className="max-w-7xl mx-auto py-6 sm:px-6 lg:px-8">
          <div className="px-4 py-6 sm:px-0">
            <h2 className="text-2xl font-semibold text-gray-900 mb-4">Find Your Next Opportunity</h2>
            {/* Job Search Form */}
            <form className="flex space-x-4">
              <input type="text" placeholder="Job title or keywords" className="w-1/2 px-4 py-2 rounded-lg border border-gray-300 focus:outline-none focus:border-blue-500" />
              <input type="text" placeholder="Location" className="w-1/2 px-4 py-2 rounded-lg border border-gray-300 focus:outline-none focus:border-blue-500" />
              <button type="submit" className="px-6 py-2 bg-blue-500 text-white rounded-lg hover:bg-blue-600 transition-colors duration-300">Search</button>
            </form>
          </div>
        </div>
      </main>

      {/* Footer */}
      <footer className="bg-gray-800 text-white">
        <div className="max-w-7xl mx-auto py-6 px-4 sm:px-6 lg:px-8">
          <p className="text-center text-sm">&copy; 2024 Career Portal. All rights reserved.</p>
        </div>
      </footer>
    </div>
  )
}
