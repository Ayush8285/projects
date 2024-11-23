import React, { useEffect } from "react";
import { Link } from "react-router-dom";
import "./header.css";

function Header() {
  useEffect(() => {
    const starContainer = document.querySelector(".falling-stars");
    const numberOfStars = 50; // Adjust for more or fewer stars

    for (let i = 0; i < numberOfStars; i++) {
      const star = document.createElement("span");
      const size = Math.random() * 3 + 1; // Random star size
      const left = Math.random() * 100; // Random horizontal position
      const duration = Math.random() * 5 + 2; // Random fall speed
      const delay = Math.random() * -10; // Random start delay

      star.style.width = `${size}px`;
      star.style.height = `${size * 10}px`;
      star.style.left = `${left}%`;
      star.style.animationDuration = `${duration}s`;
      star.style.animationDelay = `${delay}s`;

      starContainer.appendChild(star);
    }
  }, []);

  return (
    <header className="header">
      <div className="logo-container">
        <h1 className="logo">PersonaGauge</h1>
        <p className="tagline">Unlock Your True Potential</p>
      </div>
      <nav className="nav">
        <Link to="/" className="nav-link">Home</Link>
        <Link to="/about" className="nav-link">About</Link>
        <Link to="/contact" className="nav-link">Contact Us</Link>
        <Link to="/login-signup" className="nav-link special-link">Login / Sign Up</Link>
      </nav>
      <div className="falling-stars"></div>
    </header>
  );
}

export default Header;
