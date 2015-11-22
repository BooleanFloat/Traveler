package org.booleanfloat.traveler;

import org.booleanfloat.traveler.steps.Traversable;

import java.util.ArrayList;

public class Path {
    public static Path calculate(Location start, Location end) {
        ArrayList<Link> links = Dijkstra.getLinks(start, end);
        ArrayList<Traversable> steps = new ArrayList<>();

        for(Link link : links) {
            steps.addAll(link.getSteps());
        }

        return new Path(start, end, steps);
    }

    private Location start;
    private Location end;
    private ArrayList<Traversable> steps;

    public Path(Location start, Location end, ArrayList<Traversable> steps) {
        this.start = start;
        this.end = end;
        this.steps = steps;
    }
}
