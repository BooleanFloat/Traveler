package org.booleanfloat.traveler;

import org.powerbot.script.Tile;

import java.util.ArrayList;
import java.util.Collections;

public class TwoWayLink {
    public TwoWayLink(Location location1, Location location2) {
        this(location1, location2, new ArrayList<>());
    }

    public TwoWayLink(Location location1, Location location2, ArrayList<Tile> waypoints) {
        new Link(location1, location2, waypoints);
        Collections.reverse(waypoints);
        new Link(location2, location1, waypoints);
    }
}
