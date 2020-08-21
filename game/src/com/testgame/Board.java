package com.testgame;

import java.util.ArrayList;

public class Board {
    private int totalWidth;
    private int singlePlayerHeight;

    private ArrayList<Building> buildings;

    public Board(int totalWidth, int singlePlayerHeight) {
        this.totalWidth = totalWidth;
        this.singlePlayerHeight = singlePlayerHeight;

        buildings = new ArrayList<Building>();
    }

    public void draw() {
        for (int i = 0; i < singlePlayerHeight * totalWidth; i++) {
            if (i < buildings.size()) {
                Building building = buildings.get(i);
                if (building.getOwner() == Owner.PLAYER1) {
                    System.out.printf(building.getSign());
                }
            } else {
                System.out.printf(".");
            }

            if (i+1 % totalWidth == 0) {
                System.out.println();
            }
        }
    }
}
