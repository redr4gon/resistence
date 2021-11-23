package br.com.resistence.network.model;

public enum InventoryType {

    GUN(4), BULLETS(3), WATER(2), FOOD(1);

    Integer points;

    InventoryType(Integer points) {
        this.points = points;
    }

    public Integer getPoints() {
        return points;
    }
}
