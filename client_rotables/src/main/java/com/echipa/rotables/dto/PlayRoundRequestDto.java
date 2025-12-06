package com.echipa.rotables.dto;

import java.util.List;

public class PlayRoundRequestDto {

    private List<FlightLoadDto> flightLoads;
    private List<PurchaseDto> purchases;

    public List<FlightLoadDto> getFlightLoads() {
        return flightLoads;
    }

    public void setFlightLoads(List<FlightLoadDto> flightLoads) {
        this.flightLoads = flightLoads;
    }

    public List<PurchaseDto> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<PurchaseDto> purchases) {
        this.purchases = purchases;
    }
}
