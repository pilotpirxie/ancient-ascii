package com.testgame;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board(5, 3);

        System.out.println("Welcome to Ancient Strategy Game!");
        System.out.println("Press enter to continue.");

        scanner.hasNextLine();

        board.draw();

        scanner.hasNextLine();
    }
}
