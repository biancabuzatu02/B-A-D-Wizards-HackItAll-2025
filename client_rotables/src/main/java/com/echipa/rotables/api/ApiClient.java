package com.echipa.rotables.api;

import com.echipa.rotables.dto.HourResponseDto;
import com.echipa.rotables.dto.PlayRoundRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {

    private static final String BASE_URL = "http://127.0.0.1:8080/api/v1";

    private final String apiKey;
    private final HttpClient client;
    private final ObjectMapper mapper;

    public ApiClient() {
        this.apiKey = System.getenv("ROTABLES_API_KEY");

        if (this.apiKey == null || this.apiKey.isBlank()) {
            throw new RuntimeException("❌ VARIABILA DE MEDIU ROTABLES_API_KEY NU ESTE SETATĂ!");
        }

        this.client = HttpClient.newHttpClient();
        this.mapper = new ObjectMapper();
    }

    // ✅ START SESSION
    public String startSession() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + "/session/start"))
                    .POST(HttpRequest.BodyPublishers.noBody())
                    .header("Content-Type", "application/json")
                    .header("API-KEY", apiKey)
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("STATUS = " + response.statusCode());
            System.out.println("BODY = ");
            System.out.println(response.body());
            System.out.println("END BODY");

            if (response.statusCode() != 200) return null;

            return response.body();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // ✅ PLAY ROUND
    public HourResponseDto playRound(String sessionId, PlayRoundRequestDto payload) {
        try {
            String json = mapper.writeValueAsString(payload);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + "/play/round"))
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .header("Content-Type", "application/json")
                    .header("API-KEY", apiKey)
                    .header("SESSION-ID", sessionId)
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("STATUS = " + response.statusCode());
            System.out.println("BODY = ");
            System.out.println(response.body());
            System.out.println("END BODY");

            if (response.statusCode() != 200) return null;

            return mapper.readValue(response.body(), HourResponseDto.class);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // ✅ END SESSION
    public void endSession(String sessionId) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + "/session/end"))
                    .POST(HttpRequest.BodyPublishers.noBody())
                    .header("Content-Type", "application/json")
                    .header("API-KEY", apiKey)
                    .header("SESSION-ID", sessionId)
                    .build();

            client.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
