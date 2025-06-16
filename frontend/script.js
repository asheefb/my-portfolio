// Mobile menu toggle
const mobileMenuButton = document.getElementById("mobile-menu-button");
const mobileMenu = document.getElementById("mobile-menu");

mobileMenuButton.addEventListener("click", () => {
  mobileMenu.classList.toggle("hidden");
});

// Close mobile menu when clicking on a link
const mobileLinks = mobileMenu.querySelectorAll("a");
mobileLinks.forEach((link) => {
  link.addEventListener("click", () => {
    mobileMenu.classList.add("hidden");
  });
});

// Smooth scrolling for anchor links
document.querySelectorAll('a[href^="#"]').forEach((anchor) => {
  anchor.addEventListener("click", function (e) {
    e.preventDefault();

    const targetId = this.getAttribute("href");
    const targetElement = document.querySelector(targetId);

    if (targetElement) {
      window.scrollTo({
        top: targetElement.offsetTop - 80,
        behavior: "smooth",
      });
    }
  });
});

// Project modal functionality
const detailsBtn = document.getElementById("details-btn");
const demoBtn = document.getElementById("demo-btn");
const projectModal = document.getElementById("project-modal");
const closeModal = document.getElementById("close-modal");

detailsBtn.addEventListener("click", () => {
  projectModal.classList.remove("hidden");
  document.body.style.overflow = "hidden";
});

demoBtn.addEventListener("click", () => {
  alert("Demo functionality would be implemented here in a real portfolio.");
});

closeModal.addEventListener("click", () => {
  projectModal.classList.add("hidden");
  document.body.style.overflow = "auto";
});

// Close modal when clicking outside
projectModal.addEventListener("click", (e) => {
  if (e.target === projectModal) {
    projectModal.classList.add("hidden");
    document.body.style.overflow = "auto";
  }
});

// Contact form submission
document.getElementById('contact-form').addEventListener('submit', async (e) => {
  e.preventDefault();
  
  const formData = {
    name: document.getElementById('name').value,
    email: document.getElementById('email').value,
    subject: document.getElementById('subject').value,
    message: document.getElementById('message').value
  };

  try {
    const response = await fetch('http://localhost:8080/api/contact/send-email', { // Note: Removed /send-email
      method: 'POST',
      headers: {
        'Content-Type': 'application/json', // Changed to JSON
      },
      body: JSON.stringify(formData)
    });
    
    const result = await response.json();
    alert(result.message);
    e.target.reset();
  } catch (error) {
    alert('Error sending message: ' + error.message);
  }
});

// Add active class to nav links based on scroll position
window.addEventListener("scroll", () => {
  const sections = document.querySelectorAll("section");
  const navLinks = document.querySelectorAll("nav a");

  let current = "";

  sections.forEach((section) => {
    const sectionTop = section.offsetTop;
    const sectionHeight = section.clientHeight;

    if (window.pageYOffset >= sectionTop - 100) {
      current = section.getAttribute("id");
    }
  });

  navLinks.forEach((link) => {
    link.classList.remove("text-blue-800", "font-medium");
    if (link.getAttribute("href") === `#${current}`) {
      link.classList.add("text-blue-800", "font-medium");
    }
  });
});
