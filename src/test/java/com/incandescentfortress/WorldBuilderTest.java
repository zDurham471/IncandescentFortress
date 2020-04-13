package com.incandescentfortress;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.incandescentfortress.world.World;
import org.junit.Before;
import org.junit.Test;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class WorldBuilderTest {
    private WorldBuilder worldBuilder;
    @Before
    public void init() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory()).findAndRegisterModules();
        worldBuilder = new WorldBuilder(mapper);
    }

    @Test
    public void WorldBUilderDeserializesZones() throws URISyntaxException {
        Path zones = Paths.get(getClass().getClassLoader()
                .getResource("Zones.yml").toURI());
        World world = worldBuilder.build(zones);

        assertThat(world.getZones().size(), is(equalTo(2)));
        assertThat(world.getZones().containsKey("forest"), is(true));
        assertThat(world.getZones().get("forest").getDescription(), is(not(emptyString())));
        assertThat(world.getZones().get("forest").getAdjacentZones(), contains("fields"));
        assertThat(world.getZones().containsKey("fields"), is(true));
        assertThat(world.getZones().get("fields").getDescription(), is(not(emptyString())));
        assertThat(world.getZones().get("fields").getAdjacentZones(), contains("forest"));
    }
}
