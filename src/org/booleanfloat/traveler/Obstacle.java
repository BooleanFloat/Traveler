package org.booleanfloat.traveler;

import org.powerbot.script.Area;
import org.powerbot.script.Filter;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Game;
import org.powerbot.script.rt4.GameObject;

public class Obstacle {
    private int id;
    private String interaction;
    private Tile position;
    private Area area;
    private GameObject object;

    public Obstacle(int id, String interaction, Tile position) {
        this.id = id;
        this.interaction = interaction;
        this.position = position;
    }

    public boolean isObstructing(ClientContext ctx) {
        object = ctx.objects.id(id).select(new Filter<GameObject>() {
            @Override
            public boolean accept(GameObject gameObject) {
                return gameObject.tile().equals(position);
            }
        }).nearest().poll();

//        System.out.println(object + " - " + object.inViewport());

        return object.inViewport();
    }

    public boolean traverse(ClientContext ctx) {
        return object != null && object.interact(interaction);
    }

    public String toString() {
        return "" + id;
    }
}
