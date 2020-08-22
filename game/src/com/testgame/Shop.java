package com.testgame;

import java.util.Scanner;

public class Shop {
    public void displayShopMenu() {
        System.out.println("==".repeat(20));
        System.out.println("0 Nothing, wait...");
        System.out.println("1 C Castle | +5 Gold/turn | -30 GOLD");
        System.out.println("2 V Village | +1 Gold/turn | -8 GOLD");
        System.out.println("3 P Pyramid | +5 Morale | -15 GOLD");
        System.out.println("4 S Temple | +1 Morale | -5 GOLD");
        System.out.println("5 A Armory | +5 Army | -15 GOLD");
        System.out.println("6 F Farm | +1 Army | -4 GOLD");
        System.out.println("7 T Archer Tower | +5 Defence | -10 GOLD");
        System.out.println("8 W Wall | +1 Defence | -4 GOLD");
        System.out.println("Pick option 0-8: ");
    }

    public boolean buy(Player player, int price) {
        if (player.getGold() >= price) {
            player.subtractGold(price);
            return true;
        }
        System.out.println("Not enough gold...");
        return false;
    }

    public BuildingType readShop(Player player) {
        Scanner scanner = new Scanner(System.in);
        int input = 0;

        while (!scanner.hasNextInt()) {
            scanner.next();
        }

        try {
            input = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid option...");
        }

        return parseShopInput(player, input);
    }

    private BuildingType parseShopInput(Player player, int input) {
        switch (input) {
            case 0:
                return null;
            case 1:
                if (buy(player, 30)) {
                    player.addGoldIncrease(5);
                    return BuildingType.CASTLE;
                }
                return null;
            case 2:
                if (buy(player, 8)) {
                    player.addGoldIncrease(1);
                    return BuildingType.VILLAGE;
                }
                return null;
            case 3:
                if (buy(player, 15)) {
                    player.addMorale(5);
                    return BuildingType.PYRAMID;
                }
                return null;
            case 4:
                if (buy(player, 5)) {
                    player.addMorale(1);
                    return BuildingType.TEMPLE;
                }
                return null;
            case 5:
                if (buy(player, 15)) {
                    player.addArmy(5);
                    return BuildingType.ARMORY;
                }
                return null;
            case 6:
                if (buy(player, 4)) {
                    player.addArmy(1);
                    return BuildingType.FARM;
                }
                return null;
            case 7:
                if (buy(player, 10)) {
                    player.addDefence(5);
                    return BuildingType.ARCHER_TOWER;
                }
                return null;
            case 8:
                if (buy(player, 4)) {
                    player.addDefence(1);
                    return BuildingType.WALL;
                }
                return null;
            default:
                System.out.println("Option doesn't exists, skipping...");
                return null;
        }
    }
}
