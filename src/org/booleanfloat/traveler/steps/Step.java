package org.booleanfloat.traveler.steps;

import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

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
    public boolean isObstructing(ClientContext ctx) {
        return false;
    }

    @Override
    public boolean isTraversable(ClientContext ctx) {
        return true;
    }

    @Override
    public boolean traverse(ClientContext ctx) {
        // click on minimap or on ground tile
        return false;
    }
}
