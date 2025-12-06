package com.echipa.rotables.dto;

public class PenaltyDto {

    private String code;
    private double penalty;
    private String reason;

    private String flightId;
    private String flightNumber;

    private int issuedDay;
    private int issuedHour;

    public String getCode() { return code; }
    public double getPenalty() { return penalty; }
    public String getReason() { return reason; }

    public String getFlightId() { return flightId; }
    public String getFlightNumber() { return flightNumber; }

    public int getIssuedDay() { return issuedDay; }
    public int getIssuedHour() { return issuedHour; }
}
