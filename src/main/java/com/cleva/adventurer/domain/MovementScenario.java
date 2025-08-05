package com.cleva.adventurer.domain;

import java.util.List;

public class MovementScenario {
    private final Position start;
    private final List<Direction> moves;

    public MovementScenario(Position start, List<Direction> moves) {
        this.start = start;
        this.moves = moves;
    }

    public Position getStart() {
        return start;
    }

    public List<Direction> getMoves() {
        return moves;
    }
}