package com.echipa.rotables.dto;

public class FlightEventDto {

    private String eventType;
    private String flightNumber;
    private String flightId;

    private String originAirport;
    private String destinationAirport;

    private TimeDto departure;
    private TimeDto arrival;

    private PassengerDto passengers;

    private String aircraftType;
    private double distance;

    // ===== GETTERS & SETTERS =====

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getOriginAirport() {
        return originAirport;
    }

    public void setOriginAirport(String originAirport) {
        this.originAirport = originAirport;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public TimeDto getDeparture() {
        return departure;
    }

    public void setDeparture(TimeDto departure) {
        this.departure = departure;
    }

    public TimeDto getArrival() {
        return arrival;
    }

    public void setArrival(TimeDto arrival) {
        this.arrival = arrival;
    }

    public PassengerDto getPassengers() {
        return passengers;
    }

    public void setPassengers(PassengerDto passengers) {
        this.passengers = passengers;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
