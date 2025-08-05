package com.cleva.adventurer.domain;

public class Adventurer {
    private Position position;

    public Adventurer(Position start) {
        this.position = start;
    }

    public Position getPosition() {
        return position;
    }

    public void tryMove(Direction dir, ForestMap map) {
        Position next = position.move(dir);
        if (map.isAccessible(next)) {
            position = next;
        }
    }
}