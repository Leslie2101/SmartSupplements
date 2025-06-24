// src/pages/Register.tsx
import { Button } from '@/components/ui/button';
import { Input } from '@/components/ui/input';
import { Label } from '@/components/ui/label';
import { Checkbox } from '@/components/ui/checkbox';
import { Card, CardContent, CardHeader, CardTitle } from '@/components/ui/card';
import { useState } from 'react';
import { Link } from 'react-router';
import axios from 'axios';

export default function Register() {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');
  const [registrationSuccess, setRegistrationSuccess] = useState(false);
  const [errorMsg, setErrorMsg] = useState('');

  const handleRegistration = async () => {
    setErrorMsg('');
    try {
      const userData = {
        name,
        email,
        password
      };

      console.log("Sending data to backend:", userData);


      const response = await axios.post('http://localhost:8080/api/auth/add', userData);
      console.log('User registered:', response.data);

    } catch (error: any) {
      console.error('Registration error:', error);
      if (error.response && error.response.status === 400) {
        setErrorMsg(error.response.data); // this will be "Email already taken"
      } else {
        setErrorMsg('Registration failed. Please try again.');
      }
    }
    setRegistrationSuccess(true);
  };

  if (registrationSuccess){
    return (
      <div className='centered-container'>
        <div className="login-container">
        <h1>Registration success!</h1>
        <h2> </h2>
        <div className="registration-link">
          <p>Login into your account <a href="/login">Login here</a></p>
        </div>
        </div>
  
      </div>);
  }
  return (
    <div className="min-h-screen flex items-center justify-center p-4 bg-gradient-to-br from-green-50 via-teal-50 to-emerald-50">
      {/* Decorative health-related background */}
      <div className="absolute inset-0 overflow-hidden">
        <div className="absolute top-20 right-10 w-32 h-32 bg-green-200/20 rounded-full blur-xl"></div>
        <div className="absolute top-40 left-20 w-40 h-40 bg-teal-200/20 rounded-full blur-xl"></div>
        <div className="absolute bottom-32 right-20 w-36 h-36 bg-emerald-200/20 rounded-full blur-xl"></div>
      </div>

      <div className="w-full max-w-md relative z-10">
        <Card className="bg-white/80 backdrop-blur-sm border-white/40 shadow-xl">
          <CardHeader className="text-center">
            {/* Health App Logo - Register Theme */}
            <div className="flex justify-center mb-6">
              <div className="w-20 h-20 bg-gradient-to-br from-green-400 to-teal-500 rounded-2xl flex items-center justify-center shadow-lg">
                <svg className="w-10 h-10 text-white" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                  <path
                    strokeLinecap="round"
                    strokeLinejoin="round"
                    strokeWidth={2}
                    d="M18 9v3m0 0v3m0-3h3m-3 0h-3m-2-5a4 4 0 11-8 0 4 4 0 018 0zM3 20a6 6 0 0112 0v1H3v-1z"
                  />
                </svg>
              </div>
            </div>

            <CardTitle className="text-3xl font-bold text-gray-800 mb-2">Create Account</CardTitle>
            <p className="text-gray-600">Start your health journey</p>
          </CardHeader>
          <CardContent>
            <form className="space-y-5">
              <div>
                <Label htmlFor="name" className="text-gray-700 font-medium mb-2 block">
                  Full Name
                </Label>
                <div className="relative">
                  <div className="absolute inset-y-0 left-0 pl-3 flex items-center pointer-events-none">
                    <svg className="h-5 w-5 text-gray-400" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                      <path
                        strokeLinecap="round"
                        strokeLinejoin="round"
                        strokeWidth={2}
                        d="M16 7a4 4 0 11-8 0 4 4 0 018 0zM12 14a7 7 0 00-7 7h14a7 7 0 00-7-7z"
                      />
                    </svg>
                  </div>
                  <Input
                    id="name"
                    placeholder="John Doe"
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                    className="pl-10 h-12 border-gray-200 focus:border-green-400 focus:ring-green-400 rounded-xl"
                  />
                </div>
              </div>

              <div>
                <Label htmlFor="email" className="text-gray-700 font-medium mb-2 block">
                  Email
                </Label>
                <div className="relative">
                  <div className="absolute inset-y-0 left-0 pl-3 flex items-center pointer-events-none">
                    <svg className="h-5 w-5 text-gray-400" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                      <path
                        strokeLinecap="round"
                        strokeLinejoin="round"
                        strokeWidth={2}
                        d="M16 12a4 4 0 10-8 0 4 4 0 008 0zm0 0v1.5a2.5 2.5 0 005 0V12a9 9 0 10-9 9m4.5-1.206a8.959 8.959 0 01-4.5 1.207"
                      />
                    </svg>
                  </div>
                  <Input
                    id="email"
                    type="email"
                    placeholder="your@email.com"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    className="pl-10 h-12 border-gray-200 focus:border-green-400 focus:ring-green-400 rounded-xl"
                  />
                </div>
              </div>

              <div>
                <Label htmlFor="password" className="text-gray-700 font-medium mb-2 block">
                  Password
                </Label>
                <div className="relative">
                  <div className="absolute inset-y-0 left-0 pl-3 flex items-center pointer-events-none">
                    <svg className="h-5 w-5 text-gray-400" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                      <path
                        strokeLinecap="round"
                        strokeLinejoin="round"
                        strokeWidth={2}
                        d="M12 15v2m-6 4h12a2 2 0 002-2v-6a2 2 0 00-2-2H6a2 2 0 00-2 2v6a2 2 0 002 2zm10-10V7a4 4 0 00-8 0v4h8z"
                      />
                    </svg>
                  </div>
                  <Input
                    id="password"
                    type="password"
                    placeholder="••••••••"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                    className="pl-10 h-12 border-gray-200 focus:border-green-400 focus:ring-green-400 rounded-xl"
                  />
                </div>
              </div>

              <div>
                <Label htmlFor="confirm-password" className="text-gray-700 font-medium mb-2 block">
                  Confirm Password
                </Label>
                <div className="relative">
                  <div className="absolute inset-y-0 left-0 pl-3 flex items-center pointer-events-none">
                    <svg className="h-5 w-5 text-gray-400" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                      <path
                        strokeLinecap="round"
                        strokeLinejoin="round"
                        strokeWidth={2}
                        d="M9 12l2 2 4-4m6 2a9 9 0 11-18 0 9 9 0 0118 0z"
                      />
                    </svg>
                  </div>
                  <Input
                    id="confirm-password"
                    type="password"
                    placeholder="••••••••"
                    value={confirmPassword}
                    onChange={(e) => setConfirmPassword(e.target.value)}
                    className="pl-10 h-12 border-gray-200 focus:border-green-400 focus:ring-green-400 rounded-xl"
                  />
                </div>
              </div>

              <div className="flex items-start space-x-3">
                <Checkbox 
                  id="terms" 
                  className="mt-1 data-[state=checked]:bg-green-600 data-[state=checked]:border-green-600" 
                />
                <label htmlFor="terms" className="text-sm text-gray-700 leading-5 cursor-pointer hover:text-gray-800 transition-colors duration-200">
                  I agree to the{' '}
                  <a href="#" className="text-green-600 hover:text-green-700 font-medium transition-colors duration-200">
                    Terms of Service
                  </a>{' '}
                  and{' '}
                  <a href="#" className="text-green-600 hover:text-green-700 font-medium transition-colors duration-200">
                    Privacy Policy
                  </a>
                </label>
              </div>

              <Button className="w-full h-12 bg-gradient-to-r from-green-500 to-teal-600 hover:from-green-600 hover:to-teal-700 text-white font-semibold rounded-xl shadow-lg transition-all duration-200 transform hover:scale-[1.02] cursor-pointer" onClick={(e) => {e.preventDefault();  handleRegistration();}}>
                <svg className="w-5 h-5 mr-2" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                  <path
                    strokeLinecap="round"
                    strokeLinejoin="round"
                    strokeWidth={2}
                    d="M18 9v3m0 0v3m0-3h3m-3 0h-3m-2-5a4 4 0 11-8 0 4 4 0 018 0zM3 20a6 6 0 0112 0v1H3v-1z"
                  />
                </svg>
                Create Account
              </Button>
              {errorMsg && (
                <div className="text-red-600 font-medium text-sm mb-4">
                  {errorMsg}
                </div>
              )}
            </form>

            <div className="mt-8 pt-6 border-t border-gray-200">
              <p className="text-center text-gray-600 text-sm">
                Already have an account?{' '}
                <Link to="/login" className="text-green-600 hover:text-green-700 font-semibold">
                  Sign in now
                </Link>
              </p>
            </div>

            {/* Health benefits */}
            <div className="mt-6 p-4 bg-green-50 rounded-xl border border-green-100">
              <div className="flex items-start space-x-3">
                <div className="flex-shrink-0">
                  <svg className="w-5 h-5 text-green-600 mt-0.5" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                    <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M13 10V3L4 14h7v7l9-11h-7z" />
                  </svg>
                </div>
                <div>
                  <p className="text-sm text-green-800 font-medium">Benefits of joining</p>
                  <p className="text-sm text-green-700 mt-1">
                    Track your health, set goals, and receive personalized advice!
                  </p>
                </div>
              </div>
            </div>
          </CardContent>
        </Card>
      </div>
    </div>
  );
}

