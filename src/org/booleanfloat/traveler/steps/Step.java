package org.booleanfloat.traveler.steps;

import org.booleanfloat.traveler.interfaces.Traversable;
import org.powerbot.script.Random;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.TileMatrix;

import java.awt.*;

public class Step implements Traversable {
    private Tile tile;

    public Step(Tile tile) {
        this.tile = tile;
    }

    @Override
    public Tile getTile() {
        return this.tile;
    }

    @Override
    public Tile getTile(ClientContext ctx) {
        return getTile();
    }

    @Override
    public boolean isObstructing(ClientContext ctx) {
        return false;
    }

    @Override
    public boolean isTraversable(ClientContext ctx) {
        return true;
    }

    @Override
    public boolean traverse(ClientContext ctx) {
        TileMatrix matrix = this.tile.matrix(ctx);
        Point mapPoint = matrix.mapPoint();
        Point worldPoint = matrix.centerPoint();
        Point mousePoint = ctx.input.getLocation();

        if(ctx.movement.destination().distanceTo(this.tile) < 3) {
            return false;
        }

        if(worldPoint.x != -1 && worldPoint.y != -1) {
            if (worldPoint.distance(mousePoint) < mapPoint.distance(mousePoint)) {
                return ctx.input.click(worldPoint, true);
            }
        }

        return ctx.input.click(mapPoint, true);
    }
}
