# 📖 Adding a New Page in a Vite + React + TypeScript Project

This guide walks you through adding a new page to an existing **Vite + React + TypeScript** app.

---

## 1. 📂 Locate the `src` Folder
In your project structure, you should see a `src/` directory.  
This is where all your React components and pages live.

```
frontend/
├── src/
│ ├── App.tsx
│ ├── main.tsx
│ ├── pages/ <-- focus here
│ └── components/
```



---

## 2. 📝 Create a New Page Component
Inside the `src/pages/` folder, create a new file.  
For example, let's create **`About.tsx`**:

```tsx
// src/pages/About.tsximport React from "react";

import { Card, CardContent } from "@/components/ui/card"; // feel free to use/create components 

export default function About() {
  return (
    <div className="p-6">
      <h1 className="text-2xl font-bold">About Page</h1>
      <p>Welcome to the About page of our app 🚀</p>
    </div>
  );
}
```

## 3. 🔗 Update Your Router

Open `src/App.tsx`.
Add your new page route:

```tsx
// src/App.tsx
import { Navigate, Route, Routes, useNavigate } from 'react-router';
import MainLayout from './components/shared/MainLayout';
import Login from './pages/Login';
import Profile from './pages/Profile';
import Register from './pages/Register';
import About from "./pages/About"; // add your new page function here

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

          {/* Add New Page routes here */}
          <Route path="/about" element={<About />} />  {/* ✅ New page */}
        </Route>



        {/* Default route */}
        <Route path="*" element={<Navigate to="/login" replace />} />
      </Routes>


    </>

    


  );
}

export default App;

```


If you want to put your page into navigation bar options, open `src/components/shared/Navbar.tsx` and add your page:

```tsx
const navItems = [
    { label: 'About', href: '/about' },
    { label: 'Profile', href: '/profile' },
    { label: 'Scan data', href: '/scan-data' },
];
```

## 4. 🚀 Run Your App

Start your development server:

`npm run dev`


Navigate to:

http://localhost:5173/
 → Login Page

http://localhost:5173/profile
 → Profile Page

http://localhost:5173/about
 → About Page
