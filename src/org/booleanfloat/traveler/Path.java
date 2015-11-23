package org.booleanfloat.traveler;

import org.booleanfloat.traveler.steps.Obstacle;
import org.booleanfloat.traveler.steps.Step;
import org.booleanfloat.traveler.steps.Traversable;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.TileMatrix;

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
    public Traversable lastTraversal;

    public Path(Location start, Location end, ArrayList<Traversable> steps) {
        this.start = start;
        this.end = end;
        this.steps = steps;
    }

    public boolean traverse(ClientContext ctx) {
        int floor = ctx.players.local().tile().floor();
        Traversable furthestStep = null;

        for(Traversable step : steps) {
            TileMatrix matrix = step.getTile().matrix(ctx);
            if(step.getTile().floor() == floor) {

                if(step instanceof Step) {
                    if(matrix.reachable() && (matrix.onMap() || matrix.inViewport())) {
                        furthestStep = step;
                    }
                }
                else if(step instanceof Obstacle) {
                    if(matrix.inViewport()) {
                        furthestStep = step;
                    }
                }

                if(furthestStep != null && furthestStep.isObstructing(ctx)) {
                    break;
                }
            }
        }

        if(furthestStep == null) {
            return false;
        }

        lastTraversal = furthestStep;
        return furthestStep.traverse(ctx);
    }
}
