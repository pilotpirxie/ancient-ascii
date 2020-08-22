package com.testgame;

import java.util.ArrayList;

public class Board {
    private final int totalWidth;
    private final int singlePlayerHeight;

    private PlayerType currentPlayerTypeTurn = PlayerType.PLAYER1;
    private int turn = 0;

    private final ArrayList<Building> buildings;

    public Board(int totalWidth, int singlePlayerHeight) {
        this.totalWidth = totalWidth;
        this.singlePlayerHeight = singlePlayerHeight;

        buildings = new ArrayList<>();
    }

    private void drawPlayer(PlayerType playerType) {
        for (int i = 0; i < singlePlayerHeight * totalWidth; i++) {
            if (i < buildings.size()) {
                Building building = buildings.get(i);
                if (building.getOwner() == playerType) {
                    System.out.printf("%s ", building.getSign());
                } else {
                    System.out.print("🌵 ");
                }
            } else {
                System.out.print("🌵 ");
            }

            if (i > 0 && (i+1) % totalWidth == 0) {
                System.out.println();
            }
        }
    }

    public void drawBoard() {
        drawPlayer(PlayerType.PLAYER1);
        System.out.println("⛰ ".repeat(totalWidth));
        drawPlayer(PlayerType.PLAYER2);
    }

    public void addBuilding(BuildingType buildingType, PlayerType playerType) {
        if (getPlayerBuildingsCount(playerType) < totalWidth * singlePlayerHeight) {
            buildings.add(new Building(playerType, buildingType));
        }
    }

    public int getPlayerBuildingsCount(PlayerType playerType) {
        int total = 0;
        for (Building building : buildings) {
            if (building.getOwner() == playerType) {
                total++;
            }
        }

        return total;
    }

    public void endTurn() {
        if (currentPlayerTypeTurn == PlayerType.PLAYER1) {
            currentPlayerTypeTurn = PlayerType.PLAYER2;
        } else {
            currentPlayerTypeTurn = PlayerType.PLAYER1;
        }
        turn++;
    }

    public boolean isGamePlayable() {
        int maxBuildingsPerPlayer = totalWidth * singlePlayerHeight;

        return getPlayerBuildingsCount(PlayerType.PLAYER1) < maxBuildingsPerPlayer
                && getPlayerBuildingsCount(PlayerType.PLAYER2) < maxBuildingsPerPlayer;
    }

    public PlayerType getCurrentPlayerType() {
        return currentPlayerTypeTurn;
    }

    public int getTurn() {
        return turn;
    }

    public int getTotalWidth() {
        return totalWidth;
    }
}
