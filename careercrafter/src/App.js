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


function App() {
  return (
    <div className="App">
     {/* <LoginSignup /> */}
      <BrowserRouter>
      <Header/>
        <div className='container'>
    
          <Routes>
            <Route path='/' element={<ListUser/>}/>
            <Route path='/users' element={<ListUser/>}/>
            <Route path='*' element={<Error/>}/>
            <Route path='/addUsers' element={<AddUser/>}/>
            <Route path='/listEmployee' element={<ListEmployee/>}/>
            <Route path='/employee' element={<ListEmployee/>}/>
            <Route path='/addEmployee' element={<AddEmployer/>}/>
            <Route path='/listJobApplication' element={<ListJobApplication/>}/>
            <Route path='/jobApplication' element={<ListJobApplication/>}/>
            <Route path='/addJobApplication' element={<AddJobApplications/>}/>
            <Route path='/listJobListing' element={<ListJobListing/>}/>
            <Route path='/jobListing' element={<ListJobListing/>}/>
            <Route path='/addJobListing' element={<AddJobListing/>}/>
            <Route path='/listJobSeeker' element={<ListJobSeeker/>}/>
            <Route path='/jobSeeker' element={<ListJobSeeker/>}/>
            <Route path='/addJobSeeker' element={<AddJobSeeker/>}/>
            <Route path='/listResume' element={<ListResume/>}/>
            <Route path='/Resume' element={<ListResume/>}/>
            <Route path='/addResume' element={<AddResume/>}/>
          </Routes>
        </div>
        <Footer></Footer>
      </BrowserRouter>
    </div>
  );
}

export default App;
