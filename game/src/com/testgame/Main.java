package com.testgame;

public class Main {

    public static void main(String[] args) {
        Player player1 = new Player("John");
        Player player2 = new Player("Doe");
        Board board = new Board(3, 3, player1, player2);

        Menu menu = new Menu(board, player1, player2);
        Battle battle = new Battle(player1, player2);
        Shop shop = new Shop();

        System.out.println("Welcome to Ancient Strategy Game!");

        while (board.isEconomyState()) {
            menu.displayStats();
            board.drawBoard();
            shop.displayShopMenu();
            BuildingType order = shop.readShop(board.getCurrentPlayer());
            if (order != null) {
                board.addBuilding(order, board.getCurrentPlayer());
            } else{
                System.out.println("Nothing bought...");
            }
            board.togglePlayer();
        }

        battle.displayStats();
        board.drawBoard();
        Player winner = battle.fight();
        System.out.println(winner.getName() + " won the game!");
    }
}
