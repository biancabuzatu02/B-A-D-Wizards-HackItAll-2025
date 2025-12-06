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
    private final HttpClient client;
    private final ObjectMapper mapper;

    public ApiClient() {
        this.client = HttpClient.newHttpClient();
        this.mapper = new ObjectMapper();
    }

    // ========== START SESSION ==========
    public HourResponseDto startSession() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + "/session/start"))
                    .POST(HttpRequest.BodyPublishers.noBody())
                    .header("Content-Type", "application/json")
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            return mapper.readValue(response.body(), HourResponseDto.class);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // ========== PLAY ROUND ==========
    public HourResponseDto playRound(PlayRoundRequestDto payload) {
        try {
            String json = mapper.writeValueAsString(payload);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + "/play/round"))
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .header("Content-Type", "application/json")
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            return mapper.readValue(response.body(), HourResponseDto.class);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // ========== END SESSION ==========
    public void endSession() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + "/session/end"))
                    .POST(HttpRequest.BodyPublishers.noBody())
                    .header("Content-Type", "application/json")
                    .build();

            client.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
