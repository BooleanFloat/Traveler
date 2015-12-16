package org.booleanfloat.traveler.links;

import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.interfaces.Traversable;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class OneWayLink {
    public OneWayLink(Location start, Location end) {
        this(start, end, new ArrayList<Traversable>(), null);
    }

    public OneWayLink(Location start, Location end, ArrayList<Traversable> steps) {
        this(start, end, steps, null);
    }

    public OneWayLink(Location start, Location end, ArrayList<Traversable> steps, Callable<Boolean> requirement) {
        new Link(start, end, steps, requirement);
    }
}
