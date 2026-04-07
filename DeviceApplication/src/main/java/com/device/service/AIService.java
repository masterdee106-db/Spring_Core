package com.device.service;

import com.device.dto.DeviceFilterDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;


import java.util.*;

@Service
public class AIService {

    private final WebClient webClient;
    private final ObjectMapper mapper = new ObjectMapper();

    public AIService(WebClient.Builder builder,
                     @Value("${groq.api.key}") String apiKey,
                     @Value("${groq.api.url}") String apiUrl) {

        this.webClient = builder
                .baseUrl(apiUrl)
                .defaultHeader("Authorization", "Bearer " + apiKey)
                .defaultHeader("Content-Type", "application/json")
                .build();
    }

    public DeviceFilterDTO convertPrompt(String prompt) {

        String aiPrompt = """
                Convert the user input into STRICT JSON.

                Rules:
                - Only JSON
                - No explanation
                - No code
                - Format:
                {
                  "category": "string",
                  "brand": "string",
                  "priceGreaterThan": number
                }

                Examples:
                Input: show laptops
                Output: {"category":"laptop"}

                Input: Samsung phones above 50000
                Output: {"category":"phone","brand":"Samsung","priceGreaterThan":50000}

                Now convert:
                """ + prompt;

        Map<String, Object> request = new HashMap<>();
        request.put("model", "llama-3.1-8b-instant");

        List<Map<String, String>> messages = new ArrayList<>();
        Map<String, String> msg = new HashMap<>();
        msg.put("role", "user");
        msg.put("content", aiPrompt);

        messages.add(msg);
        request.put("messages", messages);

        // 🔥 Force JSON output
        request.put("response_format", Map.of("type", "json_object"));

        String response = webClient.post()
                .uri("/chat/completions")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        try {
            JsonNode root = mapper.readTree(response);

            String content = root.get("choices")
                    .get(0)
                    .get("message")
                    .get("content")
                    .asText();

            if (!content.trim().startsWith("{")) {
                throw new RuntimeException("Invalid AI response: " + content);
            }

            return mapper.readValue(content, DeviceFilterDTO.class);

        } catch (Exception e) {
            throw new RuntimeException("AI Parsing Failed: " + e.getMessage());
        }
    }
}