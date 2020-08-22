package com.testgame;

public class Player {
    private final PlayerType playerType;
    private int gold;
    private int goldIncrease = 1;
    private int morale;
    private int army;
    private int defence;

    public Player(PlayerType playerType) {
        this.playerType = playerType;
    }

    public int getGold() {
        return gold;
    }

    public void addGold() {
        this.gold = gold + goldIncrease;
    }

    public void substractGold(int goldToDecrease) {
        this.gold = gold - goldToDecrease;
    }

    public int getGoldIncrease() {
        return goldIncrease;
    }

    public void addGoldIncrease(int addGoldIncrease) {
        this.goldIncrease = goldIncrease + addGoldIncrease;
    }

    public int getMorale() {
        return morale;
    }

    public void addMorale(int addMorale) {
        this.morale = morale + addMorale;
    }

    public int getArmy() {
        return army;
    }

    public void addArmy(int addArmy) {
        this.army = army + addArmy;
    }

    public int getDefence() {
        return defence;
    }

    public void addDefence(int addDefence) {
        this.defence = defence + addDefence;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }
}
