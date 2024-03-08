import './App.css';
import { BrowserRouter,Routes,Route} from 'react-router-dom';
import { Header } from './components/Header';
import { ListUser } from './components/ListUser';
import { Error } from './components/Error';
import { Footer } from './components/Footer';
import { ListEmployee } from './components/ListEmployee';
import { AddUser } from './components/addcomponents/AddUser';
import { AddEmployer } from './components/addcomponents/AddEmployer';
import { ListJobApplication } from './components/ListJobApplication';
import { AddJobApplications } from './components/addcomponents/AddJobApplication';
import { ListJobListing } from './components/ListJobListing';
import { AddJobListing } from './components/addcomponents/AddJobListing';
import { ListJobSeeker } from './components/ListJobSeeker';
import { AddJobSeeker } from './components/addcomponents/AddJobSeeker';
import { AddResume } from './components/addcomponents/AddResume';
import { ListResume } from './components/ListResume';
import LoginSignup from './components/LoginSignup/LoginSignup';
import { HomePage } from './components/HomePage';


function App() {
  return (
    <div className="App">
     {/* <LoginSignup /> */}
      <BrowserRouter>
      <Header/>
        <div className='container'>
    
          <Routes>
            <Route path='/' element={<ListUser/>}/>
            <Route path='/user' element={<ListUser/>}/>
            <Route path='*' element={<Error/>}/>
            <Route path='/addUser' element={<AddUser/>}/>
            <Route path="/update/:id" element={<AddUser/>}/>
            <Route path='/listEmployee' element={<ListEmployee/>}/>
            <Route path='/employer' element={<ListEmployee/>}/>
            <Route path='/employee/update/:id' element={<AddEmployer/>}/> 
            <Route path='/addEmployer' element={<AddEmployer/>}/>
            <Route path='/listJobApplication' element={<ListJobApplication/>}/>
            <Route path='/jobApplication' element={<ListJobApplication/>}/>
            <Route path='/addJobApplication' element={<AddJobApplications/>}/>
            <Route path='/jobApplication/update/:id' element={<AddJobApplications/>}/>
            <Route path='/listJobListing' element={<ListJobListing/>}/>
            <Route path='/jobListing' element={<ListJobListing/>}/>
            <Route path='/addJobListing' element={<AddJobListing/>}/>
            <Route path='/jobListing/update/:id' element={<AddJobListing/>}/>
            <Route path='/listJobSeeker' element={<ListJobSeeker/>}/>
            <Route path='/jobSeeker' element={<ListJobSeeker/>}/>
            <Route path='/addJobSeeker' element={<AddJobSeeker/>}/>
            <Route path='/jobSeeker/update/:id' element={<AddJobSeeker/>}/>
            <Route path='/listResume' element={<ListResume/>}/>
            <Route path='/Resume' element={<ListResume/>}/>
            <Route path='/addResume' element={<AddResume/>}/>
            <Route path='/resume/update/:id' element={<AddResume/>}/>
            <Route path='/signin' element={<LoginSignup/>}/>
            <Route path='/Home' element={<HomePage/>}/>
          </Routes>
        </div>
        <br/>
        <Footer></Footer>
      </BrowserRouter>
    </div>
  );
}

export default App;
