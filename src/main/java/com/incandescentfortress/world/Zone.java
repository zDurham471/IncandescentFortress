package com.incandescentfortress.world;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Zone {
    private String description;
    private List<String> adjacentZones;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public Zone(@JsonProperty("description") String description, @JsonProperty("adjacentZones") List<String> adjacentZones) {
        this.description = description;
        this.adjacentZones = adjacentZones;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getAdjacentZones() {
        return adjacentZones;
    }
}
