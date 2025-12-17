package com.example.hospitalconcierge.controller;

import com.example.hospitalconcierge.service.HospitalDataService;
import lombok.RequiredArgsConstructor;
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
public class ChatController {

    private final ChatClient.Builder chatClientBuilder;
    private final HospitalDataService hospitalDataService;

    @Value("${spring.ai.openai.chat.model}")
    private String modelName;

    @PostMapping("/chat")
    public Map<String, String> chat(@RequestBody Map<String, String> payload) {
        String userQuestion = payload.get("message");
        String hospitalData = hospitalDataService.getHospitalDataAsText();

        ChatClient chatClient = chatClientBuilder.build();

        String systemPrompt = """
                You are a helpful Hospital Concierge for Grand Oak General Hospital.
                Use the following JSON data to answer user questions about doctors, cabins, and lab tests.
                If the answer is not in the data, politely say you don't know.

                DATA:
                %s
                """.formatted(hospitalData);

        try {
            String response = chatClient.prompt()
                    .options(org.springframework.ai.openai.OpenAiChatOptions.builder()
                            .withModel(modelName)
                            .build())
                    .system(systemPrompt)
                    .user(userQuestion)
                    .call()
                    .content();
            return Map.of("response", response);
        } catch (Exception e) {
            e.printStackTrace(); // Print to console for us
            return Map.of("response", "Error: " + e.getMessage());
        }
    }
}
