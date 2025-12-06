package com.echipa.rotables.dto;

import java.util.List;
import java.util.Map;

public class PlayRoundRequestDto {

    private int day;
    private int hour;

    private List<FlightLoadDto> flightLoads;

    private Map<String, Integer> kitPurchasingOrders;

    public int getDay() { return day; }
    public void setDay(int day) { this.day = day; }

    public int getHour() { return hour; }
    public void setHour(int hour) { this.hour = hour; }

    public List<FlightLoadDto> getFlightLoads() { return flightLoads; }
    public void setFlightLoads(List<FlightLoadDto> flightLoads) { this.flightLoads = flightLoads; }

    public Map<String, Integer> getKitPurchasingOrders() { return kitPurchasingOrders; }
    public void setKitPurchasingOrders(Map<String, Integer> kitPurchasingOrders) {
        this.kitPurchasingOrders = kitPurchasingOrders;
    }
}
