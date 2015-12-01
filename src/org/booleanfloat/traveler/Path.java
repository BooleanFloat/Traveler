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
        boolean further = false;
        double prevDistance = 1000000000;
        double minDistance = Double.MAX_VALUE;

        for(Traversable step : steps) {
            Tile tile = step.getTile(ctx);
            if(Math.abs(pos.x() - tile.x()) > 50 || Math.abs(pos.y() - tile.y()) > 50
                    || tile.floor() != pos.floor() || pos.equals(tile)) {
                continue;
            }

            double distance = pos.distanceTo(tile);
            if(distance < minDistance) {
                minDistance = distance;
            }
        }

        for(Traversable step : steps) {
            Tile tile = step.getTile(ctx);
            TileMatrix matrix;
            double distance;

            if(Math.abs(pos.x() - tile.x()) > 50 || Math.abs(pos.y() - tile.y()) > 50
                    || tile.floor() != pos.floor() || lastTraversal == step) {
                continue;
            }

            matrix = tile.matrix(ctx);
            distance = Math.abs(pos.distanceTo(tile));

            if(distance >= prevDistance && prevDistance - 1.5 < minDistance) {
                further = true;
            }

            prevDistance = distance;

            if(step instanceof Spell && furthestStep == null) {
                furthestStep = step;
            }

            if(further) {
                if(step instanceof Obstacle || step instanceof Npc) {
                    if(matrix.inViewport() && step.isObstructing(ctx)) {
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
        }

        if(furthestStep == null) {
            return false;
        }

        lastTraversal = furthestStep;
        return furthestStep.traverse(ctx);
    }
}
