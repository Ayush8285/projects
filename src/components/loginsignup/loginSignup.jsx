import React, { useState } from "react";
import "./LoginSignup.css";

function LoginSignup() {
  const [isRegistered, setIsRegistered] = useState(true);

  const toggleForm = () => {
    setIsRegistered(!isRegistered);
  };

  return (
    <div className="login-signup-container">
      {isRegistered ? (
        <div className="form-container">
          <h2>Login</h2>
          <form className="login-form">
            <div className="form-group">
              <label htmlFor="login-email">Email</label>
              <input type="email" id="login-email" placeholder="Enter your email" required />
            </div>
            <div className="form-group">
              <label htmlFor="login-password">Password</label>
              <input type="password" id="login-password" placeholder="Enter your password" required />
            </div>
            <button type="submit" className="form-button">Login</button>
          </form>
          <p className="toggle-text">
            Don't have an account?{" "}
            <span className="toggle-link" onClick={toggleForm}>
              Sign Up
            </span>
          </p>
        </div>
      ) : (
        <div className="form-container">
          <h2>Sign Up</h2>
          <form className="signup-form">
            <div className="form-group">
              <label htmlFor="signup-name">Name</label>
              <input type="text" id="signup-name" placeholder="Enter your name" required />
            </div>
            <div className="form-group">
              <label htmlFor="signup-email">Email</label>
              <input type="email" id="signup-email" placeholder="Enter your email" required />
            </div>
            <div className="form-group">
              <label htmlFor="signup-password">Password</label>
              <input type="password" id="signup-password" placeholder="Create a password" required />
            </div>
            <button type="submit" className="form-button">Sign Up</button>
          </form>
          <p className="toggle-text">
            Already have an account?{" "}
            <span className="toggle-link" onClick={toggleForm}>
              Login
            </span>
          </p>
        </div>
      )}
    </div>
  );
}

export default LoginSignup;
