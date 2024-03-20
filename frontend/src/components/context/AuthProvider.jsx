import React, { createContext, useState } from "react";

export const AuthContext = createContext();

const AuthProvider = ({ children }) => {
    const [auth, setAuth] = useState({});
    const [jobListingId,setJobListingId] = useState(0)
    console.log(auth)
    return ( 
        <AuthContext.Provider value={{ auth, setAuth,jobListingId, setJobListingId }}>  
            {children}
        </AuthContext.Provider>
    );
};

export default AuthProvider;
