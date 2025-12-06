package com.echipa.rotables.service;

import com.echipa.rotables.api.ApiClient;
import com.echipa.rotables.dto.HourResponseDto;
import com.echipa.rotables.dto.PlayRoundRequestDto;
import com.echipa.rotables.strategy.SimpleStrategy;
import com.echipa.rotables.strategy.Strategy;

public class GameLoopService {

    private final ApiClient apiClient;
    private final StockService stockService;
    private final Strategy strategy;

    public GameLoopService() {
        this.apiClient = new ApiClient();
        this.stockService = new StockService();     // ✅ creezi StockService
        this.strategy = new SimpleStrategy(stockService); // ✅ trimiți StockService la strategie
    }

    public void run() {

        String sessionId = apiClient.startSession();

        if (sessionId == null) {
            System.out.println("❌ Nu s-a putut porni sesiunea!");
            return;
        }

        System.out.println("✅ Session pornit: " + sessionId);

        HourResponseDto state = null;

        int day = 0;
        int hour = 0;

        for (int i = 0; i < 720; i++) {

            System.out.println("=== RUNDA " + i + " ===");
            System.out.println("Trimitem: day=" + day + " hour=" + hour);

            PlayRoundRequestDto decision = strategy.makeDecision(state);

            decision.setDay(day);
            decision.setHour(hour);

            state = apiClient.playRound(sessionId, decision);

            if (state == null) {
                System.out.println("❌ EROARE LA PLAY ROUND");
                break;
            }

            System.out.println(
                    "Day=" + state.getDay() +
                    " Hour=" + state.getHour() +
                    " Cost=" + state.getTotalCost()
            );

            hour++;
            if (hour == 24) {
                hour = 0;
                day++;
            }
        }

        apiClient.endSession(sessionId);
        System.out.println("✅ Session închis.");
    }
}
