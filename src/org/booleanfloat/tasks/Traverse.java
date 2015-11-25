package org.booleanfloat.tasks;

import org.booleanfloat.traveler.Path;
import org.booleanfloat.traveler.Location;
import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

import java.util.concurrent.Callable;

public class Traverse extends Task<ClientContext> {
    private Location start;
    private Location end;
    private org.booleanfloat.traveler.Path path;

    public Traverse(ClientContext ctx, Location start, Location end) {
        super(ctx);

        this.start = start;
        this.end = end;

        path = Path.calculate(start, end);
    }

    @Override
    public boolean activate() {
        return !end.area.contains(ctx.players.local().tile())
                && !end.area.contains(ctx.movement.destination());
    }

    @Override
    public void execute() {
        if(path.traverse(ctx)) {
            Condition.wait(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    Tile pos = ctx.players.local().tile();
                    Tile dest = ctx.movement.destination();

                    boolean isClose = (Math.abs(pos.x() - dest.x()) < 6 && Math.abs(pos.y() - dest.y()) < 6);
                    boolean isDifferentFloor = pos.floor() != dest.floor();
                    boolean isObstructing = false;

                    if(path.lastTraversal != null) {
                        isObstructing = path.lastTraversal.isObstructing(ctx);
                    }

                    return isClose || isDifferentFloor || isObstructing;
                }
            }, 250, 10);
        }
    }

}
