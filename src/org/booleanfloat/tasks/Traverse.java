package org.booleanfloat.tasks;

import org.booleanfloat.traveler.Path;
import org.booleanfloat.traveler.Location;
import org.powerbot.script.Condition;
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
            System.out.println("following path");

            Condition.wait(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    int dx = ctx.players.local().tile().x() - ctx.movement.destination().x();
                    int dy = ctx.players.local().tile().y() - ctx.movement.destination().y();

                    boolean obstructing = false;

                    if(path.lastTraversal != null) {
                        obstructing = path.lastTraversal.isObstructing(ctx);
                    }

                    return Math.abs(dx) < 4 && Math.abs(dy) < 4 && !obstructing;
                }
            }, 250, 6);
        }
    }

}
