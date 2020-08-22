package com.testgame;

public class Building {
    private final PlayerType playerType;
    private final BuildingType buildingType;

    public Building(PlayerType playerType, BuildingType buildingType) {
        this.playerType = playerType;
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

    public final PlayerType getOwner() {
        return playerType;
    }
}
