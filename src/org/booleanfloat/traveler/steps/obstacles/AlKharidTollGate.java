package org.booleanfloat.traveler.steps.obstacles;

import org.booleanfloat.traveler.steps.Obstacle;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

public class AlKharidTollGate extends Obstacle {
    public AlKharidTollGate(int id) {
        super(id, "Pay-toll(10gp)", new Tile(3268, 3227, 0), new int[]{-32, 32, -196, 0, 0, 128});
    }

    @Override
    public boolean isObstructing(ClientContext ctx) {
        object = ctx.objects.select().id(id).at(position).poll();

        if(bounds != null) {
            object.bounds(bounds);
        }

        return object.inViewport() && ctx.players.local().tile().x() <= 3267;
    }
}
