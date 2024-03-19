import './App.css';

import { Router } from './components/utils/Router';


function App() {
  return (
    <div className=" bg-gradient-to-r from-slate-900 via-purple-950 to-slate-900 w-screen h-screen flex flex-col overflow-auto">
      <Router/> 
    </div>
  );
}

export default App;
