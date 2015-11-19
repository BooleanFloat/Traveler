package org.booleanfloat.traveler;

import org.powerbot.script.Tile;

import java.util.ArrayList;
import java.util.Collections;

public class OneWayLink {
    public OneWayLink(Location location1, Location location2) {
        this(location1, location2, new ArrayList<>(), new ArrayList<>());
    }

    public OneWayLink(Location location1, Location location2, ArrayList<Tile> waypoints) {
        this(location1, location2, waypoints, new ArrayList<>());
    }

    public OneWayLink(Location location1, Location location2, ArrayList<Tile> waypoints, ArrayList<Obstacle> obstacles) {
        new Link(location1, location2, waypoints, obstacles);
    }
}
