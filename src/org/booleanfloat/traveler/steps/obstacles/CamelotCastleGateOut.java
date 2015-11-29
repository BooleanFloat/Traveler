package org.booleanfloat.traveler.steps.obstacles;

import org.booleanfloat.traveler.steps.Obstacle;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

public class CamelotCastleGateOut extends Obstacle {
    public CamelotCastleGateOut(int id, Tile position) {
        super(id, "Open", position, new int[]{0, 128, -196, 0, 96, 128});
    }

    @Override
    public boolean isObstructing(ClientContext ctx) {
        object = ctx.objects.select().id(id).at(position).poll();

        if(bounds != null) {
            object.bounds(bounds);
        }

        return object.inViewport() && ctx.players.local().tile().y() >= 3483;
    }
}
