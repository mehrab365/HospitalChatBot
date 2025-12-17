# Hospital Concierge Chatbot - Walkthrough

## Overview
This is a Spring Boot application that serves as a hospital concierge chatbot. It uses **Google Gemini models** via Google AI Studio (accessed through the Spring AI OpenAI adapter) to answer user queries based on a predefined dataset of hospital services.

## Prerequisites
- Java 17 or higher
- Google AI Studio API Key (Free)

## Setup Guide

### 1. Get an API Key
1.  Go to [Google AI Studio](https://aistudio.google.com/app/apikey).
2.  Click **Create API Key**.
3.  Copy the key.

### 2. Configure the Key
You have two options to set the key:

#### Option A: Environment Variable (Recommended)
Set the `SPRING_AI_OPENAI_API_KEY` variable in your terminal before running to avoid committing secrets.

**Mac/Linux:**
```bash
export SPRING_AI_OPENAI_API_KEY=your_api_key_here
./gradlew bootRun
```

#### Option B: Hardcode (For testing only)
Open `src/main/resources/application.properties` and paste your key:
```properties
spring.ai.openai.api-key=your_actual_api_key_starts_with_AIza...
```
*(Be careful not to commit this file to GitHub if you do this).*

## Running the Application
1.  Clone the repository:
    ```bash
    git clone https://github.com/mehrab365/HospitalChatBot.git
    cd HospitalChatBot
    ```
2.  Run the application using Gradle:
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

## Development Journey

Here is a summary of the steps and prompts used to build this application:

### Step 1: Initial Scaffolding
**User Request:**
> Create a Java Spring Boot 3.4 application named "HospitalConcierge"... Dependencies: Spring Web, Spring AI (Vertex AI/Gemini)... Data: 'hospital_data.json'... Backend: REST Controller... Frontend: 'index.html' with Tailwind...

**Action Taken:**
- Generated Spring Boot project with Gradle.
- Created `hospital_data.json` with dummy hospital data.
- Implemented `ChatController` to read data and call AI.
- Created `index.html` chat interface.

### Step 2: Refactoring to Google AI Studio
**User Request:**
> lets conver the code point to Google AI Studio. then guide me about setup.

**Action Taken:**
- Replaced `spring-ai-vertex-ai-gemini` dependency with `spring-ai-openai` (adapter).
- Configured `application.properties` to point to `generativelanguage.googleapis.com`.
- Updated `SETUP.md` for API Key usage instead of `gcloud` auth.

### Step 3: Security & Best Practices
**User Request:**
> Is it the best way to export key...? When I deploy in prod what will be the best way to supply keys?

**Action Taken:**
- Advised on using Environment Variables for production.
- Added `.gitignore` to prevent committing `application.properties` containing secrets.

### Step 4: Clean Code Refactoring
**User Request:**
> why model name hardcoded? please follow best practice.

**Action Taken:**
- Refactored `ChatController` to inject model name using `@Value` annotation.
- Moved model name to `application.properties`.

### Step 5: Debugging & Model Selection
**User Request:**
> Error: 404 ... models/gemini-2.0-flash is not found ...

**Action Taken:**
- Investigated API availability.
- Switched model to `gemini-flash-latest` (Stable Alias) to resolve Quota/404 errors.
