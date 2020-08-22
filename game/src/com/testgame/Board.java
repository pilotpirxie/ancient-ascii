package com.testgame;

public class Board {
    private final int totalWidth;
    private final int singlePlayerHeight;
    private Player currentPlayer;
    private Player player1;
    private Player player2;
    private int turn = 0;

    public Board(int totalWidth, int singlePlayerHeight, Player player1, Player player2) {
        this.totalWidth = totalWidth;
        this.singlePlayerHeight = singlePlayerHeight;

        currentPlayer = player1;
        this.player1 = player1;
        this.player2 = player2;
    }

    private void drawPlayer(Player player) {
        for (int i = 0; i < singlePlayerHeight * totalWidth; i++) {
            if (i < player.getBuildings().size()) {
                Building building = player.getBuildings().get(i);
                System.out.printf("%s ", building.getSign());
            } else {
                System.out.print("🌵 ");
            }

            if (i > 0 && (i+1) % totalWidth == 0) {
                System.out.println();
            }
        }
    }

    public void drawBoard() {
        drawPlayer(player1);
        System.out.println("⛰ ".repeat(totalWidth));
        drawPlayer(player2);
    }

    public void addBuilding(BuildingType buildingType, Player player) {
        if (player.getBuildings().size() < totalWidth * singlePlayerHeight) {
            player.addBuilding(new Building(buildingType));
        }
    }

    public void togglePlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
            turn++;
            player1.addGold();
            player2.addGold();
        }
    }

    public boolean isEconomyState() {
        int maxBuildingsPerPlayer = totalWidth * singlePlayerHeight;

        return player1.getBuildings().size() < maxBuildingsPerPlayer
                && player2.getBuildings().size() < maxBuildingsPerPlayer;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public int getTurn() {
        return turn;
    }

    public int getTotalWidth() {
        return totalWidth;
    }
}
