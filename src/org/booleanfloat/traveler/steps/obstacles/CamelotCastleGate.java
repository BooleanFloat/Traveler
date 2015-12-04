package org.booleanfloat.traveler.steps.obstacles;

import org.booleanfloat.traveler.steps.Obstacle;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

public class CamelotCastleGate extends Obstacle {
    public enum Direction { IN, OUT }

    private Direction direction;

    public CamelotCastleGate(int id, Tile position, Direction direction) {
        super(id, "Open", position, new int[]{0, 128, -196, 0, 96, 128});

        this.direction = direction;
    }

    @Override
    public boolean isObstructing(ClientContext ctx) {
        object = ctx.objects.select().id(id).at(position).poll();

        if(bounds != null) {
            object.bounds(bounds);
        }

        if(direction == Direction.IN) {
            return object.inViewport() && ctx.players.local().tile().y() <= 3482;
        }
        else {
            return object.inViewport() && ctx.players.local().tile().y() >= 3483;
        }
    }
}
