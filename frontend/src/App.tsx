import { Route, Routes, useNavigate } from 'react-router';
import Login from './pages/Login';
import Profile from './pages/Profile';
import Register from './pages/Register';
import { useState } from 'react';

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
        <Route path="/login" element={<Login onLogin={handleLogin}/>} />
        <Route path="/register" element={<Register />} />
        <Route path="/profile" element={<Profile />} />
        <Route path="*" element={<Login onLogin={handleLogin}/>} />
      </Routes>
    </>
  );
}

export default App;
