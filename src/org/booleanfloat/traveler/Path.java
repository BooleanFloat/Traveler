package org.booleanfloat.traveler;

import org.booleanfloat.traveler.steps.*;
import org.booleanfloat.traveler.interfaces.Traversable;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.TileMatrix;

import java.util.ArrayList;

public class Path {
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
        Tile pos = ctx.players.local().tile();
        Traversable furthestStep = null;
        int start = 0;
        double minDistance = Double.MAX_VALUE;

        for(int i = 0; i < steps.size(); i++) {
            Tile tile = steps.get(i).getTile(ctx);
            if(Math.abs(pos.x() - tile.x()) > 50 || Math.abs(pos.y() - tile.y()) > 50
                    || tile.floor() != pos.floor() || steps.get(i) instanceof Spell) {
                continue;
            }

            double distance = pos.distanceTo(tile);
            if(distance < minDistance) {
                start = i;
                minDistance = distance;
            }
        }

//        System.out.println(start);

        for(int i = Math.max(0, start - 2); i < Math.min(start + 10, steps.size()); i++) {
            Traversable step = steps.get(i);
            Tile tile = step.getTile(ctx);

//            System.out.println(i + " - " + step);
            TileMatrix matrix = tile.matrix(ctx);

            if(Math.abs(pos.x() - tile.x()) > 50 || Math.abs(pos.y() - tile.y()) > 50
                    || tile.floor() != pos.floor() || (step instanceof ImportantStep && pos.equals(tile))) {
                continue;
            }

            if(step instanceof Spell && furthestStep == null) {
                furthestStep = step;
            }

            if(step instanceof Obstacle || step instanceof Npc) {
                if(!matrix.inViewport() && matrix.onMap() || matrix.inViewport() && step.isObstructing(ctx)) {
                    furthestStep = step;
                    break;
                }
            }
            else if(step instanceof ImportantStep) {
                if(matrix.inViewport() || matrix.onMap()) {
                    furthestStep = step;
                    break;
                }
            }
            else {
                if(matrix.onMap() && !matrix.inViewport() || matrix.inViewport() && matrix.reachable()) {
                    furthestStep = step;
                }
            }
        }

        if(furthestStep == null) {
            furthestStep = steps.get(start);
        }

        lastTraversal = furthestStep;
        return furthestStep.traverse(ctx);
    }
}
