# Hospital Concierge AI Assistant

## Overview
A modern, AI-powered chatbot designed to assist hospital visitors and patients by providing real-time information about doctors, lab tests, and cabin availability. Built with **Spring Boot 3.4** and **Google Gemini (via Spring AI)**, it features a slick, responsive frontend and a robust backend architecture.

## Key Features
- **AI-Powered Context Awareness**: Uses RAG (Retrieval-Augmented Generation) pattern to answer queries based on a structural `hospital_data.json` dataset.
- **Rich UI/UX**: Custom-built frontend with **Tailwind CSS**, featuring glassmorphism, smooth animations, and a compact, mobile-responsive card layout.
- **Structured Data Rendering**: detailed information (Doctors, Tests, Cabins) is returned as structured JSON and dynamically rendered as interactive cards, while conversational answers use Markdown.
- **Robust Architecture**:
  - **Spring AI**: Integration with OpenAI/Gemini models.
  - **Global Exception Handling**: Centralized error management using `@RestControllerAdvice`.
  - **Secure Configuration**: Template-based API key management.

## Tech Stack
- **Backend**: Java 17, Spring Boot 3.4, Spring AI, Gradle
- **Frontend**: HTML5, Vanilla JavaScript, Tailwind CSS, Marked.js
- **AI Model**: Google Gemini (via OpenAI compatibility layer)
