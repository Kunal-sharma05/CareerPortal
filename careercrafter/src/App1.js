import './App.css';
import { BrowserRouter,Routes,Route} from 'react-router-dom';
import { Header } from './components/Header';
import { ListEmployee } from './components/ListEmployee';
import { Error } from './components/Error';
import { Footer } from './components/Footer';


function App1() {
  return (
    <div className="App1">
      <BrowserRouter>
      <Header/>
        <div className='container'>
          <Routes>
            <Route path='/' element={<ListEmployee/>}/>
            <Route path='/employees' element={<ListEmployee/>}/>
            <Route path='*' element={<Error/>}/>
            <Route path='/addEmployees' element={<Error/>}/>
          </Routes>
        </div>
        <Footer></Footer>
      </BrowserRouter>
    </div>
  );
}

export default App1;
