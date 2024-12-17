/** @type {import('tailwindcss').Config} */
export default {
  content: ["./index.html", "./src/**/*.{js,ts,jsx,tsx}"],
  theme: {
    extend: {
      colors: {
        primary: {
          dark: "#5D4037", // Deep Brown
          light: "#D7CCC8", // Antique Beige
        },
        secondary: "#8E5348", // Burgundy
        accent: "#00897B", // Teal
        highlight: "#FBC02D", // Golden Yellow
        background: "#FAFAFA", // Soft white
        neutral: "#B0BEC5", // Muted gray
      },
      fontFamily: {
        serif: ["Playfair Display", "serif"],
        sans: ["Roboto", "sans-serif"],
      },
    },
  },
  plugins: [],
};
