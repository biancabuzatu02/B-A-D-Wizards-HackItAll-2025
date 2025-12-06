package com.echipa.rotables.dto;

public class PassengerDto {
    private int first;
    private int business;
    private int premiumEconomy;
    private int economy;

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getBusiness() {
        return business;
    }

    public void setBusiness(int business) {
        this.business = business;
    }

    public int getPremiumEconomy() {
        return premiumEconomy;
    }

    public void setPremiumEconomy(int premiumEconomy) {
        this.premiumEconomy = premiumEconomy;
    }

    public int getEconomy() {
        return economy;
    }

    public void setEconomy(int economy) {
        this.economy = economy;
    }
}
