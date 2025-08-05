package com.cleva.adventurer.domain;

public enum Direction {
    N(0, -1),
    S(0, 1),
    E(1, 0),
    O(-1, 0);

    private final int dx, dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int dx() {
        return dx;
    }

    public int dy() {
        return dy;
    }
}
