package org.booleanfloat.traveler;

import org.powerbot.script.Tile;

import java.util.ArrayList;
import java.util.Collections;

public class TwoWayLink {
    public TwoWayLink(Location location1, Location location2) {
        this(location1, location2, new ArrayList<>(), new ArrayList<>());
    }

    public TwoWayLink(Location location1, Location location2, ArrayList<Tile> waypoints) {
        this(location1, location2, waypoints, new ArrayList<>());
    }

    public TwoWayLink(Location location1, Location location2, ArrayList<Tile> waypoints, ArrayList<Obstacle> obstacles) {
        new Link(location1, location2, waypoints, obstacles);

        Collections.reverse(waypoints);
        Collections.reverse(obstacles);

        new Link(location2, location1, waypoints, obstacles);
    }
}
