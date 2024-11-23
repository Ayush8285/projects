import React from "react";
import "./home.css";

function Home() {
  return (
    <div className="home">
      {/* Falling stars container */}
      <div className="falling-stars">
        {[...Array(100)].map((_, index) => (
          <span key={index} style={{ left: `${Math.random() * 100}vw`, animationDuration: `${Math.random() * 3 + 2}s` }}></span>
        ))}
      </div>

      <div className="background-overlay">
        <h2>Welcome to PersonaGauge</h2>
        <p>
          Discover insights into personalities through CV analysis and interactive quizzes. 
          Get started on your journey to uncover hidden potential and tailor-fit opportunities!
        </p>
        <button className="cta-button">Get Started</button>
      </div>
    </div>
  );
}

export default Home;
