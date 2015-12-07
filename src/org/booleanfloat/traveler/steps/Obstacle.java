package org.booleanfloat.traveler.steps;

import org.booleanfloat.traveler.interfaces.Traversable;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;

import java.util.HashMap;

public class Obstacle implements Traversable {
    protected int id;
    protected String interaction;
    protected Tile position;
    protected int[] bounds;
    protected int interactionDelay;
    protected GameObject object;

    public static class Hitbox {
        public static int[] DOOR_NORTH = new int[]{ 16, 112, -192, -16, 112, 128};
        public static int[] DOOR_EAST = new int[]{ 112, 128, -192, -16, 16, 112};
        public static int[] DOOR_SOUTH = new int[]{ 16, 112, -192, -16, -16, 0};
        public static int[] DOOR_WEST = new int[]{ -16, 0, -192, -16, 16, 112};
    }

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
    public Tile getTile(ClientContext ctx) {
        return getTile();
    }

    @Override
    public boolean isObstructing(ClientContext ctx) {
        object = ctx.objects.select().id(id).at(position).poll();

//        System.out.println(id + "-" + position + " / " + object + " / " + ctx.objects.select().id(id).nearest().poll());

        if(object == null) {
            return false;
        }

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
        if(object == null || !object.inViewport()) {
            return ctx.input.click(position.matrix(ctx).mapPoint(), true);
        }

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
