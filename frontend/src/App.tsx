import { Navigate, Route, Routes, useNavigate } from 'react-router';
import MainLayout from './components/shared/MainLayout';
import Login from './pages/Login';
import Profile from './pages/Profile';
import Register from './pages/Register';
import { useState } from 'react';
import ScanData from './pages/ScanData';

function App() {

  const [user, setUser] = useState('');
  const navigate = useNavigate();
  const handleLogin = (userData: any) => {
    setUser(userData);
    navigate("/profile");
  }
  return (
    <>
      <Routes>
        {/* Routes without Navbar */}
        <Route path="/login" element={<Login onLogin={handleLogin}/>} />
        <Route path="/register" element={<Register />} />

        {/* Routes with Navbar */}
        <Route element={<MainLayout />}>
          <Route path="/profile" element={<Profile />} />
          <Route path="/scan-data" element={<ScanData />} />
        </Route>

        {/* Default route */}
        <Route path="*" element={<Navigate to="/login" replace />} />
      </Routes>


    </>

    


  );
}

export default App;
