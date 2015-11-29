package org.booleanfloat.traveler;

import org.booleanfloat.traveler.links.Link;
import org.booleanfloat.traveler.steps.Obstacle;
import org.booleanfloat.traveler.steps.Spell;
import org.booleanfloat.traveler.steps.Step;
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
        boolean obstruction = false;

        for(Traversable step : steps) {
            Tile tile = step.getTile(ctx);

            if(Math.abs(pos.x() - tile.x()) > 50 || Math.abs(pos.y() - tile.y()) > 50) {
                continue;
            }

            TileMatrix matrix = tile.matrix(ctx);

            if(tile.floor() == pos.floor()) {

                if(step instanceof Step) {
                    if((matrix.inViewport() && matrix.reachable())
                            || (matrix.onMap() && !matrix.inViewport() && !obstruction)) {
                        furthestStep = step;
                    }
                }
                else if(step instanceof Spell) {
                    furthestStep = step;
                }
                else {
                    if(matrix.inViewport() && step.isObstructing(ctx)) {
                        furthestStep = step;
                    }
                }

                if(furthestStep != null && furthestStep.isObstructing(ctx)) {
                    obstruction = true;
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
