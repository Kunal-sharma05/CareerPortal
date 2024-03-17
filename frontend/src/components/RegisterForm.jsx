import React, { useState } from 'react';
import AuthService from "../services/AuthService";
import { Footer } from "./Footer";
import { Header } from "./Header";

export const RegisterForm = () => {
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    password: '',
    confirmPassword: '',
    role: ''
  });
  const [errors, setErrors] = useState({});
  const [passwordMatch, setPasswordMatch] = useState(false);
  const [collapseOpen, setCollapseOpen] = useState(false);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
    // Clear errors when the user starts typing
    setErrors({ ...errors, [name]: '' });
    if (name === "confirmPassword") {
      setPasswordMatch(formData.password === value);
    }
  };

  const validateForm = () => {
    let isValid = true;
    const newErrors = {};

    if (!formData.name.trim()) {
      newErrors.name = 'Name is required';
      isValid = false;
    }

    if (!formData.email.trim()) {
      newErrors.email = 'Email is required';
      isValid = false;
    } else if (!/\S+@\S+\.\S+/.test(formData.email)) {
      newErrors.email = 'Email is invalid';
      isValid = false;
    }

    if (!formData.password.trim()) {
      newErrors.password = 'Password is required';
      isValid = false;
    } else if (formData.password.length < 8) {
      newErrors.password = 'Password must be at least 8 characters long';
      isValid = false;
    }

    if (!formData.confirmPassword.trim()) {
      newErrors.confirmPassword = 'Please confirm password';
      isValid = false;
    } else if (formData.password !== formData.confirmPassword) {
      newErrors.confirmPassword = 'Passwords do not match';
      isValid = false;
    }

    if (!formData.role) {
      newErrors.role = 'Role is required';
      isValid = false;
    }

    setErrors(newErrors);
    return isValid;
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (validateForm()) {
      try {
        await AuthService.postRegister(formData);
        alert('Registration successful!');
      } catch (error) {
        if (error.response && error.response.data) {
          setErrors(error.response.data);
        } else {
          console.error('Registration failed:', error.message);
        }
      }
    }
  };

  return (
    <div className="w-full h-full flex flex-col overflow-x-hidden">
      <Header />

      <div className="flex-grow flex bg-gradient-to-r from-slate-900 via-red-900 to-slate-900">
        <div className="flex-1 p-8">
          <div className="max-w-md bg-gradient-to-r from-rose-100 to-teal-100 rounded-md shadow-md p-8 mb-4">
            <h2 className="text-2xl mb-4 font-semibold text-center">Welcome to Career Crafter</h2>
            <p className="text-gray-700">Career Crafter is a platform where you can explore job opportunities, connect with professionals, and enhance your career skills.</p>
            <p className="text-gray-700 mt-4">Sign up now to access our exclusive features and take your career to new heights!</p>
          </div>
          <div className="max-w-md bg-gradient-to-r from-rose-100 to-teal-100 rounded-md shadow-md p-8">
            <h2 className="text-2xl mb-4 font-semibold text-center">More Details</h2>
            <button
              className="w-full py-2 px-4 bg-black text-white rounded-md hover:bg-indigo-700 focus:outline-none focus:bg-indigo-700 transition-colors duration-300 mb-4"
              onClick={() => setCollapseOpen(!collapseOpen)}
            >
              {collapseOpen ? 'Hide Details' : 'Show Details'}
            </button>
            <div className={`${collapseOpen ? 'block' : 'hidden'}`}>
              <p className="text-gray-700">
                More details about Career Crafter can go here.
              </p>
            </div>
          </div>
        </div>
        <div className="flex-1 p-8">
          <div className="w-full max-w-md bg-blue-100 rounded-md shadow-md p-8">
            <h2 className="text-2xl mb-4 font-semibold text-center">Register</h2>
            <form onSubmit={handleSubmit} className="space-y-4">
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
                <label htmlFor="confirmPassword" className="block text-sm font-medium text-gray-700">Confirm Password</label>
                <input type="password" id="confirmPassword" name="confirmPassword" value={formData.confirmPassword} onChange={handleChange} className="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50" />
                {errors.confirmPassword && <p className="text-red-500 text-xs mt-1">{errors.confirmPassword}</p>}
                {passwordMatch && <span className="text-green-500">&#10003; Passwords match</span>}
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
              <button type="submit" className="w-full py-2 px-4 bg-black text-white rounded-md hover:bg-indigo-700 focus:outline-none focus:bg-indigo-700 transition-colors duration-300">Register</button>
            </form>
          </div>
        </div>
      </div>
      <Footer />
    </div>
  );
};

export default RegisterForm;
