package com.echipa.rotables.service;

import java.util.HashMap;
import java.util.Map;

public class StockService {

    // airport -> class -> quantity
    private final Map<String, Map<String, Integer>> stocks = new HashMap<>();

    // Inițializare manuală minimă (doar HUB1 pentru început)
    public StockService() {
        initAirport("HUB1", 5000, 5000, 5000, 10000);
    }

    private void initAirport(String airport,
                             int first, int business, int premium, int economy) {
        Map<String, Integer> map = new HashMap<>();
        map.put("first", first);
        map.put("business", business);
        map.put("premiumEconomy", premium);
        map.put("economy", economy);
        stocks.put(airport, map);
    }

    public int getStock(String airport, String type) {
        return stocks.getOrDefault(airport, new HashMap<>())
                .getOrDefault(type, 0);
    }

    public void addStock(String airport, String type, int qty) {
        stocks.get(airport).put(type,
                getStock(airport, type) + qty);
    }

    public boolean removeStock(String airport, String type, int qty) {
        int current = getStock(airport, type);
        if (current < qty) return false;
        stocks.get(airport).put(type, current - qty);
        return true;
    }
        public Map<String, Integer> computePurchases() {

        Map<String, Integer> purchases = new HashMap<>();

        // momentan NU cumpărăm nimic ca să nu explodeze costul
        purchases.put("first", 0);
        purchases.put("business", 0);
        purchases.put("premiumEconomy", 0);
        purchases.put("economy", 0);

        return purchases;
    }

}
