package org.booleanfloat.traveler.steps.obstacles;

import org.booleanfloat.traveler.steps.Obstacle;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

public class DraynorManorFrontDoor extends Obstacle {

    public DraynorManorFrontDoor(int id, Tile position) {
        super(id, "Open", position, Hitbox.DOOR_NORTH);
    }

    @Override
    public boolean isObstructing(ClientContext ctx) {
        object = ctx.objects.select().id(id).at(position).poll();

        if(bounds != null) {
            object.bounds(bounds);
        }

        return object.inViewport() && ctx.players.local().tile().y() <= 3353;
    }
}
