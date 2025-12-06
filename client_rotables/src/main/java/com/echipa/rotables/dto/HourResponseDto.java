package com.echipa.rotables.dto;

import java.util.List;

public class HourResponseDto {

    private int day;
    private int hour;
    private double totalCost;
    private List<PenaltyDto> penalties;
    private List<FlightEventDto> flightUpdates;

    public int getDay() { return day; }
    public int getHour() { return hour; }
    public double getTotalCost() { return totalCost; }
    public List<PenaltyDto> getPenalties() { return penalties; }
    public List<FlightEventDto> getFlightUpdates() { return flightUpdates; }
}
