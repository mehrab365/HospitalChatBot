# Hospital Concierge Chatbot - Walkthrough

## Overview
This is a Spring Boot application that serves as a hospital concierge chatbot. It uses OpenAI (configured via Spring AI) to answer user queries based on a predefined dataset of hospital services.

## Prerequisites
- Java 17 or higher
- OpenAI API Key

## Setup
1.  **Clone the repository**:
    ```bash
    git clone https://github.com/mehrab365/HospitalChatBot.git
    cd HospitalChatBot
    ```

2.  **Configure API Key**:
    Open `src/main/resources/application.properties` and add your OpenAI API key:
    ```properties
    spring.ai.openai.api-key=YOUR_API_KEY_HERE
    ```

## Running the Application
Run the application using Gradle:
```bash
./gradlew bootRun
```

The application will start on `http://localhost:8080`.

## Usage
1.  Open your browser and navigate to `http://localhost:8080`.
2.  You will see the chat interface.
3.  Type a message (e.g., "What services do you offer?") and hit Send.
4.  The bot will respond with information from `hospital_data.json`.

## Project Structure
- `src/main/java`: Backend Spring Boot code (`ChatController`, `HospitalDataService`).
- `src/main/resources/static/index.html`: Frontend Chat UI.
- `src/main/resources/hospital_data.json`: Dummy data for the hospital.
