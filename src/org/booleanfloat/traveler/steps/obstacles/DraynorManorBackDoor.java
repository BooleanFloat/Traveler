package org.booleanfloat.traveler.steps.obstacles;

import org.booleanfloat.traveler.regions.misthalin.Draynor;
import org.booleanfloat.traveler.steps.Obstacle;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

public class DraynorManorBackDoor extends Obstacle {
    public DraynorManorBackDoor() {
        super(136, "Open", new Tile(3123, 3361, 0), Hitbox.DOOR_SOUTH);
    }

    @Override
    public boolean isObstructing(ClientContext ctx) {
        object = ctx.objects.select().id(id).at(position).poll();

        if(bounds != null) {
            object.bounds(bounds);
        }

        return object.inViewport() && Draynor.ManorKitchen.area.contains(ctx.players.local());
    }
}
