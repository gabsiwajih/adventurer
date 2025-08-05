package com.cleva.adventurer.service;

import com.cleva.adventurer.domain.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class AdventurerServiceTest {

    @Test
    void shouldMoveEastThenSouth() {
        ForestMap map = new ForestMap(new char[][]{
                {' ', ' ', ' '},
                {' ', '#', ' '},
                {' ', ' ', ' '}
        });

        MovementScenario scenario = new MovementScenario(
                new Position(0, 0),
                List.of(Direction.E, Direction.S)
        );

        AdventurerService service = new AdventurerService();
        Adventurer adventurer = service.simulate(scenario, map);

        assertEquals(new Position(1, 0), adventurer.getPosition());
    }

    @Test
    void shouldThrowIfStartBlocked() {
        ForestMap map = new ForestMap(new char[][]{
                {'#', '#'},
                {' ', ' '}
        });

        MovementScenario scenario = new MovementScenario(
                new Position(0, 0),
                List.of(Direction.S)
        );

        AdventurerService service = new AdventurerService();

        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                service.simulate(scenario, map)
        );

        assertTrue(ex.getMessage().contains("starting position is blocked"));
    }

    @Test
    void shouldFollowValidPath() {
        ForestMap map = new ForestMap(new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        });

        MovementScenario scenario = new MovementScenario(
                new Position(1, 1),
                List.of(Direction.N, Direction.E, Direction.S, Direction.O)
        );

        AdventurerService service = new AdventurerService();
        Adventurer adventurer = service.simulate(scenario, map);

        assertEquals(new Position(1, 1), adventurer.getPosition());
    }

    @Test
    void shouldStayIfAllMovesBlocked() {
        ForestMap map = new ForestMap(new char[][]{
                {'#', '#', '#'},
                {'#', ' ', '#'},
                {'#', '#', '#'}
        });

        MovementScenario scenario = new MovementScenario(
                new Position(1, 1),
                List.of(Direction.N, Direction.S, Direction.E, Direction.O)
        );

        AdventurerService service = new AdventurerService();
        Adventurer adventurer = service.simulate(scenario, map);

        assertEquals(new Position(1, 1), adventurer.getPosition());
    }

    @Test
    void shouldStopAtMapBorder() {
        ForestMap map = new ForestMap(new char[][]{
                {' ', ' '},
                {' ', ' '}
        });

        MovementScenario scenario = new MovementScenario(
                new Position(0, 0),
                List.of(Direction.N, Direction.O)
        );

        AdventurerService service = new AdventurerService();
        Adventurer adventurer = service.simulate(scenario, map);

        assertEquals(new Position(0, 0), adventurer.getPosition());
    }

    @Test
    void shouldEndAtCorrectFinalPosition() {
        ForestMap map = new ForestMap(new char[][]{
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
        });

        MovementScenario scenario = new MovementScenario(
                new Position(3, 0),
                List.of(Direction.S, Direction.S, Direction.S, Direction.S,
                        Direction.E, Direction.E, Direction.E, Direction.E,
                        Direction.E, Direction.E, Direction.N, Direction.N)
        );

        AdventurerService service = new AdventurerService();
        Adventurer adventurer = service.simulate(scenario, map);

        assertEquals(new Position(9, 2), adventurer.getPosition());
    }
}