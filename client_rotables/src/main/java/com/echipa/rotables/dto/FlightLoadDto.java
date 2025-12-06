package com.echipa.rotables.dto;

import java.util.Map;

public class FlightLoadDto {

    private String flightId;
    private Map<String, Integer> loadedKits;

    public String getFlightId() { return flightId; }
    public void setFlightId(String flightId) { this.flightId = flightId; }

    public Map<String, Integer> getLoadedKits() { return loadedKits; }
    public void setLoadedKits(Map<String, Integer> loadedKits) {
        this.loadedKits = loadedKits;
    }
}
