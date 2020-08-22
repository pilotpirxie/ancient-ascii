package com.testgame;

public class Battle {
    private Player player1;
    private Player player2;

    public Battle(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void displayStats() {
        System.out.println("\n".repeat(5));
        System.out.println("==".repeat(20));
        System.out.println("🤗 " + player1.getName() + " vs 🤗 " + player2.getName());
        System.out.println("==".repeat(20));
        displayPlayerBattleStats(player1);
        System.out.println("==".repeat(20));
        displayPlayerBattleStats(player2);

    }

    private void displayPlayerBattleStats(Player player) {
        System.out.println("🤗 " + player.getName());
        System.out.println("💥 Morale: " + player.getMorale());
        System.out.println("💪 Army: " + player.getArmy() + " (x" + player.getMoraleBonusForArmy() + " morale bonus) = " + player.getTotalArmy());
        System.out.println("🏰 Defence: " + player.getDefence() + " (x" + player.getMoraleBonusForDefence() + " morale bonus) = " + player.getTotalDefence());
    }

    public Player fight() {
        System.out.println("==".repeat(20));
        boolean isFirstPlayer = true;
        int player1Defence = player1.getTotalDefence();
        int player2Defence = player2.getTotalDefence();

        while (player1Defence > 0 && player2Defence > 0) {
            if (isFirstPlayer) {
                player2Defence -= player1.getTotalArmy();
                System.out.println(player1.getName() + " is attacking with " + player1.getTotalArmy() + ". " + player2.getName() + " has " + player2Defence + " remaining.");
            } else {
                player1Defence -= player2.getTotalArmy();
                System.out.println(player2.getName() + " is attacking with " + player2.getTotalArmy() + ". " + player1.getName() + " has " + player1Defence + " remaining.");
            }

            isFirstPlayer = !isFirstPlayer;
        }

        return player1;
    }
}
