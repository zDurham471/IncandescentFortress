package com.incandescentfortress;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.incandescentfortress.world.World;
import com.incandescentfortress.world.Zone;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class WorldBuilder {
    private ObjectMapper mapper;

    public WorldBuilder(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public World build(Path zonesPath) {
        Map<String, Zone> zones = null;
        try {
            zones = mapToZones(zonesPath.toFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new World(zones);
    }

    private Map<String, Zone> mapToZones(File zonesFile) throws IOException {
        return mapper.readValue(zonesFile, new TypeReference<HashMap<String, Zone>>() {});
    }
}
