package com.testgame;

public class Building {
    private final BuildingType buildingType;

    public Building(BuildingType buildingType) {
        this.buildingType = buildingType;
    }

    public final String getSign() {
        switch (buildingType) {
            case FARM:
                return "F";
            case WALL:
                return "W";
            case ARMORY:
                return "A";
            case ARCHER_TOWER:
                return "T";
            case CASTLE:
                return "C";
            case PYRAMID:
                return "P";
            case TEMPLE:
                return "S";
            case VILLAGE:
                return "V";
            default:
                return "";
        }
    }
}
