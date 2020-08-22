package com.testgame;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board(5, 4);

        Player player1 = new Player(PlayerType.PLAYER1);
        Player player2 = new Player(PlayerType.PLAYER2);
        Menu menu = new Menu(board, player1, player2);
        Shop shop = new Shop();

        System.out.println("Welcome to Ancient Strategy Game!");

        board.addBuilding(BuildingType.ARMORY, PlayerType.PLAYER1);
        board.addBuilding(BuildingType.TEMPLE, PlayerType.PLAYER1);
        board.addBuilding(BuildingType.FARM, PlayerType.PLAYER1);

        while (board.isGamePlayable()) {
            menu.displayStats();
            board.drawBoard();
            shop.displayShopMenu();
            BuildingType order = shop.readShop(board.getCurrentPlayerType() == player1.getPlayerType() ? player1 : player2);
            if (order != null) {
                board.addBuilding(order, board.getCurrentPlayerType());
            } else{
                System.out.println("Nothing bought...");
            }
            board.endTurn();
            player1.addGold();
            player2.addGold();

        }


    }
}
