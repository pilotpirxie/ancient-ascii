package com.testgame;

import java.util.Scanner;

public class Shop {
    public void displayShopMenu() {
        System.out.println("==".repeat(20));
        System.out.println("0 - Skip turn");
        System.out.println("1 - PALACE - 30 GOLD");
        System.out.println( "  / \\      ^        / \\       \n" +
                " /   \\             /   \\      \n" +
                "         (_____)           \n" +
                " |   |  _   _   _  |   |    \n" +
                "                \n" +
                " |   |   - _^_     |   |    \n" +
                " |  _|    //|\\\\  - |   |     \n" +
                " |   |   ///|\\\\\\   |  -|      \n" +
                " |-  |_  |||||||   |   |      \n" +
                " |   |   |||||||   |-  | ");
        System.out.println("        +5 Gold/turn ");
        System.out.println("==".repeat(20));
        System.out.println("2 - VILLAGE - 8 GOLD");
        System.out.println("~         ~~          __\n" +
                "       _T      .,,.    ~--~ ^^\n" +
                " ^^   // \\                    ~\n" +
                "      ][O]    ^^      ,-~ ~\n" +
                "   /''-I_I         _II____\n" +
                "__/_  /   \\ ______/ ''   /'\\_,__\n" +
                "  | II--'''' \\,--:--..,_/,.-{ },\n" +
                "; '/__\\,.--';|   |[] .-.| O{ _ }\n" +
                ":' |  | []  -|   ''--:.;[,.'\\,/\n" +
                "'  |[]|,.--'' '',   ''-,.    |\n" +
                "  ..    ..-''    ;       ''. '");
        System.out.println("        +1 Gold/turn ");
        System.out.println("==".repeat(20));
        System.out.println("3 - PYRAMID - 15 GOLD");
        System.out.println("          ,/`.\n" +
                "        ,'/ __`.\n" +
                "      ,'_/_  _ _`.\n" +
                "    ,'__/_ ___ _  `.\n" +
                "  ,'_  /___ __ _ __ `.\n" +
                " '-.._/___...-\"-.-..__`. ");
        System.out.println("        +5 Morale ");
        System.out.println("==".repeat(20));
        System.out.println("4 TEMPLE - 5 GOLD");
        System.out.println("                  /\\\n" +
                "     /\\          (  )  /\\\n" +
                "    (  )         |  | /  \\\n" +
                "    |  |         |   (    )\n" +
                "    |  |_________|   |    |\n" +
                "    |                |    |");
        System.out.println("        +1 Morale ");
        System.out.println("==".repeat(20));
        System.out.println("5 ARMORY - 15 GOLD");
        System.out.println(" _   |~  _\n" +
                "[_]--'--[_]\n" +
                "|'|\"\"`\"\"|'|\n" +
                "| | /^\\ | |\n" +
                "|_|_|I|_|_|");
        System.out.println("        +5 Army ");
        System.out.println("==".repeat(20));
        System.out.println("6 FARM - 4 GOLD");

        System.out.println("                           _.-^-._    .--.\n" +
                "                        .-'   _   '-. |__|\n" +
                "                       /     |_|     \\|  |\n" +
                "                      /               \\  |\n" +
                "                     /|     _____     |\\ |\n" +
                "                      |    |==|==|    |  |\n" +
                "  |---|---|---|---|---|    |--|--|    |  |\n" +
                "  |---|---|---|---|---|    |==|==|    |  |");
        System.out.println("        +1 Army ");
        System.out.println("==".repeat(20));
        System.out.println("7 ARCHER TOWER - 10 GOLD");
        System.out.println("                    .. - ----.\n" +
                "                     I'__. ..- '';\n" +
                "                     |           .\n" +
                "                     J.\n" +
                "                      L:..._.- -' .\n" +
                "                      |.\n" +
                "                      J:.\n" +
                "                       L:.. ..- -' .\n" +
                "                       |.\n" +
                "                       J:.\n" +
                "                        LP:._..- -' .\n" +
                "                        |:.\n" +
                "       ________________ J8:,          ______________a:f____" +
                "");
        System.out.println("        +5 Defence ");
        System.out.println("==".repeat(20));
        System.out.println("8 WALL - 4 GOLD");
        System.out.println("_|___|___|___|___|___|___|___|___|___|___|___|___|___|\n" +
                "___|___|___|___|___|___|___|___|___|___|___|___|___|__\n" +
                "_|___|___|___|___|___|___|___|___|___|___|___|___|___|\n" +
                "___|___|___|___|___|___|___|___|___|___|___|___|___|__\n" +
                "_|___|___|___|___|___|___|___|___|___|___|___|___|___|\n" +
                "___|___|___|___|___|___|___|___|___|___|___|___|___|__\n" );

        System.out.println("        +1 Defence ");
        System.out.println("==".repeat(20));
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
                    return BuildingType.PALACE;
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
