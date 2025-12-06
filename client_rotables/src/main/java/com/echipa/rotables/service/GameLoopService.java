package com.echipa.rotables.service;

import com.echipa.rotables.api.ApiClient;
import com.echipa.rotables.dto.HourResponseDto;
import com.echipa.rotables.dto.PlayRoundRequestDto;
import com.echipa.rotables.strategy.SimpleStrategy;
import com.echipa.rotables.strategy.Strategy;

public class GameLoopService {

    private final ApiClient apiClient;
    private final Strategy strategy;

    public GameLoopService() {
        this.apiClient = new ApiClient();
        this.strategy = new SimpleStrategy();
    }

    public void run() {

        HourResponseDto state = apiClient.startSession();

        if (state == null) {
            System.out.println("❌ Nu s-a putut porni sesiunea!");
            return;
        }

        for (int i = 0; i < 5; i++) {

            PlayRoundRequestDto decision = strategy.makeDecision(state);
            state = apiClient.playRound(decision);

            if (state == null) break;

            System.out.println(
                    "Day=" + state.getDay() +
                    " Hour=" + state.getHour() +
                    " Cost=" + state.getTotalCost()
            );
        }

        apiClient.endSession();
    }
}
