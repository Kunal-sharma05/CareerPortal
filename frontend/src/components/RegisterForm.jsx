import React, { useState } from 'react';
import AuthService from "../services/AuthService";
import { useNavigate } from 'react-router-dom';

const RegisterForm = () => {
  const navigate=useNavigate();
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    password: '',
    role: ''
  });
  const [errors, setErrors] = useState({});

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await AuthService.postRegister(formData);
      navigate("/login");
    } catch (error) {
      if (error.response && error.response.data) {
        setErrors(error.response.data);
      } else {
        console.error('Registration failed:', error.message);
      }
    }
  };

  return (
    <div className="h-[65%] w-[50%] mx-auto mt-8 p-6 bg-gradient-to-r from-rose-100 to-teal-100 rounded shadow-md">
      <h2 className="text-2xl mb-4 font-semibold">Register</h2>
      <form onSubmit={handleSubmit}>
        <div className="mb-4">
          <label htmlFor="name" className="block text-sm font-medium text-gray-700">Name</label>
          <input type="text" id="name" name="name" value={formData.name} onChange={handleChange} className="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50" />
          {errors.name && <p className="text-red-500 text-xs mt-1">{errors.name}</p>}
        </div>
        <div className="mb-4">
          <label htmlFor="email" className="block text-sm font-medium text-gray-700">Email</label>
          <input type="email" id="email" name="email" value={formData.email} onChange={handleChange} className="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50" />
          {errors.email && <p className="text-red-500 text-xs mt-1">{errors.email}</p>}
        </div>
        <div className="mb-4">
          <label htmlFor="password" className="block text-sm font-medium text-gray-700">Password</label>
          <input type="password" id="password" name="password" value={formData.password} onChange={handleChange} className="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50" />
          {errors.password && <p className="text-red-500 text-xs mt-1">{errors.password}</p>}
        </div>
        <div className="mb-4">
          <label htmlFor="role" className="block text-sm font-medium text-gray-700">Role</label>
          <select id="role" name="role" value={formData.role} onChange={handleChange} className="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50">
            <option value="">Select Role</option>
            <option value="EMPLOYEE">Employee</option>
            <option value="JOB_SEEKER">job_seeker</option>
          </select>
          {errors.role && <p className="text-red-500 text-xs mt-1">{errors.role}</p>}
        </div>
        <button type="submit" className="w-full py-2 px-4 bg-black text-white rounded-md hover:bg-indigo-700 focus:outline-none focus:bg-indigo-700">Register</button>
      </form>
    </div>
  );
};

export default RegisterForm;
