package org.booleanfloat.traveler.links;

import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.interfaces.Traversable;

import java.util.ArrayList;

public class OneWayLink {
    public OneWayLink(Location start, Location end) {
        this(start, end, new ArrayList<>());
    }

    public OneWayLink(Location start, Location end, ArrayList<Traversable> steps) {
        new Link(start, end, steps);
    }
}
