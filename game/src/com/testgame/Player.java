package com.testgame;

import java.util.ArrayList;

public class Player {
    private int gold = 15;
    private int goldIncrease = 1;
    private int morale;
    private int army;
    private int defence;
    private String name;

    private final ArrayList<Building> buildings;

    public Player(String name) {
        this.name = name;
        buildings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Building> getBuildings() {
        return buildings;
    }

    public void addBuilding(Building building) {
        buildings.add(building);
    }

    public int getGold() {
        return gold;
    }

    public void addGold() {
        this.gold = gold + goldIncrease;
    }

    public void subtractGold(int goldToDecrease) {
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

    public float getMoraleBonusForArmy() {
        return getArmy() > 0 ? (1 + (getMorale() / getArmy()) * 0.5f) : 1;
    }

    public float getMoraleBonusForDefence() {
        return getDefence() > 0 ? (1 + (getMorale() / getDefence()) * 0.5f) : 1;
    }

    public int getTotalArmy() {
        int finalArmy = (int) (getArmy() * getMoraleBonusForArmy());
        return finalArmy;
    }

    public int getTotalDefence() {
        int finalDefence = (int) (getDefence() * getMoraleBonusForDefence());
        return finalDefence;
    }
}
