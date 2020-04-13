package com.incandescentfortress;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.incandescentfortress.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class App {
    private static final Logger LOG = LoggerFactory.getLogger(App.class);
    private static final App app = new App();

    private static World world;

    private App() {
        LOG.debug("Application Start");
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory()).findAndRegisterModules();
        WorldBuilder worldBuilder = new WorldBuilder(objectMapper);
        try {
            Path zones = Paths.get(Objects.requireNonNull(getClass().getClassLoader()
                    .getResource("Zones.yml")).toURI());
            world = worldBuilder.build(zones);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private void loop() {
        //TODO Everything
    }

    public static void main( String[] args ) {
            app.loop();
    }
}
