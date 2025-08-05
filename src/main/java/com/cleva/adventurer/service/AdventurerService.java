package com.cleva.adventurer.service;



import com.cleva.adventurer.domain.*;

import static com.cleva.adventurer.util.Constants.ERROR_START_BLOCKED;

public class AdventurerService {
    public Adventurer simulate(MovementScenario scenario, ForestMap map) {
        Position start = scenario.getStart();
        if (!map.isAccessible(start)) {
            throw new IllegalArgumentException(ERROR_START_BLOCKED + start);
        }
        Adventurer adventurer = new Adventurer(start);
        for (Direction dir : scenario.getMoves()) {
            adventurer.tryMove(dir, map);
        }
        return adventurer;
    }
}