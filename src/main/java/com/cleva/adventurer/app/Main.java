package com.cleva.adventurer.app;


import com.cleva.adventurer.domain.Adventurer;
import com.cleva.adventurer.domain.ForestMap;
import com.cleva.adventurer.domain.MovementScenario;
import com.cleva.adventurer.infrastructure.ForestMapLoader;
import com.cleva.adventurer.infrastructure.ScenarioLoader;
import com.cleva.adventurer.service.AdventurerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.cleva.adventurer.util.Constants.DEFAULT_MAP_FILE;
import static com.cleva.adventurer.util.Constants.DEFAULT_SCENARIO_FILE;
import static com.cleva.adventurer.util.Constants.OUTPUT_FINAL_POSITION;
import static com.cleva.adventurer.util.Constants.OUTPUT_SIMULATION_ABORTED;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        ForestMap map = ForestMapLoader.loadFromResource(DEFAULT_MAP_FILE);
        try {
            MovementScenario scenario = ScenarioLoader.load(DEFAULT_SCENARIO_FILE);
            AdventurerService service = new AdventurerService();
            Adventurer adventurer = service.simulate(scenario, map);
            logger.info(OUTPUT_FINAL_POSITION, adventurer.getPosition());
        } catch (IllegalArgumentException e) {
            logger.error(OUTPUT_SIMULATION_ABORTED , e.getMessage());
        }
    }
}
