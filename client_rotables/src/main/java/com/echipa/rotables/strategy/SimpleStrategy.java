package com.echipa.rotables.strategy;

import com.echipa.rotables.dto.FlightEventDto;
import com.echipa.rotables.dto.FlightLoadDto;
import com.echipa.rotables.dto.HourResponseDto;
import com.echipa.rotables.dto.PassengerDto;
import com.echipa.rotables.dto.PlayRoundRequestDto;
import com.echipa.rotables.service.StockService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleStrategy implements Strategy {

    private final StockService stockService;

    // ✅ ACESTA ESTE CONSTRUCTORUL CARE LIPSEA
    public SimpleStrategy(StockService stockService) {
        this.stockService = stockService;
    }

    @Override
    public PlayRoundRequestDto makeDecision(HourResponseDto state) {

        PlayRoundRequestDto dto = new PlayRoundRequestDto();

        int day;
        int hour;

        if (state == null) {
            day = 0;
            hour = 0;
        } else {
            day = state.getDay();
            hour = state.getHour() + 1;

            if (hour >= 24) {
                hour = 0;
                day++;
            }
        }

        dto.setDay(day);
        dto.setHour(hour);

        // === ÎNCĂRCARE ZBORURI ===
        List<FlightLoadDto> loads = new ArrayList<>();

        if (state != null && state.getFlightUpdates() != null) {
            for (FlightEventDto event : state.getFlightUpdates()) {

                if (!"CHECKED_IN".equals(event.getEventType())) continue;

                PassengerDto p = event.getPassengers();
                if (p == null) continue;

                Map<String, Integer> loadedKits = new HashMap<>();
                loadedKits.put("first", p.getFirst());
                loadedKits.put("business", p.getBusiness());
                loadedKits.put("premiumEconomy", p.getPremiumEconomy());
                loadedKits.put("economy", p.getEconomy());

                FlightLoadDto fl = new FlightLoadDto();
                fl.setFlightId(event.getFlightId());
                fl.setLoadedKits(loadedKits);

                loads.add(fl);
            }
        }

        dto.setFlightLoads(loads);

        // === ACHIZIȚII ===
        Map<String, Integer> purchases = stockService.computePurchases();
        dto.setKitPurchasingOrders(purchases);

        return dto;
    }
}
