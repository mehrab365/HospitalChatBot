package com.example.hospitalconcierge.controller;

import com.example.hospitalconcierge.service.HospitalDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class ChatController {

    private final ChatClient.Builder chatClientBuilder;
    private final HospitalDataService hospitalDataService;

    @Value("${spring.ai.openai.chat.model}")
    private String modelName;

    @PostMapping("/chat")
    public Map<String, String> chat(@RequestBody Map<String, String> payload) {
        String userQuestion = payload.get("message");
        log.info("Received chat request: {}", userQuestion);
        String hospitalData = hospitalDataService.getHospitalDataAsText();

        ChatClient chatClient = chatClientBuilder.build();

        String systemPrompt = """
                You are a helpful Hospital Concierge for Grand Oak General Hospital.
                Use the following JSON data to answer user questions about doctors, cabins, and lab tests.

                IMPORTANT: When the user asks to list or show ALL doctors, tests, or cabins, respond with ONLY a JSON object in this format:
                {"type": "doctors|tests|cabins", "items": [array of items from the data]}

                For specific queries or conversational questions, respond naturally in text.

                Examples:
                - "Show me all doctors" → Return JSON with type="doctors" and all doctor items
                - "List available cabins" → Return JSON with type="cabins" and all cabin items
                - "What tests do you offer?" → Return JSON with type="tests" and all test items
                - "Tell me about Dr. Sarah" → Return natural text response
                - "How much is an MRI?" → Return natural text response

                DATA:
                %s
                """
                .formatted(hospitalData);

        String response = chatClient.prompt()
                .options(org.springframework.ai.openai.OpenAiChatOptions.builder()
                        .withModel(modelName)
                        .build())
                .system(systemPrompt)
                .user(userQuestion)
                .call()
                .content();
        log.info("AI Response generated successfully");
        return Map.of("response", response);
    }
}
