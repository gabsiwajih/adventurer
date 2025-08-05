package com.cleva.adventurer.infrastructure;

import com.cleva.adventurer.domain.ForestMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static com.cleva.adventurer.util.Constants.ERROR_MAP_NOT_FOUND;

public class ForestMapLoader {
    public static ForestMap loadFromResource(String resourcePath) throws IOException {
        InputStream is = ForestMapLoader.class.getClassLoader().getResourceAsStream(resourcePath);
        if (is == null) throw new IOException(ERROR_MAP_NOT_FOUND + resourcePath);

        List<char[]> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line.toCharArray());
            }
        }
        return new ForestMap(lines.toArray(new char[0][]));
    }
}