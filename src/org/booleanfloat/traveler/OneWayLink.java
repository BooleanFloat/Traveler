package org.booleanfloat.traveler;

import org.booleanfloat.traveler.steps.Traversable;

import java.util.ArrayList;

public class OneWayLink {
    public OneWayLink(Location start, Location end) {
        this(start, end, new ArrayList<>());
    }

    public OneWayLink(Location start, Location end, ArrayList<Traversable> steps) {
        new Link(start, end, steps);
    }

//    public OneWayLink(Location start, Location end, ArrayList<Tile> waypoints) {
//        this(start, end, waypoints, new ArrayList<>());
//    }
//
//    public OneWayLink(Location start, Location end, ArrayList<Tile> waypoints, ArrayList<Obstacle> obstacles) {
//        new Link(start, end, waypoints, obstacles);
//    }
}
