package com.testgame;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) {
       // System.out.println("Welcome to Ancient Strategy Game!");
        StartLabel label = new StartLabel();
        label.CreateLabel();
        System.out.println("\u001b[33m");
        Scanner scanner = new Scanner(System.in);

        //System.out.println("Choose mode: ");

        System.out.println("First player nickname:");
        while (!scanner.hasNextLine()) {
            scanner.next();
        }
        Player player1 = new Player(scanner.nextLine());

        System.out.println("Second player nickname:");
        while (!scanner.hasNextLine()) {
            scanner.next();
        }
        Player player2 = new Player(scanner.nextLine());

        Board board = new Board(5, 5, player1, player2);
        Menu menu = new Menu(board, player1, player2);
        Battle battle = new Battle(player1, player2);
        Shop shop = new Shop();
        
        while (board.isEconomyState()) {
            menu.displayStats();
            board.drawBoard();
            int menudis;
            System.out.println("==".repeat(20));
            System.out.println("Press 0 - to skip turn | Press 1 - to open the shop");
            System.out.println("==".repeat(20));
            while (!scanner.hasNextLine()) {
                scanner.next();
            }
            menudis = parseInt(scanner.nextLine());
            if (menudis == 1){

                shop.displayShopMenu();
                BuildingType order = shop.readShop(board.getCurrentPlayer());
                if (order != null) {
                    board.addBuilding(order, board.getCurrentPlayer());
                } else{
                    System.out.println("Nothing bought...");
                }
            }
            else {


            }


            board.togglePlayer();
        }

        battle.displayStats();
        board.drawBoard();
        Player winner = battle.fight();
        System.out.println(winner.getName() + " won the game!");
    }


}
