package org.booleanfloat.traveler.links;

import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.steps.Step;
import org.booleanfloat.traveler.interfaces.Traversable;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.TileMatrix;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public class Link {
    protected Location start;
    protected Location end;
    protected ArrayList<Traversable> steps;
    protected Callable<Boolean> requirement;

    private double weight;

    public Link() {}

    public Link(Location start, Location end, ArrayList<Traversable> steps) {
        this(start, end, steps, null);
    }

    public Link(Location start, Location end, ArrayList<Traversable> steps, Callable<Boolean> requirement) {
        this.start = start;
        this.end = end;
        this.steps = steps;
        this.requirement = requirement;

        // add start and end to the steps array
        steps.add(0, new Step(this.start.area.getCentralTile()));
        steps.add(new Step(this.end.area.getCentralTile()));

        this.steps = autofillSteps(steps);

        this.start.addLink(end, this);
    }

    private ArrayList<Traversable> autofillSteps(ArrayList<Traversable> steps) {
        ArrayList<Traversable> newSteps = new ArrayList<Traversable>();

        for(int i = 0; i < steps.size() -1; i++) {
            Traversable start = steps.get(i);
            Traversable end = steps.get(i + 1);
            Tile startTile = start.getTile();
            Tile endTile = end.getTile();

            // always add the current step to the new steps array
            newSteps.add(start);

            // only fill path between two Step objects
            if(!(start instanceof Step) || !(end instanceof Step)) {
                continue;
            }

            // only fill path between two Steps that are on the same floor
            if(startTile.floor() != endTile.floor()) {
                continue;
            }

            int dx = endTile.x() - startTile.x();
            int dy = endTile.y() - startTile.y();
            double distance = startTile.distanceTo(endTile);
            double amount = Math.round(distance / 4);

            for(int j = 1; j < amount; j++) {
                double x = startTile.x() + (j * dx / amount);
                double y = startTile.y() + (j * dy / amount);

                newSteps.add(new Step(new Tile((int) x, (int) y, startTile.floor())));
            }
        }

        newSteps.add(steps.get(steps.size() - 1));

        return newSteps;
    }

    public Location getOtherLocation(Location location) {
        if(location == start) {
            return end;
        }

        return start;
    }

    public double getWeight() {
        double weight = 0;

        for(int i = 0; i < steps.size() -1; i++) {
            Traversable start = steps.get(i);
            Traversable end = steps.get(i + 1);

            weight += Math.abs(start.getTile().compareTo(end.getTile()));
        }

        return weight;
    }

    public ArrayList<Traversable> getSteps() {
        return steps;
    }

    public boolean hasRequirements() {
        if(requirement != null) {
            try {
                return requirement.call();
            }
            catch (Exception e) {
                return false;
            }
        }

        return true;
    }

    public String toString() {
        return this.start + " -> " + this.end;
    }

    public Location getEnd() {
        return end;
    }

    public Location getStart() {
        return start;
    }
}
