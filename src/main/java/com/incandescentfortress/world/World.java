package com.incandescentfortress.world;

import java.util.Map;

public class World {
    private Map<String, Zone> zones;

    public World(Map<String, Zone> zones) {
        this.zones = zones;
    }

    public Map<String, Zone> getZones() {
        return zones;
    }
}
