import React, { useEffect } from "react";
import "./footer.css";

function Footer() {
  useEffect(() => {
    const starContainer = document.querySelector(".footer-falling-stars");
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
    <footer className="footer">
      <p className="footer-content">&copy; 2024 PersonaGauge. All rights reserved.</p>
      <div className="footer-falling-stars"></div>
    </footer>
  );
}

export default Footer;
