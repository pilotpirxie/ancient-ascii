package com.testgame;

public class Building {
    private Owner owner;
    private BuildingType buildingType;

    public Building(Owner owner, BuildingType buildingType) {
        this.owner = owner;
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

    public final BuildingType getBuildingType() {
        return buildingType;
    }

    public final Owner getOwner() {
        return owner;
    }
}
