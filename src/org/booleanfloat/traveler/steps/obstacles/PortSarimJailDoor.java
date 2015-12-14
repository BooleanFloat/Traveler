package org.booleanfloat.traveler.steps.obstacles;

import org.booleanfloat.traveler.regions.asgarnia.PortSarim;
import org.booleanfloat.traveler.steps.Obstacle;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

public class PortSarimJailDoor extends Obstacle {
    public PortSarimJailDoor() {
        super(9565, "Pick-lock", 3000, new Tile(3183, 9611, 0), Hitbox.DOOR_NORTH);
    }

    @Override
    public boolean isObstructing(ClientContext ctx) {
        object = ctx.objects.select().id(id).at(position).poll();

        if(bounds != null) {
            object.bounds(bounds);
        }

        return object.inViewport() && PortSarim.ShantyPassCell.area.contains(ctx.players.local());
    }
}
