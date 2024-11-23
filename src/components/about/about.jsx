import React from "react";
import "./about.css";

function About() {
  return (
    <div className="about">
      <div className="background-overlay">
        <h2>About PersonaGauge</h2>
        <p>
          PersonaGauge is an innovative platform designed to analyze personality traits through 
          comprehensive CV analysis and engaging quiz questions. 
          By blending modern AI techniques with psychological profiling, 
          we provide insights to help you understand yourself better and achieve your career goals.
        </p>
        <h3>How It Works</h3>
        <ul>
          <li>Upload your CV for analysis to reveal key personality traits.</li>
          <li>Answer a series of carefully curated quiz questions to refine results.</li>
          <li>Receive a detailed personality report with actionable advice.</li>
        </ul>
        <p>
          Whether you're looking to improve personal growth, boost career prospects, 
          or simply understand yourself better, PersonaGauge is here for you.
        </p>
        <button className="cta-button">Get Started</button>
      </div>
    </div>
  );
}

export default About;
