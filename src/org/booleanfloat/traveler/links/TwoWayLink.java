package org.booleanfloat.traveler.links;

import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.interfaces.Traversable;

import java.util.ArrayList;
import java.util.Collections;

public class TwoWayLink {
    public TwoWayLink(Location location1, Location location2) {
        this(location1, location2, new ArrayList<>());
    }

    public TwoWayLink(Location location1, Location location2, ArrayList<Traversable> steps) {
        new Link(location1, location2, steps);

        Collections.reverse(steps);
        new Link(location2, location1, steps);
    }
}
