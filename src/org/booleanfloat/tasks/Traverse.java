package org.booleanfloat.tasks;

import org.booleanfloat.traveler.Dijkstra;
import org.booleanfloat.traveler.Location;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class Traverse extends Task<ClientContext> {
    private Location start;
    private Location end;

    public Traverse(ClientContext ctx, Location start, Location end) {
        super(ctx);

        this.start = start;
        this.end = end;
    }

    @Override
    public boolean activate() {
        return !end.area.contains(ctx.players.local());
    }

    @Override
    public void execute() {
        System.out.println("traverse " + start + " -> " + end);

        ArrayList<Tile> path = Dijkstra.getPath(start, end);
        Tile[] tiles = path.toArray(new Tile[path.size()]);

        if(ctx.movement.newTilePath(tiles).traverse()) {
            Condition.wait(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    int dx = ctx.players.local().tile().x() - ctx.movement.destination().x();
                    int dy = ctx.players.local().tile().y() - ctx.movement.destination().y();

                    return Math.abs(dx) < 5 && Math.abs(dy) < 5;
                }
            }, 250, 5);
        }
    }

}
