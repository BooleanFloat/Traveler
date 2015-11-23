package org.booleanfloat.traveler.steps;

import org.booleanfloat.traveler.steps.Traversable;
import org.powerbot.script.Filter;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;

public class Obstacle implements Traversable {
    private int id;
    private String interaction;
    private Tile position;
    private GameObject object;

    public Obstacle(int id, String interaction, Tile position) {
        this.id = id;
        this.interaction = interaction;
        this.position = position;
    }

    @Override
    public Tile getTile() {
        return position;
    }

    @Override
    public boolean isObstructing(ClientContext ctx) {
        ctx.objects.select();
        object = ctx.objects.id(id).select(new Filter<GameObject>() {
            @Override
            public boolean accept(GameObject gameObject) {
                return gameObject.tile().equals(position);
            }
        }).poll();

        return object.inViewport();
    }

    @Override
    public boolean isTraversable(ClientContext ctx) {
        return true;
    }

    @Override
    public boolean traverse(ClientContext ctx) {
        System.out.println("obstacle object: " + object);

        return object != null && object.interact(interaction);
    }

    public String toString() {
        return "" + id;
    }
}
