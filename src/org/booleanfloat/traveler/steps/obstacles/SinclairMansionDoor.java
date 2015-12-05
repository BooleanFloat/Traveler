package org.booleanfloat.traveler.steps.obstacles;

import org.booleanfloat.traveler.steps.Obstacle;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

public class SinclairMansionDoor extends Obstacle {
    public enum Direction { IN, OUT };

    private Direction direction;

    public SinclairMansionDoor(int id, Tile position, Direction direction) {
        super(id, "Open", position, new int[]{0, 128, -160, 0, 112, 144});

        this.direction = direction;
    }

    @Override
    public boolean isObstructing(ClientContext ctx) {
        object = ctx.objects.select().id(id).at(position).poll();

        if(bounds != null) {
            object.bounds(bounds);
        }

        if(direction == Direction.IN) {
            return object.inViewport() && ctx.players.local().tile().y() <= 3572;
        }
        else {
            return object.inViewport() && ctx.players.local().tile().y() >= 3573;
        }
    }
}
