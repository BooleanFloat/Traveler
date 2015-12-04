package org.booleanfloat.traveler.steps.obstacles;

import org.booleanfloat.traveler.regions.asgarnia.Taverly;
import org.booleanfloat.traveler.steps.Obstacle;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

public class TaverlyOuthouseStile extends Obstacle {
    public enum Direction { IN, OUT }

    private Direction direction;

    public TaverlyOuthouseStile(Direction direction) {
        super(993, "Climb-over", new Tile(2918, 3438, 0));
        this.direction = direction;
        this.interactionDelay = 1500;
    }

    @Override
    public boolean isObstructing(ClientContext ctx) {
        object = ctx.objects.select().id(id).at(position).poll();

        if(direction == Direction.IN) {
            return object.inViewport() && !Taverly.OuthouseFence.area.contains(ctx.players.local());
        }
        else {
            return object.inViewport() && Taverly.OuthouseFence.area.contains(ctx.players.local());
        }
    }

}
