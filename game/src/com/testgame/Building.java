package com.testgame;

public class Building {
    private final BuildingType buildingType;

    public Building(BuildingType buildingType) {
        this.buildingType = buildingType;
    }

    public final String getSign() {
        switch (buildingType) {
            case FARM:
                return "🌽";
            case WALL:
                return "🟧";
            case ARMORY:
                return "💪";
            case ARCHER_TOWER:
                return "🏹";
            case CASTLE:
                return "👑";
            case PYRAMID:
                return "🔺";
            case TEMPLE:
                return "⛪";
            case VILLAGE:
                return "🏠";
            default:
                return "";
        }
    }
}
