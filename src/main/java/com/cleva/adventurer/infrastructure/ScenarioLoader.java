package com.cleva.adventurer.infrastructure;

import com.cleva.adventurer.domain.Direction;
import com.cleva.adventurer.domain.MovementScenario;
import com.cleva.adventurer.domain.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static com.cleva.adventurer.util.Constants.*;

public class ScenarioLoader {

    private static final Logger logger = LoggerFactory.getLogger(ScenarioLoader.class);

    public static MovementScenario load(String resourcePath) throws IOException {
        try (BufferedReader reader = openBufferedResource(resourcePath)) {

            Position start = parseStartPosition(readRequiredLine(reader));
            List<Direction> moves = parseDirections(readRequiredLine(reader));

            return new MovementScenario(start, moves);
        }
    }

    private static BufferedReader openBufferedResource(String resourcePath) throws IOException {
        InputStream is = ScenarioLoader.class.getClassLoader().getResourceAsStream(resourcePath);
        if (is == null) throw new IOException(ERROR_SCENARIO_NOT_FOUND + resourcePath);
        return new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
    }

    private static String readRequiredLine(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        if (line == null || line.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR_MISSING_MOVES_LINE);
        }
        return line.trim();
    }

    private static Position parseStartPosition(String line) {
        String[] parts = line.split(LINE_SEPARATOR);
        if (parts.length != 2) {
            throw new IllegalArgumentException(ERROR_INVALID_COORD_FORMAT + line);
        }

        try {
            int x = Integer.parseInt(parts[0].trim());
            int y = Integer.parseInt(parts[1].trim());

            if (x < 0 || y < 0) {
                throw new IllegalArgumentException(ERROR_INVALID_COORD_VALUES + line);
            }

            return new Position(x, y);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_COORD_VALUES + line);
        }
    }

    private static List<Direction> parseDirections(String line) {
        List<Direction> moves = new ArrayList<>();

        for (char c : line.toUpperCase().toCharArray()) {
            String letter = String.valueOf(c);
            if (VALID_DIRECTIONS.contains(letter)) {
                moves.add(Direction.valueOf(letter));
            } else if (!Character.isWhitespace(c)) {
                logger.warn(WARNING_INVALID_DIRECTION , letter);
            }
        }

        return moves;
    }
}