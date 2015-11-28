package org.booleanfloat.traveler.steps;

import org.booleanfloat.traveler.interfaces.Traversable;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;

public class Obstacle implements Traversable {
    protected int id;
    protected String interaction;
    protected Tile position;
    protected int[] bounds;
    protected int interactionDelay;
    protected GameObject object;

    public Obstacle(int id, String interaction, Tile position) {
        this(id, interaction, position, null);
    }

    public Obstacle(int id, String interaction, Tile position, int[] bounds) {
        this(id, interaction, 500, position, bounds);
    }

    public Obstacle(int id, String interaction, int interactionDelay, Tile position, int[] bounds) {
        this.id = id;
        this.interaction = interaction;
        this.interactionDelay = interactionDelay;
        this.position = position;
        this.bounds = bounds;
    }

    @Override
    public Tile getTile() {
        return position;
    }

    @Override
    public boolean isObstructing(ClientContext ctx) {
        object = ctx.objects.select().id(id).at(position).poll();

        System.out.println(object + " - " + ctx.objects.select().id(id).nearest().poll());

        if(bounds != null) {
            object.bounds(bounds);
        }

        return object.inViewport();
    }

    @Override
    public boolean isTraversable(ClientContext ctx) {
        return true;
    }

    @Override
    public boolean traverse(ClientContext ctx) {
        boolean isInteracting = object != null && object.interact(interaction);

        if(isInteracting) {
            Condition.sleep(this.interactionDelay);
        }

        return isInteracting;
    }

    public String toString() {
        return "" + id;
    }
}
