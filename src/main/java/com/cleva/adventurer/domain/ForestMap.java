package com.cleva.adventurer.domain;

import static com.cleva.adventurer.util.Constants.ACCESSIBLE_TILE;

public class ForestMap {
    private final char[][] grid;

    public ForestMap(char[][] grid) {
        this.grid = grid;
    }

    public boolean isInside(Position pos) {
        return pos.getY() >= 0 && pos.getY() < grid.length &&
                pos.getX() >= 0 && pos.getX() < grid[pos.getY()].length;
    }

    public boolean isAccessible(Position pos) {
        return isInside(pos) && grid[pos.getY()][pos.getX()] == ACCESSIBLE_TILE;
    }
}