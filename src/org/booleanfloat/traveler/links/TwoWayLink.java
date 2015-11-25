package org.booleanfloat.traveler.links;

import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.interfaces.Traversable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;

public class TwoWayLink {
    public TwoWayLink(Location location1, Location location2) {
        this(location1, location2, new ArrayList<>(), null);
    }

    public TwoWayLink(Location location1, Location location2, ArrayList<Traversable> steps) {
        this(location1, location2, steps, null);
    }

    public TwoWayLink(Location location1, Location location2, ArrayList<Traversable> steps, Callable<Boolean> requirement) {
        new Link(location1, location2, steps, requirement);

        Collections.reverse(steps);
        new Link(location2, location1, steps, requirement);
    }
}
