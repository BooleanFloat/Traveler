package org.booleanfloat.traveler.steps;

import org.booleanfloat.traveler.interfaces.Traversable;
import org.powerbot.script.Condition;
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
        object = ctx.objects.select().id(id).at(position).poll();

        return object.inViewport();
    }

    @Override
    public boolean isTraversable(ClientContext ctx) {
        return true;
    }

    @Override
    public boolean traverse(ClientContext ctx) {
        System.out.println("obstacle object: " + object);

        boolean isInteracting = object != null && object.interact(interaction);

        if(isInteracting) {
            Condition.sleep(500);
        }

        return isInteracting;
    }

    public String toString() {
        return "" + id;
    }
}
