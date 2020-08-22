package com.testgame;

public class Menu {
   private final Board board;
   private final Player player1;
   private final Player player2;

    public Menu(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void displayStats() {
        Player currentPlayer;
        if (board.getCurrentPlayerType() == player1.getPlayerType()) {
            currentPlayer = player1;
        } else {
            currentPlayer = player2;
        }

        System.out.println("\n".repeat(5));
        System.out.println("==".repeat(20));
        System.out.println("⌛ Turn: " + board.getTurn() + " | 🤗 Current: " + board.getCurrentPlayerType());
        System.out.println("==".repeat(20));
        System.out.print("💰 Gold: " + currentPlayer.getGold() + " (+" + currentPlayer.getGoldIncrease() + ")");
        System.out.print(" | 💥 Morale: " + currentPlayer.getMorale());
        System.out.println();
        System.out.print("💥 Army: " + currentPlayer.getArmy());
        System.out.print(" | 🏰 Defence: " + currentPlayer.getDefence());
        System.out.println();
        System.out.println("==".repeat(20));
    }
}
