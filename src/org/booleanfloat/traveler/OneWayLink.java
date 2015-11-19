package org.booleanfloat.traveler;

import org.powerbot.script.Tile;

import java.util.ArrayList;

public class OneWayLink {
    public OneWayLink(Location location1, Location location2) {
        this(location1, location2, new ArrayList<>());
    }

    public OneWayLink(Location location1, Location location2, ArrayList<Tile> waypoints) {
        new Link(location1, location2, waypoints);
    }
}
