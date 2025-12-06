package com.echipa.rotables;

import com.echipa.rotables.service.GameLoopService;

public class Main {

    public static void main(String[] args) {
        System.out.println("Client Rotables pornit!");

        GameLoopService gameLoopService = new GameLoopService();
        gameLoopService.run();

        System.out.println("Client Rotables oprit!");
    }
}
