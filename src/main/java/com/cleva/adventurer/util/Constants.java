package com.cleva.adventurer.util;

public final class Constants {
    private Constants() {}

    public static final char ACCESSIBLE_TILE = ' ';
    public static final String LINE_SEPARATOR = ",";

    public static final String VALID_DIRECTIONS = "NSEO";

    public static final String DEFAULT_MAP_FILE = "carte/carte.txt";
    public static final String DEFAULT_SCENARIO_FILE = "scenario/scenario1.txt";

    public static final String ERROR_MAP_NOT_FOUND = "Map file not found: ";
    public static final String ERROR_SCENARIO_NOT_FOUND = "Scenario file not found: ";
    public static final String ERROR_INVALID_COORD_FORMAT = "Invalid coordinate format (expected: x,y): ";
    public static final String ERROR_INVALID_COORD_VALUES = "Coordinates must be positive integers: ";
    public static final String ERROR_MISSING_MOVES_LINE = "Missing or empty line for movement directions.";
    public static final String ERROR_START_BLOCKED = "Cannot start simulation: starting position is blocked at ";

    public static final String WARNING_INVALID_DIRECTION = "Invalid direction ignored: {}";

    public static final String OUTPUT_FINAL_POSITION = "Final position : {}";
    public static final String OUTPUT_SIMULATION_ABORTED = "Simulation aborted: {}";

}