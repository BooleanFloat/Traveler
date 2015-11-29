package org.booleanfloat.traveler.interfaces;

import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

public interface Traversable {
    Tile getTile();
    Tile getTile(ClientContext ctx);
    boolean isObstructing(ClientContext ctx);
    boolean isTraversable(ClientContext ctx);
    boolean traverse(ClientContext ctx);
}
