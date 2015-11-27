package org.booleanfloat.traveler.steps.obstacles;

import org.booleanfloat.traveler.regions.misthalin.Lumbridge;
import org.booleanfloat.traveler.steps.Obstacle;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

public class HamJailDoor extends Obstacle {
    public HamJailDoor() {
        super(5501, "Pick-lock", 3000, new Tile(3183, 9611, 0), new int[]{0, 32, -256, 0, 0, 128});
    }

    @Override
    public boolean isObstructing(ClientContext ctx) {
        object = ctx.objects.select().id(id).at(position).poll();

        if(bounds != null) {
            object.bounds(bounds);
        }

        return object.inViewport() && Lumbridge.HamJail.area.contains(ctx.players.local());
    }
}
