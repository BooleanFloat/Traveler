package org.booleanfloat.traveler.steps;

import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

public interface Traversable {
    Tile getTile();
    boolean isObstructing(ClientContext ctx);
    boolean isTraversable(ClientContext ctx);
    boolean traverse(ClientContext ctx);
}
