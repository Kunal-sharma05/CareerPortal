import './App.css';
import { BrowserRouter,Routes,Route} from 'react-router-dom';
import { Header } from './components/Header';
import { ListUser } from './components/ListUser';
import { Error } from './components/Error';
import { Footer } from './components/Footer';


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
            <Route path='/addUsers' element={<Error/>}/>
          </Routes>
        </div>
        <Footer></Footer>
      </BrowserRouter>
    </div>
  );
}

export default App;
