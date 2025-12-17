# Setup Guide for HospitalConcierge (Google AI Studio)

This application uses Google Gemini models via **Google AI Studio**. You need a free API Key.

## 1. Get an API Key

1.  Go to [Google AI Studio](https://aistudio.google.com/app/apikey).
2.  Click **Create API Key**.
3.  Copy the key.

## 2. Configure the Key

You have two options to set the key:

### Option A: Environment Variable (Recommended)
Set the `SPRING_AI_OPENAI_API_KEY` variable in your terminal before running.

**Mac/Linux:**
```bash
export SPRING_AI_OPENAI_API_KEY=your_api_key_here
./gradlew bootRun
```

### Option B: Properties File (Template Pattern)
1.  Copy `src/main/resources/keys.properties.example` to `src/main/resources/keys.properties`.
2.  Open `keys.properties` and paste your key:
    ```properties
    spring.ai.openai.api-key=your_actual_api_key_starts_with_AIza...
    ```
    *(Note: keys.properties is git-ignored to keep your secret safe).*

## 3. Run the App

```bash
./gradlew bootRun
```

Access the chat at [http://localhost:8080](http://localhost:8080).
