import React from "react";
import "./contact.css";

function Contact() {
  return (
    <div className="contact-container">
      <h2>Contact Us</h2>
      <p>
        Have questions? We're here to help. Feel free to get in touch with us by filling out the form below or reaching out directly.
      </p>
      <form className="contact-form">
        <div className="form-group">
          <label htmlFor="name">Name</label>
          <input type="text" id="name" placeholder="Enter your name" required />
        </div>
        <div className="form-group">
          <label htmlFor="email">Email</label>
          <input type="email" id="email" placeholder="Enter your email" required />
        </div>
        <div className="form-group">
          <label htmlFor="message">Message</label>
          <textarea id="message" rows="5" placeholder="Enter your message" required></textarea>
        </div>
        <button type="submit" className="submit-button">Send Message</button>
      </form>
    </div>
  );
}

export default Contact;
