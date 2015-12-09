package org.booleanfloat.traveler.steps;

import org.booleanfloat.traveler.interfaces.Traversable;
import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Component;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Widget;

import java.rmi.ConnectIOException;

public class Npc implements Traversable {
    protected int id;
    protected String interaction;
    protected Area area;
    protected org.powerbot.script.rt4.Npc npc;

    public Npc(int id, String interaction, Area area) {
        this.id = id;
        this.interaction = interaction;
        this.area = area;
    }

    @Override
    public Tile getTile() {
        return area.getCentralTile();
    }

    @Override
    public Tile getTile(ClientContext ctx) {
        return getTile();
    }

    @Override
    public boolean isObstructing(ClientContext ctx) {
        npc = ctx.npcs.select().id(id).within(area).nearest().poll();

        return npc.inViewport();
    }

    @Override
    public boolean isTraversable(ClientContext ctx) {
        return true;
    }

    @Override
    public boolean traverse(ClientContext ctx) {
        boolean isInteracting = npc != null && npc.interact(interaction);

        if(isInteracting) {
            Condition.sleep(500);
        }

        return isInteracting;
    }

    public String toString() {
        return "" + id;
    }
}
